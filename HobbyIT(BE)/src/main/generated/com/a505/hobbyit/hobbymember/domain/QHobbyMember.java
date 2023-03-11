package com.a505.hobbyit.hobbymember.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobbyMember is a Querydsl query type for HobbyMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobbyMember extends EntityPathBase<HobbyMember> {

    private static final long serialVersionUID = -796238275L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHobbyMember hobbyMember = new QHobbyMember("hobbyMember");

    public final com.a505.hobbyit.common.QBaseEntity _super = new com.a505.hobbyit.common.QBaseEntity(this);

    public final com.a505.hobbyit.hobby.domain.QHobby hobby;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.a505.hobbyit.member.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final DateTimePath<java.time.LocalDateTime> postitRegDt = createDateTime("postitRegDt", java.time.LocalDateTime.class);

    public final EnumPath<com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege> privilege = createEnum("privilege", com.a505.hobbyit.hobbymember.enums.HobbyMemberPrivilege.class);

    public final DateTimePath<java.time.LocalDateTime> resignedDate = createDateTime("resignedDate", java.time.LocalDateTime.class);

    public final EnumPath<com.a505.hobbyit.hobbymember.enums.HobbyMemberState> state = createEnum("state", com.a505.hobbyit.hobbymember.enums.HobbyMemberState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> writedDate = _super.writedDate;

    public QHobbyMember(String variable) {
        this(HobbyMember.class, forVariable(variable), INITS);
    }

    public QHobbyMember(Path<? extends HobbyMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHobbyMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHobbyMember(PathMetadata metadata, PathInits inits) {
        this(HobbyMember.class, metadata, inits);
    }

    public QHobbyMember(Class<? extends HobbyMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobby = inits.isInitialized("hobby") ? new com.a505.hobbyit.hobby.domain.QHobby(forProperty("hobby")) : null;
        this.member = inits.isInitialized("member") ? new com.a505.hobbyit.member.domain.QMember(forProperty("member")) : null;
    }

}

