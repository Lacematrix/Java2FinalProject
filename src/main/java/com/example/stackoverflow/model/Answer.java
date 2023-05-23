package com.example.stackoverflow.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Answer {

  @Id
  @GeneratedValue
  private Long id;

  private long upVoteCount;
  private boolean isAccepted;
  private int score;
  private long lastActivityDate;
  private long lastEditDate;
  private long creationDate;
  private int answerId;
  private int questionId;
  private String contentLicense;

  public Answer() {
  }

  public Answer(long upVoteCount, boolean isAccepted, int score, long lastActivityDate,
      long lastEditDate, long creationDate, int answerId, int questionId, String contentLicense) {
    this.upVoteCount = upVoteCount;
    this.isAccepted = isAccepted;
    this.score = score;
    this.lastActivityDate = lastActivityDate;
    this.lastEditDate = lastEditDate;
    this.creationDate = creationDate;
    this.answerId = answerId;
    this.questionId = questionId;
    this.contentLicense = contentLicense;
  }

  public long getUpVoteCount() {
    return upVoteCount;
  }

  public void setUpVoteCount(long upVoteCount) {
    this.upVoteCount = upVoteCount;
  }

  public boolean isAccepted() {
    return isAccepted;
  }

  public void setAccepted(boolean accepted) {
    isAccepted = accepted;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public long getLastActivityDate() {
    return lastActivityDate;
  }

  public void setLastActivityDate(long lastActivityDate) {
    this.lastActivityDate = lastActivityDate;
  }

  public long getLastEditDate() {
    return lastEditDate;
  }

  public void setLastEditDate(long lastEditDate) {
    this.lastEditDate = lastEditDate;
  }

  public long getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(long creationDate) {
    this.creationDate = creationDate;
  }

  public int getAnswerId() {
    return answerId;
  }

  public void setAnswerId(int answerId) {
    this.answerId = answerId;
  }

  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  public String getContentLicense() {
    return contentLicense;
  }

  public void setContentLicense(String contentLicense) {
    this.contentLicense = contentLicense;
  }

}
