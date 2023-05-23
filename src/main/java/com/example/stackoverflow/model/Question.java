package com.example.stackoverflow.model;

import javax.persistence.*;

@Entity
@Table
public class Question {

  @Id
  @GeneratedValue
  private Long ID;
  private boolean isAnswered;
  private int viewCount;
  private int acceptedAnswerId;
  private int answerCount;
  private int score;
  private long lastActivityDate;
  private long creationDate;
  private long lastEditDate;
  private long questionId;
  private String contentLicense;
  private String link;
  private String title;

  public Question(boolean is_answered, int view_count, int accepted_answer_id, int answer_count,
      int score, long last_activity_date, long creation_date, long last_edit_date, long question_id,
      String content_license, String link, String title) {
    this.isAnswered = is_answered;
    this.viewCount = view_count;
    this.acceptedAnswerId = accepted_answer_id;
    this.answerCount = answer_count;
    this.score = score;
    this.lastActivityDate = last_activity_date;
    this.creationDate = creation_date;
    this.lastEditDate = last_edit_date;
    this.questionId = question_id;
    this.contentLicense = content_license;
    this.link = link;
    this.title = title;
  }

  public Question() {

  }

  public boolean isAnswered() {
    return isAnswered;
  }

  public int getViewCount() {
    return viewCount;
  }

  public int getAcceptedAnswerId() {
    return acceptedAnswerId;
  }

  public int getAnswerCount() {
    return answerCount;
  }

  public int getScore() {
    return score;
  }

  public long getLastActivityDate() {
    return lastActivityDate;
  }

  public long getCreationDate() {
    return creationDate;
  }

  public long getLastEditDate() {
    return lastEditDate;
  }

  public long getQuestionId() {
    return questionId;
  }

  public String getContentLicense() {
    return contentLicense;
  }

  public String getLink() {
    return link;
  }

  public String getTitle() {
    return title;
  }

  public void setID(Long ID) {
    this.ID = ID;
  }

  public void setAnswered(boolean answered) {
    isAnswered = answered;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public void setAcceptedAnswerId(int acceptedAnswerId) {
    this.acceptedAnswerId = acceptedAnswerId;
  }

  public void setAnswerCount(int answerCount) {
    this.answerCount = answerCount;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setLastActivityDate(long lastActivityDate) {
    this.lastActivityDate = lastActivityDate;
  }

  public void setCreationDate(long creationDate) {
    this.creationDate = creationDate;
  }

  public void setLastEditDate(long lastEditDate) {
    this.lastEditDate = lastEditDate;
  }

  public void setQuestionId(long questionId) {
    this.questionId = questionId;
  }

  public void setContentLicense(String contentLicense) {
    this.contentLicense = contentLicense;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "Question{" +
        "ID=" + ID +
        ", is_answered=" + isAnswered +
        ", view_count=" + viewCount +
        ", accepted_answer_id=" + acceptedAnswerId +
        ", answer_count=" + answerCount +
        ", score=" + score +
        ", last_activity_date=" + lastActivityDate +
        ", creation_date=" + creationDate +
        ", last_edit_date=" + lastEditDate +
        ", question_id=" + questionId +
        ", content_license='" + contentLicense + '\'' +
        ", link='" + link + '\'' +
        ", title='" + title + '\'' +
        '}';
  }
}
