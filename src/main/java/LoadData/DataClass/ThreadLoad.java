package LoadData.DataClass;

import java.util.List;

public class ThreadLoad {

  private UserStructure owner;
  private List<String> tags;
  private List<AnswerStructure> answers;
  private List<CommentStructure> comments;
  private Long last_activity_date;
  private Long question_id;

  public List<String> getTags() {
    return tags;
  }

  public List<AnswerStructure> getAnswers() {
    return answers;
  }

  public List<CommentStructure> getComments() {
    return comments;
  }

  public Long getLast_activity_date() {
    return last_activity_date;
  }

  public Long getQuestion_id() {
    return question_id;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public void setAnswers(List<AnswerStructure> answers) {
    this.answers = answers;
  }

  public void setComments(List<CommentStructure> comments) {
    this.comments = comments;
  }

  public void setLast_activity_date(Long last_activity_date) {
    this.last_activity_date = last_activity_date;
  }

  public void setQuestion_id(Long question_id) {
    this.question_id = question_id;
  }

  public UserStructure getOwner() {
    return owner;
  }

  public void setOwner(UserStructure owner) {
    this.owner = owner;
  }
}
