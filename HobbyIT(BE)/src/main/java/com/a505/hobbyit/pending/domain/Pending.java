package com.a505.hobbyit.pending.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import com.a505.hobbyit.pending.enums.PendingAllow;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Pending extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "hobby_id")
    private Hobby hobby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "member_id")
    private Member member;

    @Column(nullable = false, length = 200)
    private String msg;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private PendingAllow pendingAllow;

    public void updatePendingAllow(PendingAllow pendingALlow){
        this.pendingAllow = pendingALlow;
    }

    @Builder
    public Pending(Hobby hobby, Member member, String msg, PendingAllow pendingAllow) {
        this.hobby = hobby;
        this.member = member;
        this.msg = msg;
        this.pendingAllow = pendingAllow;
    }
}
