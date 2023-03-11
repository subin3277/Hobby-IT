package com.a505.hobbyit.hobby.domain;

import com.a505.hobbyit.hobby.dto.HobbyUpdateRequest;
import com.a505.hobbyit.hobby.enums.HobbyFree;
import com.a505.hobbyit.hobby.exception.OverCapacityException;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.pending.domain.Pending;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "hobby")
public class Hobby {

    @Column(nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 16)
    private String category;

    @Column(nullable = false, length = 128)
    private String intro;

    @Column(name = "cur_mem_cnt", nullable = false)
    private int currentMemberCount;

    @Column(name = "max_mem_cnt", nullable = false, length = 16)
    private int maxMemberCount;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HobbyFree free;

    @Column(name = "reg_dt",nullable = false)
    private final LocalDateTime createdDateTime = LocalDateTime.now();

    @Column(name = "resd_req_dt")
    private LocalDateTime deletedDateTime;

    @Builder
    public Hobby(String name, String imgUrl, int currentMemberCount, int maxMemberCount, String intro, String category, HobbyFree free) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.currentMemberCount = currentMemberCount;
        this.maxMemberCount = maxMemberCount;
        this.intro = intro;
        this.category = category;
        this.free = free;
    }

    @OneToMany(mappedBy = "hobby", fetch = FetchType.LAZY)
    private List<Pending> pendings = new ArrayList<>();

    @OneToMany(mappedBy = "hobby")
    private List<HobbyMember> hobbyMembers = new ArrayList<>();

    public void updateCnt(){
        this.currentMemberCount = hobbyMembers.size();
    }

    public void checkMemberCount(){
        if(this.maxMemberCount == this.currentMemberCount) throw new OverCapacityException();
    }

    public void updateHobby(HobbyUpdateRequest request, String imgUrl){
        this.name = request.getName();
        this.intro = request.getIntro();
        this.maxMemberCount = request.getMax_participants_num();
        this.imgUrl = imgUrl;
    }

    public void isCheckOverCapacity(){
        if(this.currentMemberCount == maxMemberCount) throw new OverCapacityException("모임 인원이 가득 차 더이상 참여할 수 업습니다.");
    }
}
