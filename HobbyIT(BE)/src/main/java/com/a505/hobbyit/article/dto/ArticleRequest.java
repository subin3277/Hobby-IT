package com.a505.hobbyit.article.dto;

import com.a505.hobbyit.article.domain.Article;
import com.a505.hobbyit.article.enums.ArticleHeader;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArticleRequest {

    @Schema(description = "게시글 글머리", example = "RECRUITMENT OR MEETUP")
    @NotNull(message = "글머리는 필수 입력 사항입니다.")
    private ArticleHeader header;

    @Schema(description = "게시글 제목", example = "'여행 가고 싶어' 회원 모집합니다.")
    @NotNull(message = "제목은 필수 입력 사항입니다.")
    private String title;

    @Schema(description = "게시글 본문", example = "'여행 가고 싶어' 의 회원을 모집합니다. 조건: 나이 20세 이상, 대한민국 거주자")
    @NotNull(message = "본문은 필수 입력 사항입니다.")
    private String content;

    public Article toEntity(Member member, Hobby hobby) {
        return Article.builder()
                .member(member)
                .hobby(hobby)
                .header(header)
                .title(title)
                .content(content)
                .build();
    }
}
