package com.example.stackoverflow.model;

import javax.persistence.*;

@Entity
@Table
public class Account {
  @Id
  @GeneratedValue
  private Long id;
  private Long userId;
  private String userName;
  private int joinCnt;

  public Long getId() {
    return id;
  }

  public Long getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public int getJoinCnt() {
    return joinCnt;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setJoinCnt(int ansCount) {
    this.joinCnt = ansCount;
  }
}
