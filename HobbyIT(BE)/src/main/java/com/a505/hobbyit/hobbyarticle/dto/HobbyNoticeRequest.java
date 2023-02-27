package com.a505.hobbyit.hobbyarticle.dto;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.hobbyarticle.enums.HobbyArticleCategory;
import com.a505.hobbyit.member.domain.Member;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HobbyNoticeRequest {
    @NotNull
    private String title;
    @NotNull
    private String content;

    public HobbyArticle toEntity(Member member, Hobby hobby){
        return HobbyArticle.builder()
                .member(member)
                .hobby(hobby)
                .category(HobbyArticleCategory.NOTICE)
                .title(title)
                .content(content)
                .build();
    };
}
