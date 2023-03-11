package com.a505.hobbyit.hobbyarticlecomment.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobbyArticleComment is a Querydsl query type for HobbyArticleComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobbyArticleComment extends EntityPathBase<HobbyArticleComment> {

    private static final long serialVersionUID = 26655421L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHobbyArticleComment hobbyArticleComment = new QHobbyArticleComment("hobbyArticleComment");

    public final com.a505.hobbyit.common.QBaseEntity _super = new com.a505.hobbyit.common.QBaseEntity(this);

    public final StringPath content = createString("content");

    public final com.a505.hobbyit.hobbyarticle.domain.QHobbyArticle hobbyArticle;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.a505.hobbyit.member.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> writedDate = _super.writedDate;

    public QHobbyArticleComment(String variable) {
        this(HobbyArticleComment.class, forVariable(variable), INITS);
    }

    public QHobbyArticleComment(Path<? extends HobbyArticleComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHobbyArticleComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHobbyArticleComment(PathMetadata metadata, PathInits inits) {
        this(HobbyArticleComment.class, metadata, inits);
    }

    public QHobbyArticleComment(Class<? extends HobbyArticleComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobbyArticle = inits.isInitialized("hobbyArticle") ? new com.a505.hobbyit.hobbyarticle.domain.QHobbyArticle(forProperty("hobbyArticle"), inits.get("hobbyArticle")) : null;
        this.member = inits.isInitialized("member") ? new com.a505.hobbyit.member.domain.QMember(forProperty("member")) : null;
    }

}

