package com.a505.hobbyit.hobby.service;

import com.a505.hobbyit.common.file.FileUploader;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.dto.*;
import com.a505.hobbyit.hobby.exception.DuplicatedHobbyException;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberState;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.member.exception.InvalidedRefreshTokenException;
import com.a505.hobbyit.member.exception.NoSuchMemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HobbyServiceImpl implements HobbyService{

    private final MemberRepository memberRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final HobbyRepository hobbyRepository;
    private final FileUploader fileUploader;

    @Override
    @Transactional
    public void save(String memberId, MultipartFile multipartFile, HobbyRequest requestDto) {
        checkDuplicatedHobby(requestDto.getName());

        final String domain = requestDto.getName();

        String fileUrl = fileUploader.upload(multipartFile, domain);

        Hobby hobby = requestDto.toEntity(fileUrl);
        hobbyRepository.save(hobby);

        Member member = readMember(memberId);

        HobbyMember hobbyMember = HobbyMember.builder()
                .member(member)
                .hobby(hobby)
                .state(HobbyMemberState.ACTIVE)
                .privilege(HobbyMemberPrivilege.OWNER)
                .build();

        hobbyMemberRepository.save(hobbyMember);
    }

    @Override
    public HobbyAndMemberResponse findById(String memberId, Long hobbyId) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);

        HobbyMember hobbyMember = hobbyMemberRepository
                .findByMemberAndHobby(member,hobby)
                .orElseGet(HobbyMember::new);

        log.info("========== 결과 DTO 반환==========");
        return new HobbyAndMemberResponse().of(hobby, hobbyMember);
    }

    @Override
    public List<HobbyResponse> findAll() {
        List<Hobby> hobbies = hobbyRepository.findAll();
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyResponse> searchByName(String keyword, Pageable pageale) {
        List<Hobby> hobbies = hobbyRepository.findHobbiesByNameContainingOrderByCurrentMemberCountDesc(keyword, pageale);
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyResponse> searchByCategory(String keyword, Pageable pageable) {
        List<Hobby> hobbies = hobbyRepository.findHobbiesByCategoryContainingOrderByCurrentMemberCountDesc(keyword, pageable);
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyResponse> findPopularHobby() {
        List<Hobby> hobbies = hobbyRepository.findPopularHobby();
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyResponse> findFreshHobby() {
        List<Hobby> hobbies = hobbyRepository.findFreshHobby();
        List<HobbyResponse> responses = new ArrayList<>();
        for (Hobby hobby : hobbies) {
            responses.add(new HobbyResponse().of(hobby));
        }
        return responses;
    }

    @Override
    public List<HobbyMemberResponse> findHobbyMembers(Long hobbyId) {
        Hobby hobby = readHobby(hobbyId);
        List<HobbyMemberResponse> responses = new ArrayList<>();
        List<HobbyMember> members = hobbyMemberRepository.findByHobbyId(hobby);

        for (HobbyMember member : members) {
            responses.add(new HobbyMemberResponse().toEntity(member));
        }

        return responses;
    }

    @Transactional
    @Override
    public void updateHobby(String memberId, Long hobbyId, MultipartFile multipartFile, HobbyUpdateRequest request){
        Hobby hobby = checkPrivilege(hobbyId, memberId);
        String fileUrl = hobby.getImgUrl();
        log.info(hobby.getImgUrl());
        log.info(multipartFile.getName());
        if(!hobby.getImgUrl().equals(multipartFile.getName())){
            final String domain = request.getName();
            log.info("==========파일 저장==========");
            fileUrl = fileUploader.upload(multipartFile, domain);
        }
        log.info(request.getIntro() + " & "+ request.getName() + " & " + request.getMax_participants_num());
        hobby.updateHobby(request, fileUrl);
    }
    @Transactional
    @Override
    public void deleteHobby(Long hobbyId, String memberId) {
        Hobby hobby = checkPrivilege(hobbyId, memberId);
        hobbyRepository.delete(hobby);
    }

    @Override
    public Hobby checkPrivilege(Long hobbyId, String memberId){
        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(NoSuchElementException::new);
        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(NoSuchHobbyException::new);
        hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new)
                .checkPrivilege();
        return hobby;
    }

    void checkDuplicatedHobby(String name){
        if(hobbyRepository.existsByName(name)) throw new DuplicatedHobbyException("중복된 Hobby 이름입니다.");
    }

    Member readMember(String memberId){
        return memberRepository.findById(Long.parseLong(memberId)).orElseThrow(()->new NoSuchMemberException("요청하신 회원을 찾을 수 없습니다."));
    }
    Hobby readHobby(Long hobbyId){
        return hobbyRepository.findById(hobbyId).orElseThrow(()-> new NoSuchHobbyException("요청하신 소모임을 찾을 수 없습니다."));
    }
}
