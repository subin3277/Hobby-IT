package com.a505.hobbyit.hobbypostitrecord.service;

import java.time.LocalDate;
import java.util.List;

public interface HobbyPostitRecordService {
    List<LocalDate> findHobbyPostitRecordRegDtList(Long memberId, Long hobbyId);
}
