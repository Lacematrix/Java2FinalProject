package com.example.stackoverflow.model;
import javax.persistence.*;

@Entity
@Table
public class Thread {
  @Id
  @GeneratedValue
  private Long id;
  private int ans_Cnt;
  private double ans_Percent;
  private int comment_Cnt;
  private double comment_Percent;

  public Long getId() {
    return id;
  }

  public int getAns_Cnt() {
    return ans_Cnt;
  }

  public double getAns_Percent() {
    return ans_Percent;
  }

  public int getComment_Cnt() {
    return comment_Cnt;
  }

  public double getComment_Percent() {
    return comment_Percent;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setAns_Cnt(int ansUserCnt) {
    this.ans_Cnt = ansUserCnt;
  }

  public void setAns_Percent(double ansUserPercent) {
    this.ans_Percent = ansUserPercent;
  }

  public void setComment_Cnt(int commentUserCnt) {
    this.comment_Cnt = commentUserCnt;
  }

  public void setComment_Percent(double commentUserPercent) {
    this.comment_Percent = commentUserPercent;
  }
}
