package LoadData.DataClass;

import java.util.List;

public class QuestionLoad {

  private List<String> tags;
  private Owner owner;
  private boolean is_answered;
  private int view_count;
  private int accepted_answer_id;
  private int answer_count;
  private int score;
  private long last_activity_date;
  private long creation_date;
  private long last_edit_date;
  private long question_id;
  private String content_license;
  private String link;
  private String title;

  public List<String> getTags() {
    return tags;
  }

  public Owner getOwner() {
    return owner;
  }

  public boolean isIs_answered() {
    return is_answered;
  }

  public int getView_count() {
    return view_count;
  }

  public int getAccepted_answer_id() {
    return accepted_answer_id;
  }

  public int getAnswer_count() {
    return answer_count;
  }

  public int getScore() {
    return score;
  }

  public long getLast_activity_date() {
    return last_activity_date;
  }

  public long getCreation_date() {
    return creation_date;
  }

  public long getLast_edit_date() {
    return last_edit_date;
  }

  public long getQuestion_id() {
    return question_id;
  }

  public String getContent_license() {
    return content_license;
  }

  public String getLink() {
    return link;
  }

  public String getTitle() {
    return title;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public void setIs_answered(boolean is_answered) {
    this.is_answered = is_answered;
  }

  public void setView_count(int view_count) {
    this.view_count = view_count;
  }

  public void setAccepted_answer_id(int accepted_answer_id) {
    this.accepted_answer_id = accepted_answer_id;
  }

  public void setAnswer_count(int answer_count) {
    this.answer_count = answer_count;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setLast_activity_date(long last_activity_date) {
    this.last_activity_date = last_activity_date;
  }

  public void setCreation_date(long creation_date) {
    this.creation_date = creation_date;
  }

  public void setLast_edit_date(long last_edit_date) {
    this.last_edit_date = last_edit_date;
  }

  public void setQuestion_id(long question_id) {
    this.question_id = question_id;
  }

  public void setContent_license(String content_license) {
    this.content_license = content_license;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
