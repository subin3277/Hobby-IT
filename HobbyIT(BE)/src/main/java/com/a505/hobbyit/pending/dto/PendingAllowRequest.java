package com.a505.hobbyit.pending.dto;


import com.a505.hobbyit.pending.enums.PendingAllow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PendingAllowRequest {
    PendingAllow isAllowed;
    Long waitId;
}
