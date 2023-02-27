package com.a505.hobbyit.hobbypostit.controller;

import com.a505.hobbyit.hobbypostit.dto.HobbyPostitResponse;
import com.a505.hobbyit.hobbypostit.service.HobbyPostitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "HobbyPostit API", description = "방명록 API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class HobbyPostitController {

    private final HobbyPostitService hobbyPostitService;


    @PostMapping("/api/hobby/{hobby-id}/postit/{date}")
    @Operation(
            summary = "방명록 등록",
            description = "로그인 사용자 정보, 방명록을 작성할 소모임 ID, 방명록 사진 경로를 이용하여 방명록을 등록합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "방명록 등록 성공"),
            @ApiResponse(responseCode = "401", description = "방명록 작성 권한이 없음", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    public ResponseEntity<Void> createHobbyPostit(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") @Parameter(description = "소속 소모임 ID", example = "1") Long hobbyId,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd")
                @Parameter(description = "날짜", example = "2023-01-01") LocalDate date,
            @RequestPart("file") final MultipartFile multipartFile
    ) {
        hobbyPostitService.save(Long.parseLong(userDetails.getUsername()), hobbyId, date, multipartFile);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/api/hobby/{hobby-id}/postit/{date}")
    @Operation(
            summary = "방명록 리스트 가져오기",
            description = "로그인 사용자 정보, 방명록을 조회할 소모임 ID, 방명록 등록 날짜를 이용하여 방명록 리스트를 불러옵니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "방명록 리스트 반환 성공"),
            @ApiResponse(responseCode = "401", description = "방명록 조회 권한이 없음", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    public ResponseEntity<List<HobbyPostitResponse>> findHobbyPostits(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") @Parameter(description = "소속 소모임 ID", example = "1") Long hobbyId,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd")
                @Parameter(description = "날짜", example = "2023-01-01") LocalDate date
    ) {
        List<HobbyPostitResponse> hobbyPostitResponseList
                = hobbyPostitService.findHobbyPostits(Long.parseLong(userDetails.getUsername()), hobbyId, date);
        return ResponseEntity.ok(hobbyPostitResponseList);
    }


    @Operation(
            summary = "방명록 작성 가능 여부 확인",
            description = "방명록 작성 가능 여부를 확인합니다. (소모임 당 1일 1회 제한)"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "방명록 작성 가능"),
            @ApiResponse(responseCode = "401", description = "방명록 작성 불가", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content)
    })
    @GetMapping("/api/hobby/{hobby-id}/postit/writable")
    public ResponseEntity<Void> isPossibleToWritePostit(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") @Parameter(description = "소속 소모임 ID") final Long hobbyId
    ) {
        hobbyPostitService.isPossibleToWritePostit(Long.parseLong(userDetails.getUsername()), hobbyId);
        return ResponseEntity.ok().build();
    }
}
