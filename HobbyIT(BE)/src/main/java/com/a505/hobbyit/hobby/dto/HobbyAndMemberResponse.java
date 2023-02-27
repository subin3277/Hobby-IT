package com.a505.hobbyit.hobby.dto;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.enums.HobbyFree;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HobbyAndMemberResponse {
    private String name;
    private String img;
    private int participantsNum;
    private int maxParticipantsNum;
    private String intro;
    private String category;
    private HobbyFree freeRegistration;
    private Long hobbyMemberId;
    private HobbyMemberPrivilege privilege;

    public HobbyAndMemberResponse of(Hobby hobby, HobbyMember hobbyMember){
        return HobbyAndMemberResponse.builder()
                .name(hobby.getName())
                .intro(hobby.getIntro())
                .participantsNum(hobby.getCurrentMemberCount())
                .maxParticipantsNum(hobby.getMaxMemberCount())
                .freeRegistration(hobby.getFree())
                .category(hobby.getCategory())
                .img(hobby.getImgUrl())
                .hobbyMemberId(hobbyMember.getId())
                .privilege(hobbyMember.getPrivilege())
                .build();
    }
}
