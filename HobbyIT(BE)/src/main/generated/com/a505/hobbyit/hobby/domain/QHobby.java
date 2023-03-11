package com.a505.hobbyit.hobby.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobby is a Querydsl query type for Hobby
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobby extends EntityPathBase<Hobby> {

    private static final long serialVersionUID = -2106753187L;

    public static final QHobby hobby = new QHobby("hobby");

    public final StringPath category = createString("category");

    public final DateTimePath<java.time.LocalDateTime> createdDateTime = createDateTime("createdDateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> currentMemberCount = createNumber("currentMemberCount", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> deletedDateTime = createDateTime("deletedDateTime", java.time.LocalDateTime.class);

    public final EnumPath<com.a505.hobbyit.hobby.enums.HobbyFree> free = createEnum("free", com.a505.hobbyit.hobby.enums.HobbyFree.class);

    public final ListPath<com.a505.hobbyit.hobbymember.domain.HobbyMember, com.a505.hobbyit.hobbymember.domain.QHobbyMember> hobbyMembers = this.<com.a505.hobbyit.hobbymember.domain.HobbyMember, com.a505.hobbyit.hobbymember.domain.QHobbyMember>createList("hobbyMembers", com.a505.hobbyit.hobbymember.domain.HobbyMember.class, com.a505.hobbyit.hobbymember.domain.QHobbyMember.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final StringPath intro = createString("intro");

    public final NumberPath<Integer> maxMemberCount = createNumber("maxMemberCount", Integer.class);

    public final StringPath name = createString("name");

    public final ListPath<com.a505.hobbyit.pending.domain.Pending, com.a505.hobbyit.pending.domain.QPending> pendings = this.<com.a505.hobbyit.pending.domain.Pending, com.a505.hobbyit.pending.domain.QPending>createList("pendings", com.a505.hobbyit.pending.domain.Pending.class, com.a505.hobbyit.pending.domain.QPending.class, PathInits.DIRECT2);

    public QHobby(String variable) {
        super(Hobby.class, forVariable(variable));
    }

    public QHobby(Path<? extends Hobby> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHobby(PathMetadata metadata) {
        super(Hobby.class, metadata);
    }

}

