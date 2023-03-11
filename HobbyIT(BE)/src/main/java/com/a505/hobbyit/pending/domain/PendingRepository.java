package com.a505.hobbyit.pending.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.pending.enums.PendingAllow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PendingRepository extends JpaRepository<Pending, Long> {
    boolean existsByMemberAndHobby(Member member, Hobby hobby);
    List<Pending> findAllByHobbyAndPendingAllow(Hobby hobby, PendingAllow pendingAllow);
    List<Pending> getAllByHobbyAndPendingAllow(Hobby hobby, PendingAllow pendingAllow);
}
