package com.example.stackoverflow.service;

import LoadData.DataClass.ThreadLoad;
import LoadData.DataClass.UserStructure;
import LoadData.DataClass.AnswerStructure;
import LoadData.DataClass.CommentStructure;
import com.example.stackoverflow.model.Thread;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.stackoverflow.model.Account;
import com.example.stackoverflow.repository.ThreadRepository;
import com.example.stackoverflow.repository.AccountRepository;
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
  private AccountRepository accountRepository;

  @Autowired
  public UserService(ThreadRepository threadRepository, AccountRepository accountRepository) {
    this.threadRepository = threadRepository;
    this.accountRepository = accountRepository;
  }

  public void saveUser(UserStructure userStructure) {
    Account account = accountRepository.getAccountByUserId(userStructure.getUser_id());
    if (account != null) {
      account.setJoinCnt(account.getJoinCnt() + 1);
    } else {
      Account newAccount = new Account();
      newAccount.setUserName(userStructure.getDisplay_name());
      newAccount.setJoinCnt(1);
      newAccount.setUserId(userStructure.getUser_id());
      accountRepository.save(newAccount);
    }
  }

  public double getAvgAnsPercent() {
    return threadRepository.findAvgAnsPercent();
  }

  public double getAvgCommentPercent() {
    return threadRepository.findAvgCommentPercent();
  }

  public List<Account> getActiveUser() {
    return accountRepository.findActiveUser();
  }

  public void addUserAndThread(int n) throws IOException {
    for (int i = 1; i <= n; i++) {
      String jsonStrings = Files.readString(Path.of("src/main/java/LoadData/Data/Thread/Thread" + i + ".json"));
      JSONObject jsonObject = JSON.parseObject(jsonStrings);
      JSONArray itemsArray = jsonObject.getJSONArray("items");
      List<ThreadLoad> threadData = itemsArray.toJavaList(ThreadLoad.class);
      for (ThreadLoad q : threadData) {
        List<AnswerStructure> answers = q.getAnswers();
        List<CommentStructure> comments = q.getComments();
        UserStructure questionOwner = q.getOwner();
        saveUser(questionOwner);
        HashSet<Long> answerSet = new HashSet<>();
        HashSet<Long> commentSet = new HashSet<>();
        if (answers != null) {
          for (AnswerStructure x : answers) {
            saveUser(x.getOwner());
            answerSet.add(x.getOwner().getUser_id());
            if (x.getComments() != null) {
              for (CommentStructure c : x.getComments()) {
                saveUser(c.getOwner());
                commentSet.add(c.getOwner().getUser_id());
              }
            }
          }
        }
        if (comments != null) {
          for (CommentStructure x : comments) {
            saveUser(x.getOwner());
            commentSet.add(x.getOwner().getUser_id());
          }
        }
        Thread thread = new Thread();
        thread.setAnsUserCnt(answerSet.size());
        thread.setAnsUserPercent(answerSet.size() / (1 + answerSet.size() + commentSet.size()));
        thread.setCommentUserCnt(commentSet.size());
        thread.setCommentUserPercent(commentSet.size() / (1 + answerSet.size() + commentSet.size()));
        threadRepository.save(thread);
      }
    }
  }
}
