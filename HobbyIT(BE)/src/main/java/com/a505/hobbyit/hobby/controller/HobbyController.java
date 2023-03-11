package com.a505.hobbyit.hobby.controller;

import com.a505.hobbyit.hobby.dto.*;
import com.a505.hobbyit.hobby.service.HobbyService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/hobby")
public class HobbyController {

    private final HobbyService hobbyService;

    @PostMapping
    public ResponseEntity<Void> createHobby(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestPart("multipartFile") MultipartFile multipartFile,
            @RequestPart("request") HobbyRequest requestDto) {
        hobbyService.save(userDetails.getUsername(), multipartFile, requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/{hobby-id}")
    public ResponseEntity<HobbyAndMemberResponse> findHobby(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "hobby-id") final Long hobbyId) {

        log.info("===============" + userDetails.getUsername() + userDetails.getAuthorities() + "===========================");
        HobbyAndMemberResponse response = hobbyService.findById(userDetails.getUsername(), hobbyId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<HobbyResponse>> findHobbies() {
        List<HobbyResponse> responses = hobbyService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/search/category")
    public ResponseEntity<List<HobbyResponse>> searchHobbiesByCategory(@RequestParam(value = "keyword") String keyWord, Pageable pageable) {
        List<HobbyResponse> responses = hobbyService.searchByCategory(keyWord, pageable);
        return ResponseEntity.ok(responses);
    }
    @GetMapping(value = "/search/name")
    public ResponseEntity<List<HobbyResponse>> searchHobbiesByName(@RequestParam(value = "keyword") String keyWord, Pageable pageable) {
        List<HobbyResponse> responses = hobbyService.searchByName(keyWord, pageable);
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/popular")
    public ResponseEntity<List<HobbyResponse>> findPopularHobbies() {
        List<HobbyResponse> responses = hobbyService.findPopularHobby();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/fresh")
    public ResponseEntity<List<HobbyResponse>> findFreshHobbies() {
        List<HobbyResponse> responses = hobbyService.findFreshHobby();
        return ResponseEntity.ok(responses);
    }

    /*
    #18. 모임 회원 명단 확인 API
    */
    @GetMapping(value = "/{hobby-id}/member")
    public ResponseEntity<List<HobbyMemberResponse>> findHobbyMembers(@PathVariable(value = "hobby-id") Long hobbyId) {
        List<HobbyMemberResponse> responses = hobbyService.findHobbyMembers(hobbyId);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @PutMapping(value = "/{hobby-id}")
    public ResponseEntity<Void> updateHobby(@Parameter(description = "게시할 글의 정보")
                                                @AuthenticationPrincipal UserDetails userDetails,
                                            @PathVariable("hobby-id") Long hobbyId,
                                            @RequestPart("multipartFile") MultipartFile multipartFile,
                                            @RequestPart("request") HobbyUpdateRequest request) {
        hobbyService.updateHobby(userDetails.getUsername(), hobbyId, multipartFile, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/{hobby-id}")
    public ResponseEntity<Void> deleteHobby(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "hobby-id") final Long hobbyId) {

        hobbyService.deleteHobby(hobbyId, userDetails.getUsername());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
