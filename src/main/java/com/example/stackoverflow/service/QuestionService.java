package com.example.stackoverflow.service;

import LoadData.DataClass.QuestionLoad;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.stackoverflow.model.Question;
import com.example.stackoverflow.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public long[] getUnacceptedQuestionCount() {
        return new long[] {questionRepository.countByIsAnswered(false), questionRepository.countByIsAnswered(true)};
    }

    public double[] getAvgAndMax(){
        return new double[] {questionRepository.findAvgValue(),questionRepository.findMaxValue()};
    }

    public List<Object[]> getDistribution(){
        return questionRepository.findDistribution();
    }

    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    public long getNumberOfQuestion(){
        return questionRepository.count();
    }

    public void addQuestion(int n) throws IOException {
        for (int i = 1; i <= n; i++) {
            String jsonStrings = Files.readString(Path.of("src/main/java/LoadData/Data/Question/Question" + i + ".json"));
            JSONObject jsonObject = JSON.parseObject(jsonStrings);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            List<QuestionLoad> questions = itemsArray.toJavaList(QuestionLoad.class);
            for (QuestionLoad q : questions) {
                Question question = new Question(q.isIs_answered(), q.getView_count(), q.getAccepted_answer_id(),
                        q.getAnswer_count(), q.getScore(), q.getLast_activity_date(), q.getCreation_date(), q.getLast_edit_date(), q.getQuestion_id(),
                        q.getContent_license(), q.getLink(), q.getTitle());
                questionRepository.save(question);
            }
        }
    }
}
