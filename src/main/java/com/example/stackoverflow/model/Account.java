package com.example.stackoverflow.model;

import javax.persistence.*;

@Entity
@Table
public class Account {

  @Id
  @GeneratedValue
  private Long id;
  private Long userid;
  private String user_Name;
  private int joincnt;

  public Long getId() {
    return id;
  }

  public Long getUserid() {
    return userid;
  }

  public String getUser_Name() {
    return user_Name;
  }

  public int getJoincnt() {
    return joincnt;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUserid(Long userId) {
    this.userid = userId;
  }

  public void setUser_Name(String userName) {
    this.user_Name = userName;
  }

  public void setJoincnt(int ansCount) {
    this.joincnt = ansCount;
  }
}
