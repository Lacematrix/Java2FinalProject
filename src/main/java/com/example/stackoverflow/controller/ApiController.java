package com.example.stackoverflow.controller;

import com.example.stackoverflow.model.APIData;
import com.example.stackoverflow.service.APIDataService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/javaAPI")
public class ApiController {

  private final APIDataService apiDataService;

  public ApiController(APIDataService apiDataService) {
    this.apiDataService = apiDataService;
  }

  @GetMapping("/MostDiscussedApi")
  public ResponseEntity<Object> getTop5API() {
    Map<Pair<String, String>, Integer> mostUseApi = new HashMap<>();
    List<APIData> temp = apiDataService.getTop5API();
    for (APIData x : temp) {
      mostUseApi.put(new Pair<String, String>(x.getName(), x.getType()), x.getCnt());
    }
    return ResponseEntity.ok(mostUseApi);
  }
}
