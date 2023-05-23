package com.example.stackoverflow.model;

import javax.persistence.*;

@Entity
@Table
public class Tag {

  @Id
  @GeneratedValue
  private Long id;
  private String combination;
  private Integer size;
  private Integer num;
  private Integer upvote;
  private Integer view;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getCombination() {
    return combination;
  }

  public Integer getSize() {
    return size;
  }

  public Integer getNum() {
    return num;
  }

  public void setCombination(String tags) {
    this.combination = tags;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public Integer getUpvote() {
    return upvote;
  }

  public Integer getView() {
    return view;
  }

  public void setUpvote(Integer upvote) {
    this.upvote = upvote;
  }

  public void setView(Integer view) {
    this.view = view;
  }
}
