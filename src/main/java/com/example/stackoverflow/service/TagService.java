package com.example.stackoverflow.service;

import LoadData.DataClass.QuestionLoad;
import LoadData.DataClass.TagLoad;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.stackoverflow.model.Question;
import com.example.stackoverflow.model.Tag;
import com.example.stackoverflow.repository.QuestionRepository;
import com.example.stackoverflow.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class TagService {
  private final TagRepository tagRepository;

  @Autowired
  public TagService(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }
  public List<Tag> getMostUsedTags(){
    return tagRepository.findMostUsedTags();
  }

  public Tag getTopUpvotedTag(int size){
    return tagRepository.findTopBySizeOrderByUpvoteDesc(size);
  }
  public Tag getTopViewTag(int size){
    return tagRepository.findTopBySizeOrderByViewDesc(size);
  }


  public void saveTags(String tagCombination,int size,int view,int upvote){
    Tag tag = tagRepository.findTagByTagCombination(tagCombination);
    if (tag != null) {
      tag.setNum(tag.getNum() + 1);
      tag.setView(tag.getView()+view);
      tag.setUpvote(tag.getUpvote()+upvote);
    } else {
      Tag newTag = new Tag();
      newTag.setTagCombination(tagCombination);
      newTag.setNum(1);
      newTag.setSize(size);
      newTag.setView(view);
      newTag.setUpvote(upvote);
      tagRepository.save(newTag);
    }
  }

  public void addTag(int n) throws IOException {
    for (int i = 1; i <= n; i++) {
      String jsonStrings = Files.readString(Path.of("src/main/java/LoadData/Data/Tag/Tag" + i + ".json"));
      JSONObject jsonObject = JSON.parseObject(jsonStrings);
      JSONArray itemsArray = jsonObject.getJSONArray("items");
      List<TagLoad> tagdata = itemsArray.toJavaList(TagLoad.class);
      for (TagLoad q : tagdata) {
        StringBuilder stringBuilder=new StringBuilder();
        List<String> tags=q.getTags();
        for (int j=0;j<tags.size();j++){
          String curTag=tags.get(j);
          if (!curTag.equals("java")){
            saveTags(curTag,1,q.getView_count(),q.getUp_vote_count());
          }
          if (j!=tags.size()-1){
            stringBuilder.append(curTag).append(",");
          }
          else{
            stringBuilder.append(curTag);
          }
        }
        String tagCombination=stringBuilder.toString();
        saveTags(tagCombination,tags.size(),q.getView_count(),q.getUp_vote_count());
      }
    }
  }
}
