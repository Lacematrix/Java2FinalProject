package LoadData.DataClass;

import java.util.List;

public class TagLoad {

  private List<String> tags;
  private int view_count;
  private int up_vote_count;
  private long last_activity_date;
  private long question_id;

  public List<String> getTags() {
    return tags;
  }

  public int getView_count() {
    return view_count;
  }

  public int getUp_vote_count() {
    return up_vote_count;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public void setView_count(int view_count) {
    this.view_count = view_count;
  }

  public void setUp_vote_count(int up_vote_count) {
    this.up_vote_count = up_vote_count;
  }
}
