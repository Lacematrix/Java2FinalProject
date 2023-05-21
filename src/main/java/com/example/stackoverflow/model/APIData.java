package com.example.stackoverflow.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class APIData {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private int cnt;
  private String type;
  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getCnt() {
    return cnt;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
