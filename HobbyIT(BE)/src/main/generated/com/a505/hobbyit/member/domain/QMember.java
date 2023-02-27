package com.a505.hobbyit.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -925390519L;

    public static final QMember member = new QMember("member1");

    public final com.a505.hobbyit.common.QBaseEntity _super = new com.a505.hobbyit.common.QBaseEntity(this);

    public final StringPath email = createString("email");

    public final ListPath<com.a505.hobbyit.hobbymember.domain.HobbyMember, com.a505.hobbyit.hobbymember.domain.QHobbyMember> hobbyMembers = this.<com.a505.hobbyit.hobbymember.domain.HobbyMember, com.a505.hobbyit.hobbymember.domain.QHobbyMember>createList("hobbyMembers", com.a505.hobbyit.hobbymember.domain.HobbyMember.class, com.a505.hobbyit.hobbymember.domain.QHobbyMember.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final StringPath intro = createString("intro");

    public final EnumPath<com.a505.hobbyit.member.enums.MemberIsSns> isSns = createEnum("isSns", com.a505.hobbyit.member.enums.MemberIsSns.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Integer> ownedHobbyCnt = createNumber("ownedHobbyCnt", Integer.class);

    public final StringPath password = createString("password");

    public final ListPath<com.a505.hobbyit.pending.domain.Pending, com.a505.hobbyit.pending.domain.QPending> pendings = this.<com.a505.hobbyit.pending.domain.Pending, com.a505.hobbyit.pending.domain.QPending>createList("pendings", com.a505.hobbyit.pending.domain.Pending.class, com.a505.hobbyit.pending.domain.QPending.class, PathInits.DIRECT2);

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final SetPath<String, StringPath> privilege = this.<String, StringPath>createSet("privilege", String.class, StringPath.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> resdReqDt = createDateTime("resdReqDt", java.time.LocalDateTime.class);

    public final EnumPath<com.a505.hobbyit.member.enums.MemberState> state = createEnum("state", com.a505.hobbyit.member.enums.MemberState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> writedDate = _super.writedDate;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

