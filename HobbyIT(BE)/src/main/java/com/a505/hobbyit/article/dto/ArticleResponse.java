package com.a505.hobbyit.article.dto;

import com.a505.hobbyit.article.domain.Article;
import com.a505.hobbyit.article.enums.ArticleHeader;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "홍보 게시판 API Response DTO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ArticleResponse {

    @Schema(description = "게시글 ID", example = "1")
    private Long id;

    @Schema(description = "게시글 작성자 닉네임", example = "첫블루안주면던짐")
    private String nickname;

    @Schema(description = "홍보할 소모임 ID", example = "1")
    private Long hobbyId;

    @Schema(description = "홍보할 소모임 이름", example = "john, 나 여행가고싶어")
    private String hobbyName;

    @Schema(description = "게시글 글머리", example = "RECRUITMENT OR MEETUP")
    private ArticleHeader header;

    @Schema(description = "게시글 제목", example = "'여행 가고 싶어' 회원 모집합니다.")
    private String title;

    @Schema(description = "게시글 본문", example = "'여행 가고 싶어' 의 회원을 모집합니다. \n조건: 나이 20세 이상, 대한민국 거주자")
    private String content;

    @Schema(description = "게시글 작성일", example = "2023-02-06T08:40:23.202Z")
    private LocalDateTime regDt;

    @Schema(description = "게시글 수정일", example = "2023-02-06T08:40:23.202Z")
    private LocalDateTime chgDt;

    @Schema(description = "게시글 조회수", example = "0")
    private int hit;

    public ArticleResponse of(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .nickname(article.getMember().getNickname())
                .hobbyId(article.getHobby().getId())
                .hobbyName(article.getHobby().getName())
                .header(article.getHeader())
                .title(article.getTitle())
                .content(article.getContent())
                .regDt(article.getWritedDate())
                .chgDt(article.getModifiedDate())
                .hit(article.getHit())
                .build();
    }
}
