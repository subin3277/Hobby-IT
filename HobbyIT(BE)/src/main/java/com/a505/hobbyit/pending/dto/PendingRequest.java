package com.a505.hobbyit.pending.dto;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.pending.domain.Pending;
import com.a505.hobbyit.pending.enums.PendingAllow;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PendingRequest {

    @NotNull()
    String message;

    public Pending toEntity(Member member, Hobby hobby){
        return Pending.builder()
                .member(member)
                .hobby(hobby)
                .msg(message)
                .pendingAllow(PendingAllow.WAITING)
                .build();
    }
}
