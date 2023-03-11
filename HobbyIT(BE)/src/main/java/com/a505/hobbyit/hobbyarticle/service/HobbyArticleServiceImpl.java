package com.a505.hobbyit.hobbyarticle.service;

import com.a505.hobbyit.common.file.FileUploader;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.domain.HobbyRepository;
import com.a505.hobbyit.hobby.exception.NoSuchHobbyException;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticleRepository;
import com.a505.hobbyit.hobbyarticle.dto.*;
import com.a505.hobbyit.hobbyarticle.exception.NoSuchHobbyArticleException;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImgRepository;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.domain.HobbyMemberRepository;
import com.a505.hobbyit.hobbymember.exception.NoSuchHobbyMemberException;
import com.a505.hobbyit.hobbymember.exception.UnAuthorizedHobbyMemberException;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.member.domain.MemberRepository;
import com.a505.hobbyit.member.exception.NoSuchMemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Transactional(readOnly = true)
@Service
@Slf4j
@RequiredArgsConstructor
public class HobbyArticleServiceImpl implements HobbyArticleService{
    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final HobbyArticleRepository hobbyArticleRepository;
    private final HobbyArticleImgRepository hobbyArticleImgRepository;
    private final HobbyMemberRepository hobbyMemberRepository;
    private final FileUploader fileUploader;

    @Override
    public Slice<HobbyArticleResponse> findAll(String memberId, Long storedId, Long hobbyId, Pageable pageable) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);
        checkMember(member, hobby);
        return hobbyArticleRepository.findHobbyArticle(storedId, hobby, pageable);
    }

    @Transactional
    @Override
    public void saveArticle(String memberId, Long hobbyId, HobbyArticleRequest hobbyArticleRequest, List<MultipartFile> files) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);
        checkMember(member, hobby);

        HobbyArticle hobbyArticle = hobbyArticleRequest.toEntity(member, hobby);

        hobbyArticleRepository.save(hobbyArticle);

        log.info(files.size()==0 ? "isEmpty" : "isNotEmpty");

        for (MultipartFile file : files) {
            String fileUrl = fileUploader.upload(file, hobbyArticle.getTitle());
            log.info(fileUrl);
            HobbyArticleImg hobbyArticleImg = new HobbyArticleImg().toEntity(fileUrl, hobbyArticle);
            hobbyArticleImgRepository.save(hobbyArticleImg);
            log.info(hobbyArticleImg.getId()+"");
        }
    }

    @Transactional
    @Override
    public void saveNotice(String memberId, Long hobbyId, HobbyNoticeRequest hobbyNoticeRequest) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);
        checkMember(member, hobby);
        HobbyArticle hobbyArticle = hobbyNoticeRequest.toEntity(member, hobby);
        hobbyArticleRepository.save(hobbyArticle);
    }

    @Override
    public HobbyArticleDetailResponse findById(String memberId, final Long hobbyId, final Long articleId) {
        Member member = memberRepository.findById(Long.parseLong(memberId)).orElseThrow(NoSuchHobbyMemberException::new);
        Hobby hobby = hobbyRepository.getReferenceById(hobbyId);
        checkMember(member, hobby);
        HobbyArticle hobbyArticle = readHobbyArticle(articleId);
        hobbyArticle.updateHit();

        return new HobbyArticleDetailResponse().of(hobbyArticle);
    }

    @Override
    public Slice<HobbyArticleResponse> findByKeyword(String memberId, Long storedId, String keyword, final Long hobbyId, Pageable pageable) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);
        checkMember(member, hobby);
        return hobbyArticleRepository.searchHobbyArticle(storedId,  keyword, hobby, pageable);
    }

    @Override
    public Page<HobbyNoticeResponse> findAllNotice(String memberId, final Long hobbyId, Pageable pageable) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);
        checkMember(member, hobby);
        return hobbyArticleRepository.findHobbyNotice(hobby, pageable);
    }

    @Override
    public Page<HobbyNoticeResponse> findNoticeByKeyWord(String memberId, final Long hobbyId, String keyword, Pageable pageable) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);
        checkMember(member, hobby);
        return hobbyArticleRepository.searchHobbyNotice(hobby, keyword, pageable);
    }

    @Override
    public HobbyNoticeResponse getNotice(String memberId, Long hobbyId, Long noticeId) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);
        checkMember(member, hobby);
        HobbyArticle hobbyArticle = readHobbyArticle(noticeId);
        return new HobbyNoticeResponse().of(hobbyArticle);
    }

    @Transactional
    @Override
    public void update(String memberId, final Long articleId, HobbyArticleUpdateRequest request) {
        HobbyArticle hobbyArticle = readHobbyArticle(articleId);
        if(hobbyArticle.getMember().getId()!= Long.parseLong(memberId))
            throw new UnAuthorizedHobbyMemberException();
        hobbyArticle.updateTitle(request.getTitle());
        hobbyArticle.updateContent(request.getContent());
    }

    @Transactional
    @Override
    public void delete(String memberId,Long hobbyId, Long articleId) {
        Member member = readMember(memberId);
        Hobby hobby = readHobby(hobbyId);
        checkMember(member, hobby);
        HobbyArticle hobbyArticle = readHobbyArticle(articleId);
        hobbyArticleRepository.delete(hobbyArticle);
    }

    public void checkMember(Member member, Hobby hobby){ // 가입된 회원인지 혹은 탈퇴된회원인지 확인을 위한 method
        HobbyMember hobbyMember = hobbyMemberRepository
                .findByMemberAndHobby(member, hobby)
                .orElseThrow(NoSuchHobbyMemberException::new); // 없는 경우 hobby member를 찾을 수 없다고 반환
        hobbyMember.checkMember(); // hobbymember의 현재 상태가 ACTIVE인지 확인
    }

    public Member readMember(String memberId){
        return memberRepository
                .findById(Long.parseLong(memberId))
                .orElseThrow(NoSuchMemberException::new);
    }

    public Hobby readHobby(Long hobbyId){
        return hobbyRepository
                .findById(hobbyId)
                    .orElseThrow(NoSuchHobbyException::new);
    }

    public HobbyArticle readHobbyArticle(Long hobbyArticleId){
        return hobbyArticleRepository
                .findById(hobbyArticleId)
                .orElseThrow(NoSuchHobbyArticleException::new);
    }
}
