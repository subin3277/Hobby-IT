package com.a505.hobbyit.hobby.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HobbyService {
    public void save(String memberId, final MultipartFile file, final HobbyRequest requestDto);
    public HobbyAndMemberResponse findById(String memberId, Long hobbyId);
    public List<HobbyResponse> findAll();
    public List<HobbyResponse> searchByName(String keyword, Pageable pageale);
    public List<HobbyResponse> searchByCategory(String keyword, Pageable pageable);
    public List<HobbyResponse> findPopularHobby();
    public List<HobbyResponse> findFreshHobby();
    public List<HobbyMemberResponse> findHobbyMembers(Long hobbyId);
    public void updateHobby(String memberId, Long hobbyId, MultipartFile file, HobbyUpdateRequest request);
    public void deleteHobby(Long hobbyId, String token);
    public Hobby checkPrivilege(Long hobbyId, String token);
}

/*
모임 생성
모임 정보 확인
모임 리스트 확인
모임 검색 -> 키워드에 따라서 분리
인기있는 모임 리스트
새로 생긴 모임 리스트
모임 회원 명단 확인
모임 삭제
 */
