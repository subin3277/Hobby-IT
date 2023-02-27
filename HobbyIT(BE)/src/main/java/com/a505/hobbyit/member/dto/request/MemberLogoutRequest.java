package com.a505.hobbyit.member.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberLogoutRequest {
    @JsonProperty("accessToken")
    @NotEmpty(message = "잘못된 요청입니다.")
    private String accessToken;

}
