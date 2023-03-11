package com.a505.hobbyit.member.service;

import com.a505.hobbyit.member.dto.request.*;
import com.a505.hobbyit.member.dto.response.MemberHobbyResponse;
import com.a505.hobbyit.member.dto.response.MemberPendingResponse;
import com.a505.hobbyit.member.dto.response.MemberResponse;
import com.a505.hobbyit.member.dto.response.MypageResponse;
import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MemberService {
    void signUp(MemberSignupRequest request);

    boolean isSns(String email);

    void updateSnsMember(String email, String imgUrl);

    MemberResponse login(MemberLoginRequest request);

    MemberResponse reissue(MemberReissueRequest request);

    void logout(final String token);

    void resetPassword(MemberMailRequest request, String from) throws MessagingException;

    MypageResponse findMypage(final String token, final String nickname);

    void update(final String token, MemberMypageRequest request, MultipartFile multipartFile);

    void delete(final String token);

    List<MemberHobbyResponse> getHobbyList(final String token, String nickname);

    List<MemberPendingResponse> getPendingList(final String token);

    String redirectKakao();

    String getKakaoToken(String code);

    List<String> getKakaoMember(String token);
}
