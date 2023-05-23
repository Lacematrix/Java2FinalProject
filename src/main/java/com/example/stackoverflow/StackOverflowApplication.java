package com.example.stackoverflow;

import com.example.stackoverflow.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StackOverflowApplication {

  public static void main(String[] args) {
    SpringApplication.run(StackOverflowApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(QuestionService questionService,
      AnswerService answerService, TagService tagService, UserService userService,
      APIDataService apiDataService) {
    return args -> {
      try {
        int n = 5;
        tagService.addTag(n);
        userService.addUserAndThread(n);
        apiDataService.addAPIData(n);
        questionService.addQuestion(n);
        answerService.addAnswer(n);
        answerService.setQuestionNum(questionService.getNumberOfQuestion());

      } catch (Exception e) {
        System.out.println(e);
      }

    };
  }
}
