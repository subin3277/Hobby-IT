package com.a505.hobbyit.member.dto.response;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.pending.domain.Pending;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberPendingResponse {
    Long id;
    String name;
    String imgUrl;
    LocalDateTime regDt;
    public MemberPendingResponse of(Hobby hobby, Pending pending){
        return MemberPendingResponse.builder()
                .id(hobby.getId())
                .name(hobby.getName())
                .imgUrl(hobby.getImgUrl())
                .regDt(pending.getWritedDate())
                .build();
    }
}
