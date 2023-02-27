package com.a505.hobbyit.hobbyarticlecomment.domain;

import com.a505.hobbyit.hobbyarticle.domain.HobbyArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HobbyArticleCommentRepository extends JpaRepository<HobbyArticleComment, Long> {
    List<HobbyArticleComment> findAllByHobbyArticleOrderByIdDesc(HobbyArticle hobbyArticle);
}
