package com.a505.hobbyit.hobbyarticle.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbyarticle.enums.HobbyArticleCategory;
import com.a505.hobbyit.hobbyarticle.exception.UnAuthorizedException;
import com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleComment;
import com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg;
import com.a505.hobbyit.hobbyarticlelike.domain.HobbyArticleLike;
import com.a505.hobbyit.member.domain.Member;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "hobby_article")
public class HobbyArticle extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hobby_id", nullable = false)
    private Hobby hobby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private HobbyArticleCategory category;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(nullable = false, length = 512)
    private String content;

    @Column(nullable = false)
    private int hit = 0;

    @Column(name="`like`",nullable = false)
    private int like = 0;

    @Builder
    public HobbyArticle(Hobby hobby, Member member, HobbyArticleCategory category, String title, String content) {
        this.hobby = hobby;
        this.member = member;
        this.category = category;
        this.title = title;
        this.content = content;

    }

    public void updateTitle(String title){
        this.title = title;
    }

    public void updateContent(String content){
        this.content = content;
    }

    public void updateHit(){
        this.hit++;
    }


    @OneToMany(mappedBy = "hobbyArticle")
    private List<HobbyArticleComment> hobbyArticleComments = new ArrayList<>();
    @OneToMany(mappedBy = "hobbyArticle")
    private List<HobbyArticleImg> hobbyArticleImg = new ArrayList<>();
    @OneToMany(mappedBy = "hobbyArticle")
    private List<HobbyArticleLike> hobbyArticleLikes = new ArrayList<>();

    public int getCommentCount(){
        return this.hobbyArticleComments.size();
    }
    public int getLikeCount(){
        return this.hobbyArticleLikes.size();
    }
    public String getThumbnailPath(){
        return this.hobbyArticleImg
                .get(0)
                .getImgUrl();
    }

    // 이미지를 주소를 반환하는 메서드
    public List<String> getImages(){
        List<String> images = new ArrayList<>();
        for (HobbyArticleImg image : hobbyArticleImg) {
            images.add(image.getImgUrl());
        }
        return images;
    }
    public void checkAuthor(Member member){
        if(!this.member.equals(member)) throw new UnAuthorizedException();
    }
}
