package com.a505.hobbyit.hobbyarticle.dto;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HobbyArticleDetailResponse {
    String title;

    String content;

    String author;

    String authorImage;

    LocalDateTime createdAt;

    List<String> images;

    int likes;

    public HobbyArticleDetailResponse of(HobbyArticle hobbyArticle){
        return HobbyArticleDetailResponse.builder()
                .title(hobbyArticle.getTitle())
                .content(hobbyArticle.getContent())
                .author(hobbyArticle.getMember().getNickname())
                .authorImage(hobbyArticle.getMember().getImgUrl())
                .createdAt(hobbyArticle.getWritedDate())
                .images(hobbyArticle.getImages())
                .likes(hobbyArticle.getLikeCount())
                .build();
    }
}
