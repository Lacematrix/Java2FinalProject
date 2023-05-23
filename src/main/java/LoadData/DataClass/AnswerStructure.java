package LoadData.DataClass;

import java.util.List;

public class AnswerStructure {

  private List<CommentStructure> comments;
  private UserStructure owner;
  private Long answer_id;

  public List<CommentStructure> getComments() {
    return comments;
  }

  public UserStructure getOwner() {
    return owner;
  }

  public Long getAnswer_id() {
    return answer_id;
  }

  public void setComments(List<CommentStructure> comments) {
    this.comments = comments;
  }

  public void setOwner(UserStructure owner) {
    this.owner = owner;
  }

  public void setAnswer_id(Long answer_id) {
    this.answer_id = answer_id;
  }
}
