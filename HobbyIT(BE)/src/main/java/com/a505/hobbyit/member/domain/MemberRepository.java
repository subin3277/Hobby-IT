package com.a505.hobbyit.member.domain;

import com.a505.hobbyit.member.enums.MemberIsSns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    Optional<Member> findByEmailAndName(String email, String name);

    Optional<Member> findByNickname(String nickname);

    boolean existsByIdAndNickname(String id, String nickname);

    boolean existsByEmailAndIsSns(String email, MemberIsSns aTrue);
}
