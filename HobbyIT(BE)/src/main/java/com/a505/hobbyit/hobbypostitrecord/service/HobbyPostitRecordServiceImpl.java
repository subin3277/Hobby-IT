package com.a505.hobbyit.hobbypostitrecord.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.hobbypostitrecord.domain.HobbyPostitRecord;
import com.a505.hobbyit.hobbypostitrecord.domain.HobbyPostitRecordRepository;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.member.exception.NoSuchMemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@Service
@Slf4j
@RequiredArgsConstructor
public class HobbyPostitRecordServiceImpl implements HobbyPostitRecordService {

    private final HobbyPostitRecordRepository hobbyPostitRecordRepository;
    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final HobbyMemberRepository hobbyMemberRepository;


    @Override
    public List<LocalDate> findHobbyPostitRecordRegDtList(Long memberId, Long hobbyId) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(NoSuchMemberException::new);
        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new);

        return hobbyPostitRecordRepository
                .findByHobby(hobby)
                .stream()
                .map(HobbyPostitRecord::getRegDt)
                .toList();
    }
}
