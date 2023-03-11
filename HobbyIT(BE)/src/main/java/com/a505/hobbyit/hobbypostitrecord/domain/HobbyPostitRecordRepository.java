package com.a505.hobbyit.hobbypostitrecord.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HobbyPostitRecordRepository extends JpaRepository<HobbyPostitRecord, Long> {
    List<HobbyPostitRecord> findByHobby(Hobby hobby);

    Optional<HobbyPostitRecord> findByHobbyAndRegDt(Hobby hobby, LocalDate regDt);
}
