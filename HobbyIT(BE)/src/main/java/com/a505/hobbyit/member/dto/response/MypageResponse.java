package com.a505.hobbyit.member.dto.response;

import com.a505.hobbyit.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MypageResponse {
    private String email;
    private String name;
    private String nickname;
    private String intro;
    private int point;
    private int pointLevel;
    private int pointExp;
    private String imgUrl;
    public MypageResponse of(Member member){
        return MypageResponse.builder()
                .email(member.getEmail())
                .name(member.getName())
                .nickname(member.getNickname())
                .intro(member.getIntro())
                .point(member.getPoint())
                .pointLevel(member.getPoint()/100)
                .pointExp(member.getPoint()%100)
                .imgUrl(member.getImgUrl())
                .build();
    }
}
