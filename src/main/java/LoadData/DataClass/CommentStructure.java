package LoadData.DataClass;

public class CommentStructure {
  private UserStructure owner;
  private Long comment_id;

  public UserStructure getOwner() {
    return owner;
  }

  public Long getComment_id() {
    return comment_id;
  }

  public void setOwner(UserStructure owner) {
    this.owner = owner;
  }

  public void setComment_id(Long comment_id) {
    this.comment_id = comment_id;
  }
}
