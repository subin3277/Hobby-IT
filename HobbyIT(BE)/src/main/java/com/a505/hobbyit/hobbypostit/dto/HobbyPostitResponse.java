package com.a505.hobbyit.hobbypostit.dto;

import com.a505.hobbyit.hobbypostit.domain.HobbyPostit;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "방명록 API Response DTO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class HobbyPostitResponse {

    @Schema(description = "방명록 사진 경로", example = "1754845397249002023-02-10Quokka.jpg")
    private String imgUrl;

    @Schema(description = "방명록 작성 일시", example = "2023-02-06T08:40:23.202Z")
    private LocalDateTime regDt;

    public HobbyPostitResponse of(HobbyPostit hobbyPostit) {
        return HobbyPostitResponse.builder()
                .imgUrl(hobbyPostit.getImgUrl())
                .regDt(hobbyPostit.getRegDt())
                .build();
    }
}
