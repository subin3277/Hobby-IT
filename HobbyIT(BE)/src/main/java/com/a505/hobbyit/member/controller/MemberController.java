package com.a505.hobbyit.member.controller;

import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.response.MemberHobbyResponse;
import com.a505.hobbyit.member.dto.response.MemberPendingResponse;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.dto.response.MypageResponse;
import com.a505.hobbyit.member.service.MemberService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/member")
public class MemberController {
    private final MemberService memberService;

    @Value("${spring.mail.username}")
    private String from;

    @PostMapping(value = "/signup")
    public ResponseEntity<Void> signUp(@Validated MemberSignupRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        memberService.signUp(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<MemberResponse> login(@Validated MemberLoginRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        MemberResponse response = memberService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/reissue")
    public ResponseEntity<MemberResponse> reissue(@RequestBody MemberReissueRequest request) {
        MemberResponse memberResponse = memberService.reissue(request);
        return ResponseEntity.ok(memberResponse);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") final String token) {
        memberService.logout(token);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/password/reset")
    public ResponseEntity<Void> resetPassword(@Validated MemberMailRequest request, Errors errors) throws MessagingException {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        memberService.resetPassword(request, from);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{member-nickname}")
    public ResponseEntity<MypageResponse> findMypage(
            @RequestHeader("Authorization") final String token,
            @PathVariable(value = "member-nickname") final String nickname) {
        MypageResponse response = memberService.findMypage(token, nickname);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Void> updateMember(
            @RequestHeader("Authorization") final String token,
            @RequestPart("request") MemberMypageRequest request,
            @RequestPart("multipartFile") MultipartFile multipartFile) {
        memberService.update(token, request, multipartFile);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/delete")
    public ResponseEntity<Void> deleteMember(@RequestHeader("Authorization") final String token) {
        memberService.delete(token);
        memberService.logout(token);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/hobby/{member-nickname}")
    public ResponseEntity<List<MemberHobbyResponse>> findMemberHobbies(
            @RequestHeader("Authorization") final String token,
            @PathVariable(value = "member-nickname") final String nickname) {
        List<MemberHobbyResponse> hobbyList = memberService.getHobbyList(token, nickname);
        return ResponseEntity.status(HttpStatus.OK).body(hobbyList);
    }

    @GetMapping(value = "/hobby/pending")
    public ResponseEntity<List<MemberPendingResponse>> findMemberPendings(
            @RequestHeader("Authorization") final String token) {
        List<MemberPendingResponse> pendingList = memberService.getPendingList(token);
        return ResponseEntity.status(HttpStatus.OK).body(pendingList);
    }

    @GetMapping("/oauth/kakao/login")
    public void redirectKakao(HttpServletResponse response) throws IOException {
        response.sendRedirect(memberService.redirectKakao());
    }

    @Hidden
    @ResponseBody
    @GetMapping(value = "/oauth/kakao")
    public ResponseEntity<MemberResponse> kakaoCallback(@RequestParam String code) {
        // 1. kakao 에서 받은 access_token을 다시 카카오만의 REDIRECT_URI 로 보내서 사용자 정보를 받음
        String token = memberService.getKakaoToken(code);
        List<String> account = memberService.getKakaoMember(token);

        // 2. kakao 간편 회원가입을 한 사용자인지 확인
        if (!memberService.isSns(account.get(0))) {
            // 3. 가입하지 않은 사용자인 경우, 사용자 정보를 통해 회원가입을 진행
            MemberSignupRequest signupRequest =
                    new MemberSignupRequest(account.get(0), account.get(1), account.get(1), account.get(0));
            memberService.signUp(signupRequest);
            memberService.updateSnsMember(account.get(0), account.get(2));
        }

        // 4. 회원가입된 정보로 로그인을 진행
        MemberLoginRequest loginRequest = new MemberLoginRequest(account.get(0), account.get(0));
        MemberResponse response = memberService.login(loginRequest);

        return ResponseEntity.ok(response);
    }

}
