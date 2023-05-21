package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag, Long>{
  Tag getTagByTagCombination(String tagCombination);

  @Query("SELECT e.tagCombination,e.num FROM Tag e WHERE e.size=1 ORDER BY e.num DESC LIMIT 5")
  List<Tag> findMostUsedTags();

  @Query("SELECT e.tagCombination,e.upvote FROM Tag e WHERE e.size=:size ORDER BY e.upvote DESC LIMIT 1")
 Tag findMaxUpvote(@Param("size") Integer size);

  @Query("SELECT e.tagCombination,e.view FROM Tag e WHERE e.size=:size ORDER BY e.view DESC LIMIT 1")
 Tag findMaxView(@Param("size") Integer size);


}