package com.a505.hobbyit.member.domain;

import com.a505.hobbyit.common.BaseEntity;
import com.a505.hobbyit.member.dto.request.MemberMypageRequest;
import com.a505.hobbyit.hobbymember.domain.HobbyMember;
import com.a505.hobbyit.member.enums.MemberIsSns;
import com.a505.hobbyit.member.enums.MemberState;
import com.a505.hobbyit.member.exception.NoSuchMemberException;
import com.a505.hobbyit.pending.domain.Pending;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@NamedQuery(name = "findById", query = "select m from Member m where m.id = :id")
@Table(name = "member")
public class Member extends BaseEntity implements UserDetails {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String email;

    @Column(nullable = false, length = 16)
    private String name;

    @Column(nullable = false, length = 16)
    private String nickname;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(length = 128)
    private String intro;

    @Column(nullable = false)
    private int ownedHobbyCnt;

    @Column(nullable = false)
    private int point;

    @Column
    private String imgUrl;

    @Column(nullable = false, length = 16)
    @Enumerated(EnumType.STRING)
    private MemberState state;

    @Column
    private LocalDateTime resdReqDt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 5)
    private MemberIsSns isSns;

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> privilege;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.privilege.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Member() {
    }

    @Builder
    public Member(Long id, String email, String name, String nickname, String password, String intro, int ownedHobbyCnt, int point, String imgUrl, LocalDateTime resdReqDt, MemberIsSns isSns, MemberState state, Set<String> privilege) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.intro = intro;
        this.ownedHobbyCnt = ownedHobbyCnt;
        this.point = point;
        this.imgUrl = imgUrl;
        this.isSns = isSns;
        this.state = state;
        this.resdReqDt = resdReqDt;
        this.privilege = privilege;
    }

    public void updateSnsMember(String imgUrl) {
        this.isSns = MemberIsSns.TRUE;
        this.imgUrl = imgUrl;
    }

    public void updateState(MemberState state, LocalDateTime resdReqDt) {
        this.state = state;
        this.resdReqDt = resdReqDt;
    }

    public void resetPassword(String password) {
        this.password = password;
    }

    public void updateMember(MemberMypageRequest request, String imgUrl) {
        this.nickname = request.getNickname();
        if (!"".equals(request.getPassword())) {
            this.password = request.getPassword();
        }
        this.intro = request.getIntro();
        this.imgUrl = imgUrl;
    }

    public void checkWaiting() {
        if (this.state != MemberState.ACTIVE) {
            throw new NoSuchMemberException("탈퇴할 수 없는 회원입니다.");
        }
    }

    @OneToMany(mappedBy = "member")
    private List<HobbyMember> hobbyMembers = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Pending> pendings = new ArrayList<>();

//
//    @OneToMany(mappedBy = "member")
//    private List<GroupArticle> groupArticles = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<GroupComment> groupComments = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Article> articles = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Comment> comments = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Postit> postits = new ArrayList<>();
}
