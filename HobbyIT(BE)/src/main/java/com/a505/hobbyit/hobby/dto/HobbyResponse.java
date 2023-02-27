package com.a505.hobbyit.hobby.dto;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HobbyResponse {
    private Long id;
    private String name;
    private String img;
    private int participantsNum;
    private int maxParticipantsNum;
    private String intro;
    private String category;
    private int freeRegistration;
    private LocalDateTime createdDate;
    public HobbyResponse of(Hobby hobby){
        return HobbyResponse.builder()
                .id(hobby.getId())
                .name(hobby.getName())
                .intro(hobby.getIntro())
                .participantsNum(hobby.getCurrentMemberCount())
                .maxParticipantsNum(hobby.getMaxMemberCount())
                .category(hobby.getCategory())
                .createdDate(hobby.getCreatedDateTime())
                .img(hobby.getImgUrl())
                .build();
    }
}
