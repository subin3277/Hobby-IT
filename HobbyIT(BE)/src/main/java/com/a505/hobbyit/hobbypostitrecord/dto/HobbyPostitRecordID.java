package com.a505.hobbyit.hobbypostitrecord.dto;

import com.a505.hobbyit.hobby.domain.Hobby;

import java.io.Serializable;
import java.time.LocalDate;

public class HobbyPostitRecordID implements Serializable {
    private Hobby hobby;
    private LocalDate regDt;
}
