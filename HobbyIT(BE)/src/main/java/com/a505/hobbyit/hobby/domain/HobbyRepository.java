package com.a505.hobbyit.hobby.domain;

import com.a505.hobbyit.hobby.dto.HobbyResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {

    Boolean existsByName(String name);

    @Query(value = "SELECT h "
            + "FROM hobby h "
            + "WHERE h.name like %:keyword%"
            + "OR h.category like %:keyword%"
            + "DESC", nativeQuery = true)
    List<Hobby> findByKeyword(final String keyword);

    List<Hobby> findHobbiesByCategoryContainingOrderByCurrentMemberCountDesc(String keyword, Pageable pageable);

    List<Hobby> findHobbiesByNameContainingOrderByCurrentMemberCountDesc(final String keyword, Pageable pageable);
    List<Hobby> findByNameLikeOrCategoryLikeOrderByIdDesc(String name, String category, Pageable pageable);

    @Query(value = "SELECT * "
            + "FROM hobby "
            + "ORDER BY RAND() "
            + "LIMIT 10", nativeQuery = true)
    List<Hobby> findPopularHobby();

    @Query(value = "SELECT * "
            + "FROM hobby "
            + "ORDER BY reg_dt "
            + "DESC "
            + "LIMIT 10 ", nativeQuery = true)
    List<Hobby> findFreshHobby();

}
