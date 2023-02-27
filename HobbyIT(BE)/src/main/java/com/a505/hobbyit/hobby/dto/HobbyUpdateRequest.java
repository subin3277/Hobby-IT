package com.a505.hobbyit.hobby.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HobbyUpdateRequest {
    @NotNull
    private String name;
    @NotNull
    private String intro;
    @NotNull
    private int max_participants_num;
}
