package com.a505.hobbyit.pending.dto;


import com.a505.hobbyit.pending.domain.Pending;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PendingResponse {
    String nickname;
    LocalDateTime applyDate;

    String message;

    Long waitId;

    public PendingResponse of(Pending pending){
        return PendingResponse.builder()
                .nickname(pending.getMember().getNickname())
                .applyDate(pending.getWritedDate())
                .message(pending.getMsg())
                .waitId(pending.getId())
                .build();
    }
}
