package com.a505.hobbyit.hobbyarticlelike.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class HobbyArticleLikesID implements Serializable {
    private Long hobbyArticle;
    private Long member;
}
