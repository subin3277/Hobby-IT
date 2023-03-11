package com.a505.hobbyit.hobbyarticle.dto;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HobbyArticleResponse {
    Long id;
    String title;

    String content;

    String author;

    String authorImage;

    LocalDateTime createdAt;

    String thumbnail;

    int likes;

    int commentCount;

    public HobbyArticleResponse of(HobbyArticle hobbyArticle){
        return HobbyArticleResponse.builder()
                .id(hobbyArticle.getId())
                .title(hobbyArticle.getTitle())
                .content(hobbyArticle.getContent())
                .author(hobbyArticle.getMember().getNickname())
                .authorImage(hobbyArticle.getMember().getImgUrl())
                .createdAt(hobbyArticle.getWritedDate())
                .thumbnail(hobbyArticle.getThumbnailPath())
                .likes(hobbyArticle.getLikeCount())
                .commentCount(hobbyArticle.getCommentCount())
                .build();
    }
}
