package com.a505.hobbyit.article.domain;

import com.a505.hobbyit.article.dto.ArticleRequest;
import com.a505.hobbyit.article.enums.ArticleHeader;
import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "article")
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private ArticleHeader header;

    @NotNull
    @Column(length = 128)
    private String title;

    @NotNull
    @Column(length = 512)
    private String content;

    @NotNull
    @Column
    private int hit;

    public void updateArticle(ArticleRequest articleRequest) {
        this.header = articleRequest.getHeader();
        this.title = articleRequest.getTitle();
        this.content = articleRequest.getContent();
    }

    public void updateHit() {
        this.hit++;
    }
}
