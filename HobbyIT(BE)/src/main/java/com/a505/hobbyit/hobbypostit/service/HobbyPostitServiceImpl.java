package com.a505.hobbyit.hobbypostit.service;

import com.a505.hobbyit.article.exception.UnAuthorizedArticleException;
import com.a505.hobbyit.common.file.FileUploader;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.hobbypostit.domain.HobbyPostit;
import com.a505.hobbyit.hobbypostit.domain.HobbyPostitRepository;
import com.a505.hobbyit.hobbypostit.dto.HobbyPostitResponse;
import com.a505.hobbyit.hobbypostit.exception.UnAuthorizedHobbyPostitException;
import com.a505.hobbyit.hobbypostitrecord.domain.HobbyPostitRecord;
import com.a505.hobbyit.hobbypostitrecord.domain.HobbyPostitRecordRepository;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.member.exception.NoSuchMemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HobbyPostitServiceImpl implements HobbyPostitService {

    private final HobbyPostitRepository hobbyPostitRepository;
    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final HobbyPostitRecordRepository hobbyPostitRecordRepository;
    private final FileUploader fileUploader;

    @Transactional
    @Override
    public void save(Long memberId, Long hobbyId, LocalDate date, MultipartFile multipartFile) {
        LocalDateTime curDateTime = LocalDateTime.now();      // for real service
//        LocalDateTime curDateTime = LocalDateTime.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), 0, 0, 0);  // for demonstrate

        if (!date.isEqual(curDateTime.toLocalDate())
                || (curDateTime.getHour() == 23 && 55 < curDateTime.getMinute())) {
            throw new UnAuthorizedHobbyPostitException("방명록 작성 가능 시간은 당일 00시 00분 ~ 23시 55분입니다.");
        }

        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(NoSuchMemberException::new);
        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);
        HobbyMember hobbyMember = hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new);

        if (hobbyMember.getPostitRegDt() != null
                && Objects.equals(hobbyMember.getPostitRegDt().toLocalDate(), curDateTime.toLocalDate())) {
            throw new UnAuthorizedArticleException("오늘은 이미 방명록을 작성하였습니다.");
        }

        String imgUrl = fileUploader.upload(multipartFile, hobbyId, date);
        HobbyPostit hobbyPostit =
                HobbyPostit.builder()
                        .member(member)
                        .hobby(hobby)
                        .imgUrl(imgUrl)
                        .regDt(curDateTime)
                        .build();

        hobbyPostitRepository.save(hobbyPostit);
        hobbyMember.updatePostitRegDt(curDateTime);

        if (hobbyPostitRecordRepository
                .findByHobbyAndRegDt(hobby, date)
                .isEmpty()
        ) {
            hobbyPostitRecordRepository.save(
                    HobbyPostitRecord.builder()
                            .hobby(hobby)
                            .regDt(curDateTime.toLocalDate())
                            .build()
            );
        }
    }

    @Override
    public List<HobbyPostitResponse> findHobbyPostits(Long memberId, Long hobbyId, LocalDate date) {
        if (!LocalDate.now().isAfter(date))
            throw new UnAuthorizedHobbyPostitException("방명록을 조회할 수 있는 날짜가 아닙니다.");
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(NoSuchMemberException::new);
        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new);

        return hobbyPostitRepository.findByHobbyAndRegDtBetween(
                hobby,
                LocalDateTime.of(date, LocalTime.of(0, 0, 0)),
                LocalDateTime.of(date, LocalTime.of(23, 59, 59))
        ).stream().map((hobbyPostit -> new HobbyPostitResponse().of(hobbyPostit))).toList();
    }

    @Override
    public void isPossibleToWritePostit(Long memberId, Long hobbyId) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(NoSuchMemberException::new);
        Hobby hobby = hobbyRepository
                .findById(hobbyId)
                .orElseThrow(NoSuchHobbyException::new);
        HobbyMember hobbyMember = hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new);

        LocalDateTime now = LocalDateTime.now();

        if (now.getHour() == 23 && 55 < now.getMinute())
            throw new UnAuthorizedHobbyPostitException("방명록 작성 가능 시간은 당일 00시 00분 ~ 23시 55분입니다.");

        if (hobbyMember.getPostitRegDt() != null
                && Objects.equals(hobbyMember.getPostitRegDt().toLocalDate(), LocalDate.now())) {
            throw new UnAuthorizedArticleException("오늘은 이미 방명록을 작성하였습니다.");
        }
    }
}
