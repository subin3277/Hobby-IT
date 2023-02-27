package com.a505.hobbyit.hobbyarticlelike.domain;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import com.a505.hobbyit.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyArticleLikeRepository extends JpaRepository<HobbyArticleLike, Long> {
    boolean existsByMemberAndHobbyArticle(Member member, HobbyArticle hobbyArticle);
    void deleteHobbyArticleLikesByMemberAndHobbyArticle(Member member, HobbyArticle hobbyArticle);


}
