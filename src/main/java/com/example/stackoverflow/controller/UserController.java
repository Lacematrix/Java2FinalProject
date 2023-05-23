package com.example.stackoverflow.controller;

import com.example.stackoverflow.model.Account;
import com.example.stackoverflow.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/User")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/AnsDistribution")
  public ResponseEntity<Object> getAnsDistribution() {
    // TODO: 2023/5/21 method return average answer,question and comment percentage.  Notice the question percentage maybe too small, you can consider display this data or not.
    Map<Integer, Integer> ansDistribution = new HashMap<>();
    List<Integer> answerPercent = userService.getAnsCnt();
    if (answerPercent != null) {
      for (Integer x : answerPercent) {
        if (ansDistribution.containsKey(x)) {
          ansDistribution.put(x, ansDistribution.get(x) + 1);
        } else {
          ansDistribution.put(x, 1);
        }
      }
    }
    return ResponseEntity.ok(ansDistribution);
  }

  @GetMapping("/commentDistribution")
  public ResponseEntity<Object> getCommentDistribution() {
    // TODO: 2023/5/21 method return average answer,question and comment percentage.  Notice the question percentage maybe too small, you can consider display this data or not.
    Map<Integer, Integer> commentDistribution = new HashMap<>();
    List<Integer> commentPercent = userService.getCommentCnt();
    if (commentPercent != null) {
      for (Integer x : commentPercent) {
        if (commentDistribution.containsKey(x)) {
          commentDistribution.put(x, commentDistribution.get(x) + 1);
        } else {
          commentDistribution.put(x, 1);
        }
      }
    }
    return ResponseEntity.ok(commentDistribution);
  }

  @GetMapping("/avgDistribution")
  public ResponseEntity<Object> getAvgDistribution() {
    // TODO: 2023/5/21 method return average answer,question and comment percentage.  Notice the question percentage maybe too small, you can consider display this data or not.
    Map<String, Double> avgDistribution = new HashMap<>();
    Double ansAvg = userService.getAvgAns();
    Double commentAvg = userService.getAvgComment();
    avgDistribution.put("Answer", ansAvg);
    avgDistribution.put("Comment", commentAvg);
    avgDistribution.put("Question", 1D);
    return ResponseEntity.ok(avgDistribution);
  }

  @GetMapping("/threadDistribution")
  public ResponseEntity<Object> getThreadDistribution() {
    // TODO: 2023/5/21 method return average answer,question and comment percentage.  Notice the question percentage maybe too small, you can consider display this data or not.
    Map<Integer, Integer> threadDistribution = new HashMap<>();
    List<Integer> threadPercent = userService.getThreadCnt();
    if (threadPercent != null) {
      for (Integer x : threadPercent) {
        if (threadDistribution.containsKey(x)) {
          threadDistribution.put(x, threadDistribution.get(x) + 1);
        } else {
          threadDistribution.put(x, 1);
        }
      }
    }
    return ResponseEntity.ok(threadDistribution);
  }

  @GetMapping("/ActiveUser")
  public ResponseEntity<Object> getActiveUser() {// TODO: 2023/5/21 method return 5 most active users, the map value means the number of join thread discussion times.
    Map<String, Integer> activeUsers = new HashMap<>();
    List<Account> temp = userService.getActiveUser();
    for (Account x : temp) {
      activeUsers.put(x.getUser_Name(), x.getJoincnt());
    }
    return ResponseEntity.ok(activeUsers);
  }
}
