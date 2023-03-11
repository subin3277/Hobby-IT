package com.a505.hobbyit.hobbypostit.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobbyPostit is a Querydsl query type for HobbyPostit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobbyPostit extends EntityPathBase<HobbyPostit> {

    private static final long serialVersionUID = 1863419549L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHobbyPostit hobbyPostit = new QHobbyPostit("hobbyPostit");

    public final com.a505.hobbyit.hobby.domain.QHobby hobby;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final com.a505.hobbyit.member.domain.QMember member;

    public final DateTimePath<java.time.LocalDateTime> regDt = createDateTime("regDt", java.time.LocalDateTime.class);

    public QHobbyPostit(String variable) {
        this(HobbyPostit.class, forVariable(variable), INITS);
    }

    public QHobbyPostit(Path<? extends HobbyPostit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHobbyPostit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHobbyPostit(PathMetadata metadata, PathInits inits) {
        this(HobbyPostit.class, metadata, inits);
    }

    public QHobbyPostit(Class<? extends HobbyPostit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobby = inits.isInitialized("hobby") ? new com.a505.hobbyit.hobby.domain.QHobby(forProperty("hobby")) : null;
        this.member = inits.isInitialized("member") ? new com.a505.hobbyit.member.domain.QMember(forProperty("member")) : null;
    }

}

