package com.a505.hobbyit.hobbymember.dto;

import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HobbyMemberUpdateRequest {
    HobbyMemberPrivilege privilege;
}
