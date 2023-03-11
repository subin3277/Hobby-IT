package com.a505.hobbyit.hobbymember.controller;

import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;
import com.a505.hobbyit.hobbymember.service.HobbyMemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/hobby")
@RequiredArgsConstructor
public class HobbyMemberController {
    private final HobbyMemberService hobbyMemberService;
    @PutMapping("/{hobby-id}/member/{member-id}")
    public ResponseEntity<Void> updateHobbyMember(
            @Parameter(description = "사용자 정보 갱신 API")
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("member-id") final Long targetId,
            @RequestBody HobbyMemberUpdateRequest request){

        hobbyMemberService.updatePrivilege(userDetails.getUsername(), hobbyId, targetId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{hobby-id}/member/{member-id}")
    public ResponseEntity<Void> kickHobbyMember(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @PathVariable("member-id") final Long targetId ){

        hobbyMemberService.kickHobbyMember(userDetails.getUsername(), hobbyId, targetId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{hobby-id}/member")
    public ResponseEntity<Void> resignHobbyMember(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId){

        hobbyMemberService.resignHobbyMember(userDetails.getUsername(), hobbyId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @Operation(
            summary = "소모임 가입 여부 확인",
            description = "로그인 사용자 정보, 소모임 ID를 이용하여 소모임 가입 여부를 확인합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "소모임 회원이 맞음", content = @Content),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스(소모임 회원이 아님)", content = @Content)
    })
    @GetMapping("/{hobby-id}/check")
    public ResponseEntity<Void> checkHobbyMember(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") @Parameter(description = "소모임 ID", example = "1") Long hobbyId)
    {
        hobbyMemberService.checkHobbyMember(Long.parseLong(userDetails.getUsername()), hobbyId);
        return ResponseEntity.ok().build();
    }
}
