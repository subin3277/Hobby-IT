package com.a505.hobbyit.hobbyarticle.dto;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.enums.HobbyArticleCategory;
import com.a505.hobbyit.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class HobbyArticleRequest {
    String title;
    String content;
    HobbyArticleCategory category;

    public HobbyArticle toEntity(Member member, Hobby hobby){
        return HobbyArticle.builder()
                .member(member)
                .hobby(hobby)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }
}
