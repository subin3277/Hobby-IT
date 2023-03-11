package com.a505.hobbyit.hobbyarticle.dto;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HobbyNoticeResponse {
    Long id;
    String title;

    String content;

    String author;

    String authorImage;

    LocalDateTime createdAt;

    int likes;

    int commentCount;

    public HobbyNoticeResponse of(HobbyArticle hobbyArticle){
        return HobbyNoticeResponse.builder()
                .id(hobbyArticle.getId())
                .title(hobbyArticle.getTitle())
                .content(hobbyArticle.getContent())
                .author(hobbyArticle.getMember().getNickname())
                .authorImage(hobbyArticle.getMember().getImgUrl())
                .createdAt(hobbyArticle.getWritedDate())
                .likes(hobbyArticle.getLikeCount())
                .commentCount(hobbyArticle.getCommentCount())
                .build();
    }
}
