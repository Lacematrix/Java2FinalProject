package com.example.stackoverflow.controller;

import com.example.stackoverflow.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Question")
public class QuestionRestController {

  private final QuestionService questionService;

  public QuestionRestController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @GetMapping("/NoAnswer")
  public ResponseEntity<Object> PercentageOfHasQuestions() {
    Map<String, Double> percentage = new HashMap<>();
    long[] percentageAccepted = questionService.getUnacceptedQuestionCount();
    double no = 100 * (double) percentageAccepted[0] / (double) (percentageAccepted[0]
        + percentageAccepted[1]);
    percentage.put("noAnswer", no);
    percentage.put("hasAnswer", 100 - no);
    return ResponseEntity.ok(percentage);
  }

  @GetMapping("/AvgAndMax")
  public ResponseEntity<Object> getAvgAndMax() {
    Map<String, Double> AvgAndMax = new HashMap<>();
    double[] result = questionService.getAvgAndMax();
    AvgAndMax.put("averageAnswer", result[0]);
    AvgAndMax.put("maxAnswer", result[1]);
    return ResponseEntity.ok(AvgAndMax);
  }

  @GetMapping("/Distribution")
  public ResponseEntity<Object> getDistribution() {
    Map<Integer, Long> distribution = new HashMap<>();
    List<Object[]> result = questionService.getDistribution();
    result.forEach(objects -> distribution.put((Integer) objects[0], (Long) objects[1]));
    return ResponseEntity.ok(distribution);
  }

  @GetMapping
  public ResponseEntity<Object> getQuestion() {
    return ResponseEntity.ok(questionService.getAllQuestion());
  }

}
