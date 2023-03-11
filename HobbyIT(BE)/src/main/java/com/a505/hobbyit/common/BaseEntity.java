package com.a505.hobbyit.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class) // 변화 감지에 따른 값을 추가해주기 위한 어노테이션
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "reg_dt", nullable = false, updatable = false)
    private LocalDateTime writedDate;

    @LastModifiedDate
    @Column(name = "chg_dt", nullable = false)
    private LocalDateTime modifiedDate;

}

