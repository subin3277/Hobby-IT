package com.a505.hobbyit.article.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = 2136138205L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticle article = new QArticle("article");

    public final com.a505.hobbyit.common.QBaseEntity _super = new com.a505.hobbyit.common.QBaseEntity(this);

    public final StringPath content = createString("content");

    public final EnumPath<com.a505.hobbyit.article.enums.ArticleHeader> header = createEnum("header", com.a505.hobbyit.article.enums.ArticleHeader.class);

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final com.a505.hobbyit.hobby.domain.QHobby hobby;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.a505.hobbyit.member.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> writedDate = _super.writedDate;

    public QArticle(String variable) {
        this(Article.class, forVariable(variable), INITS);
    }

    public QArticle(Path<? extends Article> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticle(PathMetadata metadata, PathInits inits) {
        this(Article.class, metadata, inits);
    }

    public QArticle(Class<? extends Article> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobby = inits.isInitialized("hobby") ? new com.a505.hobbyit.hobby.domain.QHobby(forProperty("hobby")) : null;
        this.member = inits.isInitialized("member") ? new com.a505.hobbyit.member.domain.QMember(forProperty("member")) : null;
    }

}

