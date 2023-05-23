package com.example.stackoverflow.repository;

import com.example.stackoverflow.model.Tag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Long> {

  Tag getTagByCombination(String tagCombination);

  List<Tag> findTop5BySizeOrderByNumDesc(Integer size);

  List<Tag> findTopBySizeOrderByUpvoteDesc(Integer size);

  List<Tag> findTopBySizeOrderByViewDesc(Integer size);

}