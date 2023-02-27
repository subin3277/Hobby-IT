package com.a505.hobbyit.hobbymember.domain;

import com.a505.hobbyit.article.dto.OwnHobbyResponse;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import com.a505.hobbyit.member.domain.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class HobbyMemberQRepositoryImpl implements HobbyMemberQRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    QHobbyMember hobbyMember = QHobbyMember.hobbyMember;

    public List<OwnHobbyResponse> getOwnHobbyList(Member member) {
        List<HobbyMember> hobbyMembers = queryFactory
                .selectFrom(hobbyMember)
                .where(
                        hobbyMember.member.eq(member),
                        hobbyMember.privilege.eq(HobbyMemberPrivilege.OWNER)
                ).fetch();
        List<OwnHobbyResponse> result = new ArrayList<>();
        for (HobbyMember hobbyMember : hobbyMembers)
            result.add(new OwnHobbyResponse().of(hobbyMember));
        return result;
    }

    @Override
    public void deleteHobbyMember(Long hobbyMemberId) {
        queryFactory.delete(hobbyMember)
                .where(hobbyMember.id.eq(hobbyMemberId))
                .execute();
        em.flush();
    }

    @Override
    public List<HobbyMember> findByHobbyId(Hobby hobby) {
        return queryFactory.selectFrom(hobbyMember)
                .where(hobbyMember.hobby.eq(hobby))
                .orderBy(hobbyMember.privilege.desc(), hobbyMember.member.nickname.asc())
                .fetch();
    }
}
