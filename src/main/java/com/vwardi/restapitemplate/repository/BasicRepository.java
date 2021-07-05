package com.vwardi.restapitemplate.repository;

import com.vwardi.restapitemplate.model.Basic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicRepository  extends JpaRepository<Basic, Long> {
//
//    @Query("select j from JokeModel j")
//    Page<JokeModel> findAllPage(Pageable pageable);
//
//    @Query("select j from JokeModel j where lower(j.joke) like lower(concat('%', :input, '%'))")
//    List<JokeModel> findFullTextSearchByInputTextIgnoreCase(@Param("input") String input);
//
//    @Query(value = "select * from joke order by rand() limit 1 ", nativeQuery = true)
//    JokeModel getRandomJoke();
}