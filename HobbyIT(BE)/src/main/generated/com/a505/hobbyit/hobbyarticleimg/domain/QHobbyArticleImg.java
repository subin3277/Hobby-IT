package com.a505.hobbyit.hobbyarticleimg.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobbyArticleImg is a Querydsl query type for HobbyArticleImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobbyArticleImg extends EntityPathBase<HobbyArticleImg> {

    private static final long serialVersionUID = 1682350013L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHobbyArticleImg hobbyArticleImg = new QHobbyArticleImg("hobbyArticleImg");

    public final com.a505.hobbyit.hobbyarticle.domain.QHobbyArticle hobbyArticle;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public QHobbyArticleImg(String variable) {
        this(HobbyArticleImg.class, forVariable(variable), INITS);
    }

    public QHobbyArticleImg(Path<? extends HobbyArticleImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHobbyArticleImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHobbyArticleImg(PathMetadata metadata, PathInits inits) {
        this(HobbyArticleImg.class, metadata, inits);
    }

    public QHobbyArticleImg(Class<? extends HobbyArticleImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobbyArticle = inits.isInitialized("hobbyArticle") ? new com.a505.hobbyit.hobbyarticle.domain.QHobbyArticle(forProperty("hobbyArticle"), inits.get("hobbyArticle")) : null;
    }

}

