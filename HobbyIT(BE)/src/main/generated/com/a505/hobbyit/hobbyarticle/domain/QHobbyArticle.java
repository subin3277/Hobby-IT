package com.a505.hobbyit.hobbyarticle.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobbyArticle is a Querydsl query type for HobbyArticle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobbyArticle extends EntityPathBase<HobbyArticle> {

    private static final long serialVersionUID = 1317974717L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHobbyArticle hobbyArticle = new QHobbyArticle("hobbyArticle");

    public final com.a505.hobbyit.common.QBaseEntity _super = new com.a505.hobbyit.common.QBaseEntity(this);

    public final EnumPath<com.a505.hobbyit.hobbyarticle.enums.HobbyArticleCategory> category = createEnum("category", com.a505.hobbyit.hobbyarticle.enums.HobbyArticleCategory.class);

    public final StringPath content = createString("content");

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final com.a505.hobbyit.hobby.domain.QHobby hobby;

    public final ListPath<com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleComment, com.a505.hobbyit.hobbyarticlecomment.domain.QHobbyArticleComment> hobbyArticleComments = this.<com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleComment, com.a505.hobbyit.hobbyarticlecomment.domain.QHobbyArticleComment>createList("hobbyArticleComments", com.a505.hobbyit.hobbyarticlecomment.domain.HobbyArticleComment.class, com.a505.hobbyit.hobbyarticlecomment.domain.QHobbyArticleComment.class, PathInits.DIRECT2);

    public final ListPath<com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg, com.a505.hobbyit.hobbyarticleimg.domain.QHobbyArticleImg> hobbyArticleImg = this.<com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg, com.a505.hobbyit.hobbyarticleimg.domain.QHobbyArticleImg>createList("hobbyArticleImg", com.a505.hobbyit.hobbyarticleimg.domain.HobbyArticleImg.class, com.a505.hobbyit.hobbyarticleimg.domain.QHobbyArticleImg.class, PathInits.DIRECT2);

    public final ListPath<com.a505.hobbyit.hobbyarticlelike.domain.HobbyArticleLike, com.a505.hobbyit.hobbyarticlelike.domain.QHobbyArticleLike> hobbyArticleLikes = this.<com.a505.hobbyit.hobbyarticlelike.domain.HobbyArticleLike, com.a505.hobbyit.hobbyarticlelike.domain.QHobbyArticleLike>createList("hobbyArticleLikes", com.a505.hobbyit.hobbyarticlelike.domain.HobbyArticleLike.class, com.a505.hobbyit.hobbyarticlelike.domain.QHobbyArticleLike.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> like = createNumber("like", Integer.class);

    public final com.a505.hobbyit.member.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> writedDate = _super.writedDate;

    public QHobbyArticle(String variable) {
        this(HobbyArticle.class, forVariable(variable), INITS);
    }

    public QHobbyArticle(Path<? extends HobbyArticle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHobbyArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHobbyArticle(PathMetadata metadata, PathInits inits) {
        this(HobbyArticle.class, metadata, inits);
    }

    public QHobbyArticle(Class<? extends HobbyArticle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobby = inits.isInitialized("hobby") ? new com.a505.hobbyit.hobby.domain.QHobby(forProperty("hobby")) : null;
        this.member = inits.isInitialized("member") ? new com.a505.hobbyit.member.domain.QMember(forProperty("member")) : null;
    }

}

