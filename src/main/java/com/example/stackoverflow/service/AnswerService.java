package com.example.stackoverflow.service;

import LoadData.DataClass.AnswerLoad;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.stackoverflow.model.Answer;
import com.example.stackoverflow.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class AnswerService {

  private long questionNum;
  private final AnswerRepository answerRepository;

  @Autowired
  public AnswerService(AnswerRepository answerRepository) {
    this.answerRepository = answerRepository;
  }

  public long findAccept() {
    return answerRepository.countByIsAccepted(true);
  }

  public long getQuestionNum() {
    return questionNum;
  }

  public void setQuestionNum(long questionNum) {
    this.questionNum = questionNum;
  }

  public List<Object[]> getResolvedTime() {
    return answerRepository.findResolvedTime();
  }

  public List<Object[]> getMoreVotes() {
    return answerRepository.findMoreVotes();
  }

  public List<Answer> getAllAnswer() {
    return answerRepository.findAll();
  }


  public void addAnswer(int n) throws IOException {
    for (int i = 1; i <= 5; i++) {
      String jsonStrings = Files.readString(
          Path.of("src/main/java/LoadData/Data/Answer/Answer" + i + ".json"));
      JSONObject jsonObject = JSON.parseObject(jsonStrings);
      JSONArray itemsArray = jsonObject.getJSONArray("items");
      List<AnswerLoad> answers = itemsArray.toJavaList(AnswerLoad.class);
      for (AnswerLoad a : answers) {
        Answer answer = new Answer(a.getUp_vote_count(), a.isIs_accepted(), a.getScore(),
            a.getLast_activity_date(), a.getLast_edit_date(),
            a.getCreation_date(), a.getAnswer_id(), a.getQuestion_id(),
            a.getContent_license());
        answerRepository.save(answer);
      }
    }
  }
}