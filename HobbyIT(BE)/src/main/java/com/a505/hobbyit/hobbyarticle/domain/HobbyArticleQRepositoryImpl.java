package com.a505.hobbyit.hobbyarticle.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbyarticle.dto.HobbyArticleResponse;
import com.a505.hobbyit.hobbyarticle.dto.HobbyNoticeResponse;
import com.a505.hobbyit.hobbyarticle.enums.HobbyArticleCategory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class HobbyArticleQRepositoryImpl implements HobbyArticleQRepository{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    QHobbyArticle hobbyArticle = QHobbyArticle.hobbyArticle;

    @Override
    public Slice<HobbyArticleResponse> findHobbyArticle(Long storedId, Hobby hobby, Pageable pageable) {
        List<HobbyArticle> result = queryFactory
                .selectFrom(hobbyArticle)
                .where(
                    ltStoreId(storedId), // 첫 번째 페이지에서는 id< 파라미터를 사용하지 않기 때문에 적용시킨다.
                    // hobby가 일치하며
                    hobbyArticle.hobby.eq(hobby),
                    // 카테고리가 일반 게시글일 경우
                    hobbyArticle.category.eq(HobbyArticleCategory.GENERAL)
                ).orderBy(hobbyArticle.id.desc())
                .limit(pageable.getPageSize()+1)
                .fetch();


        List<HobbyArticleResponse> responses = new ArrayList<>();
        for (HobbyArticle article : result) {
            log.info("================================");
            log.info(article.getThumbnailPath());
            log.info(article.getContent() + " " + article.getId());
        }
        for (HobbyArticle article : result) {
            responses.add(new HobbyArticleResponse().of(article));
        }
        return checkLastPage(pageable, responses);
    }

    @Override
    public Slice<HobbyArticleResponse> searchHobbyArticle(Long storedId, String keyword, Hobby hobby, Pageable pageable) {
        List<HobbyArticle> result = queryFactory
                .selectFrom(hobbyArticle)
                .where(
                        // no-offset 페이징 처리
                        ltStoreId(storedId),
                        // hobby가 일치하는지 확인
                        hobbyArticle.hobby.eq(hobby),
                        // 카테고리가 일반 게시글인지 확인
                        hobbyArticle.title.contains(keyword),
                        // 검색 키워드를 포함하는지 확인
                        hobbyArticle.category.eq(HobbyArticleCategory.GENERAL)
                ).orderBy(hobbyArticle.id.desc())
                .limit(pageable.getPageSize()+1)
                .fetch();
        List<HobbyArticleResponse> responses = new ArrayList<>();
        for (HobbyArticle article : result) {
            responses.add(new HobbyArticleResponse().of(article));
        }
        return checkLastPage(pageable, responses);
    }

    @Override
    public Page<HobbyNoticeResponse> findHobbyNotice(Hobby hobby, Pageable pageable) {
        List<HobbyArticle> result = queryFactory
                .selectFrom(hobbyArticle)
                .where(
                        hobbyArticle.hobby.eq(hobby),
                        hobbyArticle.category.eq(HobbyArticleCategory.NOTICE)
                ).orderBy(hobbyArticle.id.desc())
                .limit(pageable.getPageSize()+1)
                .fetch();

        List<HobbyNoticeResponse> responses = new ArrayList<>();

        for (HobbyArticle article : result) responses.add(new HobbyNoticeResponse().of(article));

        return new PageImpl<>(responses);
    }

    @Override
    public Page<HobbyNoticeResponse> searchHobbyNotice(Hobby hobby, String keyword, Pageable pageable) {
        Page<HobbyArticle> result = new PageImpl<>(queryFactory
                .selectFrom(hobbyArticle)
                .where(
                        hobbyArticle.hobby.eq(hobby),
                        hobbyArticle.category.eq(HobbyArticleCategory.NOTICE),
                        hobbyArticle.title.contains(keyword)
                ).orderBy(hobbyArticle.id.desc())
                .limit(pageable.getPageSize()+1)
                .fetch());

        List<HobbyNoticeResponse> responses = new ArrayList<>();

        for (HobbyArticle article : result)
            responses.add(new HobbyNoticeResponse().of(article));

        return new PageImpl<>(responses);
    }

    // no-offset 방식 처리하는 메서드
    private BooleanExpression ltStoreId(Long storeId) {
        if (storeId == null) {
            return null;
        }
        return hobbyArticle.id.lt(storeId);
    }

    // 무한 스크롤 방식 처리하는 메서드
    private Slice<HobbyArticleResponse> checkLastPage(Pageable pageable, List<HobbyArticleResponse> results) {

        boolean hasNext = false;

        // 조회한 결과 개수가 요청한 페이지 사이즈보다 크면 뒤에 더 있음, next = true
        if (results.size() > pageable.getPageSize()) {
            hasNext = true;
            results.remove(pageable.getPageSize());
        }
        return new SliceImpl<>(results, pageable, hasNext);
    }


}
