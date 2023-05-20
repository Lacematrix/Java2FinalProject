package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface TagRepository extends JpaRepository<Tag, Long>{
  Tag findTagByTagCombination(String tagCombination);

  @Query("SELECT e.tagCombination,e.num FROM Tag e WHERE e.size=1 ORDER BY e.num DESC LIMIT 5")
  List<Tag> findMostUsedTags();

 Tag findTopBySizeOrderByUpvoteDesc(Integer size);

 Tag findTopBySizeOrderByViewDesc(Integer size);


}