package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag, Long>{
  Tag getTagByCombination(String tagCombination);

//  @Query(value="SELECT combination,num FROM Tag WHERE Tag.size=1 ORDER BY num DESC LIMIT 5",nativeQuery = true)
  List<Tag> findTop5BySizeOrderByNumDesc(Integer size);

//  @Query(value = "SELECT combination,upvote FROM Tag  WHERE Tag.size=:s ORDER BY upvote DESC LIMIT 1",nativeQuery = true)
// Tag findMaxUpvote(@Param("s") Integer s);
  List<Tag> findTopBySizeOrderByUpvoteDesc(Integer size);
//  @Query(value = "SELECT combination,view FROM Tag WHERE Tag.size=:s ORDER BY view DESC LIMIT 1",nativeQuery = true)
// Tag findMaxView(@Param("s") Integer s);

  List<Tag> findTopBySizeOrderByViewDesc(Integer size);

}