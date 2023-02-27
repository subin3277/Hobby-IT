package com.a505.hobbyit.hobbyarticlelike.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobbyArticleLike is a Querydsl query type for HobbyArticleLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobbyArticleLike extends EntityPathBase<HobbyArticleLike> {

    private static final long serialVersionUID = -790670325L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHobbyArticleLike hobbyArticleLike = new QHobbyArticleLike("hobbyArticleLike");

    public final com.a505.hobbyit.hobbyarticle.domain.QHobbyArticle hobbyArticle;

    public final com.a505.hobbyit.member.domain.QMember member;

    public QHobbyArticleLike(String variable) {
        this(HobbyArticleLike.class, forVariable(variable), INITS);
    }

    public QHobbyArticleLike(Path<? extends HobbyArticleLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHobbyArticleLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHobbyArticleLike(PathMetadata metadata, PathInits inits) {
        this(HobbyArticleLike.class, metadata, inits);
    }

    public QHobbyArticleLike(Class<? extends HobbyArticleLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobbyArticle = inits.isInitialized("hobbyArticle") ? new com.a505.hobbyit.hobbyarticle.domain.QHobbyArticle(forProperty("hobbyArticle"), inits.get("hobbyArticle")) : null;
        this.member = inits.isInitialized("member") ? new com.a505.hobbyit.member.domain.QMember(forProperty("member")) : null;
    }

}

