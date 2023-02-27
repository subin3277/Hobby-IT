package com.a505.hobbyit.hobbypostit.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HobbyPostitRepository extends JpaRepository<HobbyPostit, Long> {

    List<HobbyPostit> findByHobbyAndRegDtBetween(
            Hobby hobby, LocalDateTime startDateTime, LocalDateTime endDateTime
    );
}
