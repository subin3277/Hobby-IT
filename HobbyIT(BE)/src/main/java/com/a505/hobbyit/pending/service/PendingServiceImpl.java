package com.a505.hobbyit.pending.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.enums.HobbyFree;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberState;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.member.exception.InvalidedRefreshTokenException;
import com.a505.hobbyit.pending.exception.DuplicatedPendingException;
import com.a505.hobbyit.pending.domain.Pending;
import com.a505.hobbyit.pending.domain.PendingRepository;
import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;
import com.a505.hobbyit.pending.enums.PendingAllow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PendingServiceImpl implements PendingService{

    private final HobbyRepository hobbyRepository;
    private final MemberRepository memberRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final PendingRepository pendingRepository;

    @Transactional
    @Override
    public void join(String memberId, Long hobbyId, PendingRequest request) {

        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(InvalidedRefreshTokenException::new);
        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);

        if(pendingRepository.existsByMemberAndHobby(member, hobby) || hobbyMemberRepository.existsByMemberAndHobby(member, hobby))
            throw new DuplicatedPendingException();

        hobby.isCheckOverCapacity();

        if(hobby.getFree().equals(HobbyFree.FREE)){
            HobbyMember hobbyMember = new HobbyMember().ofGeneral(member, hobby);
            hobbyMemberRepository.save(hobbyMember);
            hobby.updateCnt();
            return;
        }

        Pending pending = request.toEntity(member, hobby);

        pendingRepository.save(pending);
    }

    @Override
    public List<PendingResponse> findPendingList(String memberId, Long hobbyId) {
        Hobby hobby = checkPrivilege(hobbyId, memberId);

        List<Pending> pendings = pendingRepository
                .getAllByHobbyAndPendingAllow(hobby, PendingAllow.WAITING);

        log.info(pendings.size()+"");
        List<PendingResponse> responses = new ArrayList<>();
        for (Pending pending : pendings) {
            PendingResponse response = new PendingResponse().of(pending);
            responses.add(response);
        }

        return responses;
    }
    @Transactional
    @Override
    public void allowPending(String memberId, final Long hobbyId, PendingAllowRequest request) {
       checkPrivilege(hobbyId, memberId);
       Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);

       hobby.checkMemberCount();

        Pending pending = pendingRepository
                .findById(request.getWaitId())
                .orElseThrow(NoSuchElementException::new);

        pending.updatePendingAllow(request.getIsAllowed());
        if(request.getIsAllowed().equals(PendingAllow.REJECTED)) return;

        Member findMember = pending.getMember();

        HobbyMember hobbyMember = HobbyMember.builder()
                .member(findMember)
                .hobby(hobby)
                .state(HobbyMemberState.ACTIVE)
                .privilege(HobbyMemberPrivilege.GENERAL)
                .build();

        hobbyMemberRepository.save(hobbyMember);
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
}
