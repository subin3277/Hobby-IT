package com.a505.hobbyit.member.dto.response;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobby.dto.HobbyResponse;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberHobbyResponse {
    Long id;
    String name;
    String imgUrl;
    HobbyMemberPrivilege privilege;
    LocalDateTime regDt;

    int participantsNum;
    int maxParticipantsNum;


    public MemberHobbyResponse of(Hobby hobby, HobbyMember hobbyMember){
        return MemberHobbyResponse.builder()
                .id(hobby.getId())
                .name(hobby.getName())
                .imgUrl(hobby.getImgUrl())
                .participantsNum(hobby.getCurrentMemberCount())
                .maxParticipantsNum(hobby.getMaxMemberCount())
                .privilege(hobbyMember.getPrivilege())
                .regDt(hobbyMember.getWritedDate()).build();
    }
}
