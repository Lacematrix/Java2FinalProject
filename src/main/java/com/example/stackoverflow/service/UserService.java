package com.example.stackoverflow.service;

import LoadData.DataClass.ThreadLoad;
import LoadData.DataClass.UserStructure;
import LoadData.DataClass.AnswerStructure;
import LoadData.DataClass.CommentStructure;
import com.example.stackoverflow.model.Thread;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.stackoverflow.model.User;
import com.example.stackoverflow.repository.ThreadRepository;
import com.example.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
  private ThreadRepository threadRepository;
  private UserRepository userRepository;
  @Autowired
  public UserService(ThreadRepository threadRepository, UserRepository userRepository) {
    this.threadRepository = threadRepository;
    this.userRepository = userRepository;
  }

  public void saveUser(UserStructure userStructure) {
    User user = userRepository.findUserById(userStructure.getUser_id());
    if (user != null) {
      user.setJoinCnt(user.getJoinCnt() + 1);
    } else {
      User newUser = new User();
      newUser.setUserName(userStructure.getDisplay_name());
      newUser.setJoinCnt(1);
      newUser.setUserId(userStructure.getUser_id());
      userRepository.save(newUser);
    }
  }

  public double getAvgAnsPercent(){ // TODO: 2023/5/21 method return average answer percentage
    return threadRepository.findAvgAnsPercent();
  }
  public double getAvgCommentPercent(){// TODO: 2023/5/21 method return average comment percentage
    return threadRepository.findAvgCommentPercent();
  }
  public List<User> getActiveUser(){// TODO: 2023/5/21 method return 5 most active users(objects)
    return userRepository.findActiveUser();
  }
  public void addUserAndThread(int n) throws IOException {
    for (int i = 1; i <= n; i++) {
      String jsonStrings = Files.readString(Path.of("src/main/java/LoadData/Data/Thread/Thread" + i + ".json"));
      JSONObject jsonObject = JSON.parseObject(jsonStrings);
      JSONArray itemsArray = jsonObject.getJSONArray("items");
      List<ThreadLoad> threadData = itemsArray.toJavaList(ThreadLoad.class);
      for (ThreadLoad q : threadData) {
        List<AnswerStructure> answers=q.getAnswers();
        List<CommentStructure> comments=q.getComments();
        UserStructure questionOwner=q.getOwner();
        saveUser(questionOwner);
        HashSet<Long> answerSet=new HashSet<>();
        HashSet<Long> commentSet=new HashSet<>();
        for (AnswerStructure x:answers){
          saveUser(x.getOwner());
          answerSet.add(x.getOwner().getUser_id());
          for (CommentStructure c:x.getComments()){
            saveUser(c.getOwner());
            commentSet.add(c.getOwner().getUser_id());
          }
        }
        for (CommentStructure x:q.getComments()){
          saveUser(x.getOwner());
          commentSet.add(x.getOwner().getUser_id());
        }
        Thread thread=new Thread();
        thread.setAnsUserCnt(answerSet.size());
        thread.setAnsUserPercent(answerSet.size()/(1+ answerSet.size()+ comments.size()));
        thread.setCommentUserCnt(commentSet.size());
        thread.setCommentUserPercent(comments.size()/(1+ answerSet.size()+ comments.size()));
        threadRepository.save(thread);
      }
    }
  }
}
