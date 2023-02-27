package com.a505.hobbyit.hobbyarticlelike.service;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticleRepository;
import com.a505.hobbyit.hobbyarticle.exception.NoSuchHobbyArticleException;
import com.a505.hobbyit.hobbyarticlelike.domain.HobbyArticleLike;
import com.a505.hobbyit.hobbyarticlelike.domain.HobbyArticleLikeRepository;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class HobbyArticleLikeServiceImpl implements HobbyArticleLikeService{

    private final HobbyArticleLikeRepository hobbyArticleLikeRepository;
    private final MemberRepository memberRepository;
    private final HobbyArticleRepository hobbyArticleRepository;

    @Transactional
    @Override
    public void like(String memberId, Long articleId) {
        Member member = readMember(memberId);
        HobbyArticle hobbyArticle = readHobbyArticle(articleId);
        if(hobbyArticleLikeRepository.existsByMemberAndHobbyArticle(member, hobbyArticle)) {
            hobbyArticleLikeRepository.deleteHobbyArticleLikesByMemberAndHobbyArticle(member, hobbyArticle);
            return;
        }
        HobbyArticleLike hobbyArticleLike = HobbyArticleLike.builder()
                .member(member)
                .hobbyArticle(hobbyArticle)
                .build();
        hobbyArticleLikeRepository.save(hobbyArticleLike);
    }

    public Member readMember(String memberId){
        return memberRepository
                .findById(Long.parseLong(memberId))
                .orElseThrow(NoSuchElementException::new);
    }

    public HobbyArticle readHobbyArticle(Long hobbyArticleId){
        return hobbyArticleRepository
                .findById(hobbyArticleId)
                .orElseThrow(NoSuchHobbyArticleException::new);
    }
}
