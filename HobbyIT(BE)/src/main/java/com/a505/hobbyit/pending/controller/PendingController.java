package com.a505.hobbyit.pending.controller;


import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;
import com.a505.hobbyit.pending.service.PendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/hobby")
@RequiredArgsConstructor
public class PendingController {
    private final PendingService pendingService;
    // 가입 신청
    @PostMapping(value = "/{hobby-id}/join")
    public ResponseEntity<String> savePendingMember(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final long hobbyId,
            @RequestBody PendingRequest request){
        pendingService.join(userDetails.getUsername(), hobbyId, request);
        String message = "신청되었습니다.";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping(value = "/{hobby-id}/join")
    public ResponseEntity<List<PendingResponse>> findHobbyMemberList(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable(value = "hobby-id") final Long hobbyId){

        List<PendingResponse> pendingList = pendingService.findPendingList(userDetails.getUsername(), hobbyId);
        return ResponseEntity.status(HttpStatus.OK).body(pendingList);
    }

    @PostMapping(value = "/{hobby-id}/allow")
    public ResponseEntity<Void> allowHobbyMember(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("hobby-id") final Long hobbyId,
            @RequestBody PendingAllowRequest request){
        pendingService.allowPending(userDetails.getUsername(), hobbyId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
