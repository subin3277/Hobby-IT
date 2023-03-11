package com.a505.hobbyit.item.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "item")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column(nullable = false, length = 30)
    private Long itemTypeId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(name = "rqd_point", nullable = false)
    private int requiredPoint;

    @Column(nullable = false, length = 255)
    private String imgUrl;
}
