package util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by magenta9 on 2017/3/2.
 */
public class HttpGetDataUtil {

    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            //打开连接
            URLConnection connection = realUrl.openConnection();

            //设置通用属性
            connection.setRequestProperty("accept", "/");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MEIE 6.0; Windows NT 5.1;SV1)");

            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
            }

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
        return result;
    }

    @Test
    public void test() {
        String str = HttpGetDataUtil.sendGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc780fc7378aafeb0&secret=f6ae8731932922204d8a72760b2066a4");
    }
}
