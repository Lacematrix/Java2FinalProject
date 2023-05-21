package com.example.stackoverflow.model;
import javax.persistence.*;

@Entity
@Table
public class Thread {
  @Id
  @GeneratedValue
  private Long id;
  private int ansUserCnt;
  private double ansUserPercent;
  private int commentUserCnt;
  private double commentUserPercent;

  public Long getId() {
    return id;
  }

  public int getAnsUserCnt() {
    return ansUserCnt;
  }

  public double getAnsUserPercent() {
    return ansUserPercent;
  }

  public int getCommentUserCnt() {
    return commentUserCnt;
  }

  public double getCommentUserPercent() {
    return commentUserPercent;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setAnsUserCnt(int ansUserCnt) {
    this.ansUserCnt = ansUserCnt;
  }

  public void setAnsUserPercent(double ansUserPercent) {
    this.ansUserPercent = ansUserPercent;
  }

  public void setCommentUserCnt(int commentUserCnt) {
    this.commentUserCnt = commentUserCnt;
  }

  public void setCommentUserPercent(double commentUserPercent) {
    this.commentUserPercent = commentUserPercent;
  }
}
