package com.a505.hobbyit.hobbymember.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HobbyMemberRepository extends JpaRepository<HobbyMember, Long>, HobbyMemberQRepository {
    Optional<HobbyMember> findByMemberAndHobby(Member member, Hobby hobby);
    HobbyMember getHobbyMemberByMemberAndHobby(Member member, Hobby hobby);
    Boolean existsByMemberAndHobby(Member member, Hobby hobby);
    Optional<HobbyMember> findByMember(Member member);
}
