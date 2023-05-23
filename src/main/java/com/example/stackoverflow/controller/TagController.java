package com.example.stackoverflow.controller;

import com.example.stackoverflow.model.Tag;
import com.example.stackoverflow.service.TagService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Tag")
public class TagController {

  private final TagService tagService;

  public TagController(TagService tagService) {
    this.tagService = tagService;
  }


  @GetMapping("/MostUsedTags")
  public ResponseEntity<Object> get5MostUsedTags() {
    List<Tag> tagsOrigin = tagService.getMostUsedTags();
    Map<String, Integer> tags = new HashMap<>();
    for (Tag x : tagsOrigin) {
      tags.put(x.getCombination(), x.getNum());
    }
    return ResponseEntity.ok(tags);
  }

  @GetMapping("/getTopUpvotedTag")
  public ResponseEntity<Object> getTopUpvotedTag() {
    Map<String, Integer> tags = new HashMap<>();
    for (int i = 1; i <= 4; i++) {
      Tag temp = tagService.getTopUpvotedTag(i);
      tags.put(temp.getCombination(), temp.getUpvote());
    }
    return ResponseEntity.ok(tags);
  }

  @GetMapping("/getTopViewTag")
  public ResponseEntity<Object> getTopViewTag() {// TODO: 2023/5/21  front end. method return most view tagCombination(object) with the input size, it is recommend to display size 2 to 4
    Map<String, Integer> tags = new HashMap<>();
    for (int i = 1; i <= 4; i++) {
      Tag temp = tagService.getTopViewTag(i);
      tags.put(temp.getCombination(), temp.getView());
    }
    return ResponseEntity.ok(tags);
  }

  @GetMapping
  public ResponseEntity<Object> getTag() {
    return ResponseEntity.ok(tagService.getAllTags());
  }
}
