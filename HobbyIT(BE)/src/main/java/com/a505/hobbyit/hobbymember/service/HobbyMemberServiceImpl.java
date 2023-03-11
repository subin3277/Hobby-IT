package com.a505.hobbyit.hobbymember.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HobbyMemberServiceImpl implements HobbyMemberService{

    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final HobbyMemberRepository hobbyMemberRepository;

    @Transactional
    @Override
    public void updatePrivilege(final String memberId, Long hobbyId, Long targetId, HobbyMemberUpdateRequest request) {
        HobbyMember hobbyMember = hobbyMemberRepository
                .findById(targetId)
                .orElseThrow(NoSuchHobbyMemberException::new);
        checkPrivilege(hobbyId, memberId);
        hobbyMember.updatePrivilege(request.getPrivilege());
    }

    @Transactional
    @Override
    public void kickHobbyMember(String memberId, Long hobbyId, Long targetId) {
        checkPrivilege(hobbyId, memberId);

        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository.deleteHobbyMember(targetId);
        hobby.updateCnt();
        log.info("===== Member count is " + hobby.getHobbyMembers().size()+"=====");
    }

    @Transactional
    @Override
    public void resignHobbyMember(String memberId, Long hobbyId) {

        Member member = memberRepository
                .findById(Long.parseLong(memberId))
                .orElseThrow(NoSuchElementException::new);

        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);

        HobbyMember hobbyMember = hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new);

        hobbyMemberRepository.deleteHobbyMember(hobbyMember.getId());
        hobby.updateCnt();
    }

    @Override
    public Hobby checkPrivilege(Long hobbyId, String memberId){
        Member member = memberRepository
                .findById(Long.parseLong(memberId))
                .orElseThrow(NoSuchElementException::new);
        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new)
                .checkPrivilege();
        return hobby;
    }

    @Override
    public void checkHobbyMember(Long memberId, Long hobbyId) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(NoSuchElementException::new);
        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new);
    }
}
