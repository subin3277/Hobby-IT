package com.a505.hobbyit.hobbypostit.service;

import com.a505.hobbyit.hobbypostit.dto.HobbyPostitResponse;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface HobbyPostitService {

    void save(Long memberId, Long hobbyId, LocalDate date, MultipartFile multipartFile);

    List<HobbyPostitResponse> findHobbyPostits(Long memberId, Long hobbyId, LocalDate date);

    void isPossibleToWritePostit(Long memberId, Long hobbyId);
}
