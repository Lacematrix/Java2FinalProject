package com.example.stackoverflow.controller;

import com.example.stackoverflow.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Answer")
public class AnswerRestController {

    private final AnswerService answerService;

    public AnswerRestController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/PercentageOfAccept")
    public ResponseEntity<Object> getPercentageOfAccept(){
        long accept = answerService.findAccept();
        long num = answerService.getQuestionNum();
        Map<String, Double> percentage = new HashMap<>();
        double result =100 * (double) accept / (double) num;
        percentage.put("PercentageOfAccept", result);
        percentage.put("noAccept", 100 - result);
        return ResponseEntity.ok(percentage);
    }

    @GetMapping("/ResolutionTime")
    public ResponseEntity<Object> questionResolutionTime(){
        List<Object[]> result =  answerService.getResolvedTime();
        Map<String, Integer> resolveTime = new HashMap<>();
        result.forEach(objects -> {
            String string = (double) ((Long) objects[0] / 60) + "/min";
            if (!resolveTime.containsKey(string)) {
                resolveTime.put(string, 1);
            }else {
                resolveTime.put(string, resolveTime.get(string) + 1);
            }
        });
        return ResponseEntity.ok(resolveTime);
    }

    @GetMapping("/MoreUpvote")
    public ResponseEntity<Object> getMoreUpvote(){
        return null;
    }

    @GetMapping
    public ResponseEntity<Object> getAllAnswer(){
        return ResponseEntity.ok(answerService.getAllAnswer());
    }
}
