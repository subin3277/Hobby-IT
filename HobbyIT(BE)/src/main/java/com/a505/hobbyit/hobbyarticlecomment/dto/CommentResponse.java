package com.a505.hobbyit.hobbyarticlecomment.dto;

import com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CommentResponse {

    Long commentId;

    String author;

    LocalDateTime updateAt;

    String content;

    public CommentResponse of(HobbyArticleComment hobbyArticleComment){
        return CommentResponse
                .builder()
                .commentId(hobbyArticleComment.getId())
                .author(hobbyArticleComment.getMember().getNickname())
                .updateAt(hobbyArticleComment.getModifiedDate())
                .content(hobbyArticleComment.getContent())
                .build();
    }
}
