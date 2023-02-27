package com.a505.hobbyit.hobby.dto;

import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HobbyMemberResponse {
    private Long id;
    private Long member_id;
    private String nickName;
    private String reg_dt;
    private HobbyMemberPrivilege privilege;
    public HobbyMemberResponse toEntity(HobbyMember hobbyMember){
        HobbyMemberResponse build = HobbyMemberResponse
                .builder()
                .id(hobbyMember.getId())
                .member_id(hobbyMember.getMember().getId())
                .nickName(hobbyMember.getMember().getNickname())
                .reg_dt(hobbyMember.getWritedDate().format(DateTimeFormatter.ISO_DATE))
                .privilege(hobbyMember.getPrivilege())
                .build();
        return build;
    }
}
