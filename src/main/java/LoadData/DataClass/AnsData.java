package LoadData.DataClass;

import java.util.List;

public class AnsData {

  private List<CommentData> comments;
  private String body;
  private Long answer_id;

  public List<CommentData> getComments() {
    return comments;
  }

  public Long getAnswer_id() {
    return answer_id;
  }

  public void setComments(List<CommentData> comments) {
    this.comments = comments;
  }

  public void setAnswer_id(Long answer_id) {
    this.answer_id = answer_id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
