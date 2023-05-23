package LoadData.DataClass;

public class Owner {

  private int account_id;
  private int reputation;
  private int user_id;
  private String user_type;
  private String profile_image;
  private String display_name;
  private String link;

  public int getAccount_id() {
    return account_id;
  }

  public int getReputation() {
    return reputation;
  }

  public int getUser_id() {
    return user_id;
  }

  public String getUser_type() {
    return user_type;
  }

  public String getProfile_image() {
    return profile_image;
  }

  public String getDisplay_name() {
    return display_name;
  }

  public String getLink() {
    return link;
  }

  public void setAccount_id(int account_id) {
    this.account_id = account_id;
  }

  public void setReputation(int reputation) {
    this.reputation = reputation;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public void setUser_type(String user_type) {
    this.user_type = user_type;
  }

  public void setProfile_image(String profile_image) {
    this.profile_image = profile_image;
  }

  public void setDisplay_name(String display_name) {
    this.display_name = display_name;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
