package com.a505.hobbyit.hobby.dto;


import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.enums.HobbyFree;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HobbyRequest {

    @NotNull(message = "이름이 Null일 수 없습니다.")
    private String name;

    @NotNull(message = "설명이 Null일 수 없습니다.")
    private String intro;

    @NotNull
    private int maxMemberCnt;

    @NotNull
    private String category;

    @NotNull
    private String imgUrl;

    @NotNull
    private HobbyFree free;

    public Hobby toEntity(String imgUrl){
        return Hobby.builder().name(name)
                .intro(intro)
                .currentMemberCount(1)
                .maxMemberCount(maxMemberCnt)
                .category(category)
                .imgUrl(imgUrl)
                .free(free)
                .build();
    }
}
