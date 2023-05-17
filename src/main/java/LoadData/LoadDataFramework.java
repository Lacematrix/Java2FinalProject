package LoadData;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoadDataFramework {
    public static void main(String[] args) throws IOException {
        String dataPath = "src/main/java/LoadData/Data/";
        catchQuestion(5, dataPath);
    }

    public static void catchQuestion(int n, String dataPath) throws IOException {
        // 创建 HttpClient 实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for (int i = 1; i <= n; i++) {
            // 创建 HttpGet 请求
            String url = "https://api.stackexchange.com/2.3/questions?page=" + i + "&pagesize=100&fromdate=1672531200&todate=1684195200&order=desc&sort=activity&tagged=java&site=stackoverflow&key=SWBR0xOBZfmI5EdJWx1jXA((";
            HttpGet httpGet = new HttpGet(url);
            // 发送请求并获取响应
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String htmlContent = EntityUtils.toString(response.getEntity());
            // 关闭 HttpClient 和响应
            response.close();
            // 将字符串写入 JSON 文件
            String filePath = dataPath + "Question"+ i + ".json";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(htmlContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        httpClient.close();
    }
}
