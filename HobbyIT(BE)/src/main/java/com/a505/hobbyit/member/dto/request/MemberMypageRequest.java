package com.a505.hobbyit.member.dto.request;

import com.a505.hobbyit.member.domain.Member;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberMypageRequest {
    @NotEmpty(message = "별명은 필수 입력 사항입니다.")
    private String nickname;

    private String password;

    private String imgUrl;

    private String intro;

    public Member toEntity() {
        return Member.builder()
                .nickname(nickname)
                .password(password)
                .imgUrl(imgUrl)
                .intro(intro)
                .build();
    }
}
