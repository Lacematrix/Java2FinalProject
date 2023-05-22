package com.example.stackoverflow.service;

import LoadData.DataClass.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.stackoverflow.repository.APIDataRepository;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.stackoverflow.model.APIData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class APIDataService {
  private final APIDataRepository apiDataRepository;

  @Autowired
  public APIDataService(APIDataRepository apiDataRepository) {
    this.apiDataRepository = apiDataRepository;
  }

  public List<APIData> getTop5API() {
    return apiDataRepository.findMax5API();
  }

  public void saveAPI(String apiName, int cnt, String type) {
    APIData apiData = apiDataRepository.getAPIDataByName(apiName);
    if (apiData != null) {
      apiData.setCnt(apiData.getCnt() + cnt);
    } else {
      APIData newApi = new APIData();
      newApi.setCnt(cnt);
      newApi.setName(apiName);
      newApi.setType(type);
      apiDataRepository.save(newApi);
    }
  }

  public void regexManage(String input) {
    String patternString = "(?s)<pre><code>(.*?)</code></pre>";
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(input);
    JavaParser jp = new JavaParser();
    while (matcher.find()) {
      String content = matcher.group(1);
      ParseResult<CompilationUnit> parseResult = jp.parse(content);
      if (parseResult.isSuccessful()) {
        Optional<CompilationUnit> optionalCompilationUnit = parseResult.getResult();
        if (optionalCompilationUnit.isPresent()) {
          CompilationUnit compilationUnit = optionalCompilationUnit.get();
          CodeVisitor visitor = new CodeVisitor();
          visitor.visit(compilationUnit, null);

          Map<String, Integer> classCount = visitor.getClassCount();
          Map<String, Integer> methodCount = visitor.getMethodCount();

          for (Map.Entry<String, Integer> classEntry : classCount.entrySet()) {
            saveAPI(classEntry.getKey(), classEntry.getValue(), "class");
          }
          for (Map.Entry<String, Integer> methodEntry : methodCount.entrySet()) {
            saveAPI(methodEntry.getKey(), methodEntry.getValue(), "method");
          }
        }
      }
    }
  }


  public void addAPIData(int n) throws IOException {
    for (int i = 1; i <= n; i++) {
      String jsonStrings = Files.readString(Path.of("src/main/java/LoadData/Data/APIData/APIData" + i + ".json"));
      JSONObject jsonObject = JSON.parseObject(jsonStrings);
      JSONArray itemsArray = jsonObject.getJSONArray("items");
      List<APILoad> apiLoads = itemsArray.toJavaList(APILoad.class);
      for (APILoad q : apiLoads) {
        List<CommentData> questionComments = q.getComments();
        List<AnsData> ansDataList = q.getAnswers();
        String questionBody = q.getBody();
        regexManage(questionBody);

        if (questionComments != null) {
          for (CommentData x : questionComments) {
            regexManage(x.getBody());
          }
        }
        if (ansDataList != null) {
          for (AnsData x : ansDataList) {
            regexManage(x.getBody());
            List<CommentData> answerComments = x.getComments();
            if (answerComments != null) {
              for (CommentData c : answerComments) {
                regexManage(x.getBody());
              }
            }
          }
        }
      }
    }
  }
}

class CodeVisitor extends VoidVisitorAdapter<Void> {
  private Map<String, Integer> classCount = new HashMap<>();
  private Map<String, Integer> methodCount = new HashMap<>();

  @Override
  public void visit(ClassOrInterfaceDeclaration cls, Void arg) {
    super.visit(cls, arg);

    // 统计类的出现次数
    String className = cls.getFullyQualifiedName().orElse("");
    classCount.put(className, classCount.getOrDefault(className, 0) + 1);
    for (MethodDeclaration method : cls.getMethods()) {
      // 获取方法名
      String methodName = method.getNameAsString();

      // 构建方法的全限定名
      String fullMethodName = className + "." + methodName;
      methodCount.put(fullMethodName, methodCount.getOrDefault(fullMethodName, 0) + 1);
    }
  }

  public Map<String, Integer> getClassCount() {
    return classCount;
  }

  public Map<String, Integer> getMethodCount() {
    return methodCount;
  }
}