package com.a505.hobbyit.hobbypostitrecord.domain;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbypostitrecord.dto.HobbyPostitRecordID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@IdClass(HobbyPostitRecordID.class)
@Table(name = "hobby_postit_record")
public class HobbyPostitRecord {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;

    @Id
    @Column(nullable = false)
    private LocalDate regDt;
}
