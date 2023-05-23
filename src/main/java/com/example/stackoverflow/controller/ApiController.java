package com.example.stackoverflow.controller;
import com.example.stackoverflow.model.APIData;
import com.example.stackoverflow.service.APIDataService;
import kotlin.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/javaAPI")
public class ApiController {
  private final APIDataService apiDataService;

  public ApiController(APIDataService apiDataService) {
    this.apiDataService = apiDataService;
  }
  @GetMapping("/MostDiscussedApi")
  public ResponseEntity<Object> getTop5API(){
    // TODO: 2023/5/21 front end should display top 5 api. this method return Top5 APIData objects,whose apiName and type shuold be displayed.
    Map<Pair<String,String>, Integer> mostUseApi= new HashMap<>();// key:<API's name, Api's type(class or method)> value:discussed times
    List<APIData> temp=apiDataService.getTop5API();
    for (APIData x:temp){
      mostUseApi.put(new Pair<String,String>(x.getName(),x.getType()),x.getCnt());
    }
    return ResponseEntity.ok(mostUseApi);
  }
}
