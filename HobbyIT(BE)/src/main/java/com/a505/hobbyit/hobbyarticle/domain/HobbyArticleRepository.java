package com.a505.hobbyit.hobbyarticle.domain;

import com.a505.hobbyit.hobby.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HobbyArticleRepository extends JpaRepository<HobbyArticle, Long>, HobbyArticleQRepository {
    /*
        검색하는 쿼리 구현할 것
     */
    List<HobbyArticle> findByHobbyAndTitleContaining(Hobby hobby, String keyword);
    List<HobbyArticle> findByHobby(Hobby hobby);

}
