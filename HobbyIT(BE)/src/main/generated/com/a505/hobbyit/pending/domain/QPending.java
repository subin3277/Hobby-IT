package com.a505.hobbyit.pending.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPending is a Querydsl query type for Pending
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPending extends EntityPathBase<Pending> {

    private static final long serialVersionUID = 1310714813L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPending pending = new QPending("pending");

    public final com.a505.hobbyit.common.QBaseEntity _super = new com.a505.hobbyit.common.QBaseEntity(this);

    public final com.a505.hobbyit.hobby.domain.QHobby hobby;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.a505.hobbyit.member.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath msg = createString("msg");

    public final EnumPath<com.a505.hobbyit.pending.enums.PendingAllow> pendingAllow = createEnum("pendingAllow", com.a505.hobbyit.pending.enums.PendingAllow.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> writedDate = _super.writedDate;

    public QPending(String variable) {
        this(Pending.class, forVariable(variable), INITS);
    }

    public QPending(Path<? extends Pending> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPending(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPending(PathMetadata metadata, PathInits inits) {
        this(Pending.class, metadata, inits);
    }

    public QPending(Class<? extends Pending> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobby = inits.isInitialized("hobby") ? new com.a505.hobbyit.hobby.domain.QHobby(forProperty("hobby")) : null;
        this.member = inits.isInitialized("member") ? new com.a505.hobbyit.member.domain.QMember(forProperty("member")) : null;
    }

}

