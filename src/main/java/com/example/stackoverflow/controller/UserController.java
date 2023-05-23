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

  @GetMapping("/Distribution")
  public ResponseEntity<Object> getAvgDistribution(){
    // TODO: 2023/5/21 method return average answer,question and comment percentage.  Notice the question percentage maybe too small, you can consider display this data or not.
    Map<String, Double> userDistribution = new HashMap<>();
    double answerPercent=userService.getAvgAnsPercent();
    double commentPercent= userService.getAvgCommentPercent();
      userDistribution.put("Answer",answerPercent);
      userDistribution.put("Comment",commentPercent);
      userDistribution.put("Question",1-answerPercent-commentPercent);
    return ResponseEntity.ok(userDistribution);
  }

  @GetMapping("/ActiveUser")
  public ResponseEntity<Object> getActiveUser(){// TODO: 2023/5/21 method return 5 most active users, the map value means the number of join thread discussion times.
    Map<String, Integer> activeUsers = new HashMap<>();
    List<Account> temp=userService.getActiveUser();
    for (Account x:temp){
      activeUsers.put(x.getUser_Name(),x.getJoincnt());
    }
    return ResponseEntity.ok(activeUsers);
  }
}
