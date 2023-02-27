package com.a505.hobbyit.hobbymember.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege;
import com.a505.hobbyit.hobbymember.enums.HobbyMemberState;
import com.a505.hobbyit.hobbymember.exception.UnAuthorizedHobbyMemberException;

import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="hobby_member")
@ToString
public class HobbyMember extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(nullable = false, name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "hobby_id")
    private Hobby hobby;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private HobbyMemberState state = HobbyMemberState.ACTIVE;

    @Column(nullable = false, name = "postit_reg_dt")
    private LocalDateTime postitRegDt;

    @Column(name = "resd_dt")
    private LocalDateTime resignedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "privilege", nullable = false)
    private HobbyMemberPrivilege privilege = HobbyMemberPrivilege.GENERAL;

    @Builder
    public HobbyMember(Member member, Hobby hobby, HobbyMemberState state, LocalDateTime resignedDate, HobbyMemberPrivilege privilege) {
        this.member = member;
        this.hobby = hobby;
        this.state = state;
        this.resignedDate = resignedDate;
        this.privilege = privilege;
    }

    public void updatePrivilege(HobbyMemberPrivilege hobbyMemberPrivilege){
        this.privilege = hobbyMemberPrivilege;
    }

    public void updateState(HobbyMemberState state){
        this.state = state;
    }

    public void checkPrivilege(){
        if(this.privilege != HobbyMemberPrivilege.OWNER) throw new UnAuthorizedHobbyMemberException();
    }

    public void checkMember(){
        if(this.state!= HobbyMemberState.ACTIVE) throw new UnAuthorizedHobbyMemberException("접근 권한이 없습니다.");
    }

    public HobbyMember ofGeneral(Member member, Hobby hobby){
        return HobbyMember.builder()
                .member(member)
                .hobby(hobby)
                .state(HobbyMemberState.ACTIVE)
                .privilege(HobbyMemberPrivilege.GENERAL)
                .build();
    }

    public void updatePostitRegDt(LocalDateTime localDateTime) {
        this.postitRegDt = localDateTime;
    }
}
