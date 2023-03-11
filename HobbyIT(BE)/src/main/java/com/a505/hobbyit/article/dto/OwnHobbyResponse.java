package com.a505.hobbyit.article.dto;

import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class OwnHobbyResponse {

    @Schema(description = "소모임 ID", example = "1")
    private Long id;

    @Schema(description = "소모임 이름", example = "john, 나 여행가고싶어")
    private String name;

    public OwnHobbyResponse of(HobbyMember hobbyMember) {
        return OwnHobbyResponse.builder()
                .id(hobbyMember.getHobby().getId())
                .name(hobbyMember.getHobby().getName())
                .build();
    }
}
