package com.a505.hobbyit.member.service;

import com.a505.hobbyit.member.dto.request.MemberLoginRequest;
import com.a505.hobbyit.member.dto.request.MemberLogoutRequest;
import com.a505.hobbyit.member.dto.request.MemberReissueRequest;
import com.a505.hobbyit.member.dto.request.MemberSignupRequest;
import com.a505.hobbyit.member.dto.response.MemberTokenResponse;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    public void signUp(MemberSignupRequest request);
    public MemberTokenResponse login(MemberLoginRequest request);
    public ResponseEntity<?> reissue(MemberReissueRequest reissue);
    public ResponseEntity<?> logout(MemberLogoutRequest logout);
    public ResponseEntity<?> authority();
}