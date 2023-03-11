package com.a505.hobbyit.hobbyarticlecomment.dto;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleComment;
import com.a505.hobbyit.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CommentRequest {
    String content;

    public HobbyArticleComment toEntity(Member member, HobbyArticle hobbyArticle){
        return HobbyArticleComment
                .builder()
                .member(member)
                .hobbyArticle(hobbyArticle)
                .content(content)
                .build();
    }
}
