package com.a505.hobbyit.hobbyarticleimg.domain;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="hobby_article_img")
public class HobbyArticleImg {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_art_id", nullable = false)
    private HobbyArticle hobbyArticle;

    @Column(nullable = false, length = 255)
    private String imgUrl;

    @Builder
    public HobbyArticleImg(HobbyArticle hobbyArticle, String imgUrl) {
        this.hobbyArticle = hobbyArticle;
        this.imgUrl = imgUrl;
    }

    public HobbyArticleImg toEntity(String imgUrl, HobbyArticle hobbyArticle) {
        return HobbyArticleImg.builder()
                .hobbyArticle(hobbyArticle)
                .imgUrl(imgUrl)
                .build();
    }
}
