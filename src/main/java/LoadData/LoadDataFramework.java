package LoadData;

import LoadData.DataClass.QuestionLoad;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class LoadDataFramework {

  public static void main(String[] args) throws IOException {
    int n = 5;
    int blockSize = 10;
    String dataPath = "src/main/java/LoadData/Data/";
    //catchQuestion(n, dataPath);
    //catchAnswer(n, dataPath);
    catchComment(n, dataPath, blockSize); // 如果不分次数，则返回的对应question的comment只有一个
//        catchTag(n,dataPath);
//        catchThread(n,dataPath);
//        catchAPIData(50,dataPath);
  }

  public static void catchQuestion(int n, String dataPath) throws IOException {
    // 创建 HttpClient 实例
    CloseableHttpClient httpClient = HttpClients.createDefault();
    for (int i = 1; i <= n; i++) {
      // 创建 HttpGet 请求
      String url = "https://api.stackexchange.com/2.3/questions?page=" + i
          + "&pagesize=100&fromdate=1672531200&todate=1684195200&order=desc&sort=activity&tagged=java&site=stackoverflow&key=SWBR0xOBZfmI5EdJWx1jXA((";
      HttpGet httpGet = new HttpGet(url);
      // 发送请求并获取响应
      CloseableHttpResponse response = httpClient.execute(httpGet);
      String htmlContent = EntityUtils.toString(response.getEntity());
      // 关闭 HttpClient 和响应
      response.close();
      // 将字符串写入 JSON 文件
      String filePath = dataPath + "Question/Question" + i + ".json";
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        writer.write(htmlContent);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    httpClient.close();
  }


  public static void catchAnswer(int n, String dataPath) throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    for (int i = 1; i <= n; i++) {
      List<Long> QuestionId = new ArrayList<>();
      String jsonStrings = Files.readString(Path.of(dataPath + "Question/Question" + i + ".json"));
      JSONObject jsonObject = JSON.parseObject(jsonStrings);
      JSONArray itemsArray = jsonObject.getJSONArray("items");
      List<QuestionLoad> questions = itemsArray.toJavaList(QuestionLoad.class);
      questions.forEach(questionLoad -> {
        if (questionLoad.isIs_answered()) {
          QuestionId.add(questionLoad.getQuestion_id());
        }
      });
      StringBuilder idsBuilder = new StringBuilder();
      QuestionId.forEach(aLong -> {
        if (idsBuilder.length() > 0) {
          idsBuilder.append(";");
        }
        idsBuilder.append(aLong);
      });
      String questionIds = idsBuilder.toString();
      String url = "https://api.stackexchange.com/2.3/questions/{ids}/answers?order=desc&sort=activity&site=stackoverflow&&filter=!nOedRLgcx)&key=SWBR0xOBZfmI5EdJWx1jXA((";
      url = url.replace("{ids}", questionIds);
      HttpGet httpGet = new HttpGet(url);
      // 发送请求并获取响应
      CloseableHttpResponse response = httpClient.execute(httpGet);
      String htmlContent = EntityUtils.toString(response.getEntity());
      // 关闭 HttpClient 和响应
      response.close();
      // 将字符串写入 JSON 文件
      String filePath = dataPath + "Answer/Answer" + i + ".json";
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        writer.write(htmlContent);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    httpClient.close();
  }

  public static void catchComment(int n, String dataPath, int blockSize) throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    for (int i = 1; i <= n; i++) {
      List<Long> commentsId = new ArrayList<>();
      String jsonStrings = Files.readString(Path.of(dataPath + "Question/Question" + i + ".json"));
      JSONObject jsonObject = JSON.parseObject(jsonStrings);
      JSONArray itemsArray = jsonObject.getJSONArray("items");
      List<QuestionLoad> questions = itemsArray.toJavaList(QuestionLoad.class);
      questions.forEach(questionLoad -> {
        commentsId.add(questionLoad.getQuestion_id());
      });

      for (int j = 1; j <= blockSize; j++) {
        StringBuilder idsBuilder = new StringBuilder();
        int point = 1;
        while (point <= blockSize) {
          if (idsBuilder.length() > 0) {
            idsBuilder.append(";");
          }
          idsBuilder.append(commentsId.get((j - 1) * blockSize + (point - 1)));
          point++;
        }
        String questionIds = idsBuilder.toString();
        String url = "https://api.stackexchange.com/2.3/questions/{ids}/comments?order=desc&sort=creation&site=stackoverflow&key=SWBR0xOBZfmI5EdJWx1jXA((";
        url = url.replace("{ids}", questionIds);
        HttpGet httpGet = new HttpGet(url);
        // 发送请求并获取响应
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String htmlContent = EntityUtils.toString(response.getEntity());
        // 关闭 HttpClient 和响应
        response.close();
        // 将字符串写入 JSON 文件
        String filePath = dataPath + "Comment/Comment" + i + "_" + j + ".json";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
          writer.write(htmlContent);
        } catch (IOException e) {
          e.printStackTrace();
        }

      }

    }
    httpClient.close();
  }

  public static void catchTag(int n, String dataPath) throws IOException {
    // 创建 HttpClient 实例
    CloseableHttpClient httpClient = HttpClients.createDefault();
    for (int i = 1; i <= n; i++) {
      // 创建 HttpGet 请求
      String url = "https://api.stackexchange.com/2.3/questions?page=" + i
          + "&pagesize=100&order=desc&sort=activity&tagged=java&site=stackoverflow&filter=!*1PUVE3cpk6094nMNvnxLUHpqy_q(1*f*jeuA7T3K";
      HttpGet httpGet = new HttpGet(url);
      // 发送请求并获取响应
      CloseableHttpResponse response = httpClient.execute(httpGet);
      String htmlContent = EntityUtils.toString(response.getEntity());
      // 关闭 HttpClient 和响应
      response.close();
      // 将字符串写入 JSON 文件
      String filePath = dataPath + "Tag/Tag" + i + ".json";
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        writer.write(htmlContent);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    httpClient.close();
  }

  public static void catchThread(int n, String dataPath) throws IOException {
    // 创建 HttpClient 实例
    CloseableHttpClient httpClient = HttpClients.createDefault();
    for (int i = 1; i <= n; i++) {
      // 创建 HttpGet 请求
      String url = "https://api.stackexchange.com/2.3/questions?page=" + i
          + "&pagesize=100&order=desc&sort=activity&tagged=java&site=stackoverflow&filter=!2(Z4fEMyJHZi.R7_kQ2)IPyBBldeuPnlHkBlj0VkBQR.y73aPK5uJ3x.HXorxJgZivx";
      HttpGet httpGet = new HttpGet(url);
      // 发送请求并获取响应
      CloseableHttpResponse response = httpClient.execute(httpGet);
      String htmlContent = EntityUtils.toString(response.getEntity());
      // 关闭 HttpClient 和响应
      response.close();
      // 将字符串写入 JSON 文件
      String filePath = dataPath + "Thread/Thread" + i + ".json";
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        writer.write(htmlContent);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    httpClient.close();
  }

  public static void catchAPIData(int n, String dataPath) throws IOException {
    // 创建 HttpClient 实例
    CloseableHttpClient httpClient = HttpClients.createDefault();
    for (int i = 1; i <= n; i++) {
      // 创建 HttpGet 请求
      String url = "https://api.stackexchange.com/2.3/questions?page=" + i
          + "&pagesize=100&order=desc&sort=activity&tagged=java&site=stackoverflow&filter=!*KHnHsjZC(LHwqoHzWi.g5MJsD*vdpsjNLt9LLY16ytByNdsuEluM_SOZp8SGi";
      HttpGet httpGet = new HttpGet(url);
      // 发送请求并获取响应
      CloseableHttpResponse response = httpClient.execute(httpGet);
      String htmlContent = EntityUtils.toString(response.getEntity());
      // 关闭 HttpClient 和响应
      response.close();
      // 将字符串写入 JSON 文件
      String filePath = dataPath + "APIData/APIData" + i + ".json";
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        writer.write(htmlContent);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    httpClient.close();
  }
}

