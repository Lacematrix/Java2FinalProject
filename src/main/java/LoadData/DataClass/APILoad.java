package LoadData.DataClass;

import java.util.List;

public class APILoad {

  private List<AnsData> answers;
  private List<CommentData> comments;
  private Long last_activity_date;
  private Long question_id;
  private String body;

  public List<AnsData> getAnswers() {
    return answers;
  }

  public List<CommentData> getComments() {
    return comments;
  }

  public Long getLast_activity_date() {
    return last_activity_date;
  }

  public Long getQuestion_id() {
    return question_id;
  }

  public String getBody() {
    return body;
  }

  public void setAnswers(List<AnsData> answers) {
    this.answers = answers;
  }

  public void setComments(List<CommentData> comments) {
    this.comments = comments;
  }

  public void setLast_activity_date(Long last_activity_date) {
    this.last_activity_date = last_activity_date;
  }

  public void setQuestion_id(Long question_id) {
    this.question_id = question_id;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
