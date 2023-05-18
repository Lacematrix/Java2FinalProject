package LoadData.DataClass;

public class AnswerLoad {
    private Owner owner;

    private long up_vote_count;
    private boolean is_accepted;
    private int score;
    private long last_activity_date;
    private long last_edit_date;
    private long creation_date;
    private int answer_id;
    private int question_id;
    private String content_license;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public long getUp_vote_count() {
        return up_vote_count;
    }

    public void setUp_vote_count(long up_vote_count) {
        this.up_vote_count = up_vote_count;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public long getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(long last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public long getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(long creation_date) {
        this.creation_date = creation_date;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getContent_license() {
        return content_license;
    }

    public void setContent_license(String content_license) {
        this.content_license = content_license;
    }

    @Override
    public String toString() {
        return "AnswerLoad{" +
                "owner=" + owner +
                ", is_accepted=" + is_accepted +
                ", score=" + score +
                ", last_activity_date=" + last_activity_date +
                ", last_edit_date=" + last_edit_date +
                ", creation_date=" + creation_date +
                ", answer_id=" + answer_id +
                ", question_id=" + question_id +
                ", content_license='" + content_license + '\'' +
                '}';
    }
}
