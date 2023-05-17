package com.example.stackoverflow;

import com.example.stackoverflow.service.AnswerService;
import com.example.stackoverflow.service.QuestionService;
import com.example.stackoverflow.service.StudentService;
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
	public CommandLineRunner commandLineRunner(QuestionService questionService, AnswerService answerService){
		return args -> {
			try {
				questionService.addQuestion(5);
				answerService.addAnswer(5);
				answerService.setQuestionNum(questionService.getNumberOfQuestion());
			}catch (Exception e){
				System.out.println(e);
			}

		};
	}
}
