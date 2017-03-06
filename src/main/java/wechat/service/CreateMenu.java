package wechat.service;

import com.google.gson.Gson;
import wechat.util.ConnUtil;
import wechat.util.MyX509TrustManager;
import wechat.menu.Button;
import wechat.menu.ClickButton;
import wechat.menu.ComplexButton;
import wechat.menu.Menu;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class CreateMenu {

    public static void main(String[] args) throws IOException, NoSuchProviderException, NoSuchAlgorithmException, KeyManagementException {
        String menucreateurl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + ConnUtil.getToken();
        URL url = new URL(menucreateurl);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        TrustManager[] tm = {new MyX509TrustManager()};
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        SSLSocketFactory ssf = sslContext.getSocketFactory();
        httpsURLConnection.setSSLSocketFactory(ssf);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);

        httpsURLConnection.setRequestMethod("POST");

        OutputStream outputStream = httpsURLConnection.getOutputStream();
        outputStream.write(createMenu().getBytes("UTF-8"));
        outputStream.close();

        InputStream inputStream = httpsURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            stringBuffer.append(str);
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        httpsURLConnection.disconnect();
        System.out.println(bufferedReader);
    }

    public static String createMenu() {
        ClickButton c1 = new ClickButton();
        c1.setName("今日歌曲");
        c1.setType("click");
        c1.setKey("V10001_TODAY_MUSIC");

        ClickButton c2 = new ClickButton();
        c2.setName("歌手简介");
        c2.setType("view");
        c2.setKey("http://www.qq.com/");

        ClickButton c31 = new ClickButton();
        c2.setName("hello world");
        c2.setType("click");
        c2.setKey("V10001_HELLO_WORLD");

        ClickButton c32 = new ClickButton();
        c32.setName("赞一下");
        c32.setType("click");
        c32.setKey("V10001_GOOD");

        ComplexButton c3 = new ComplexButton();
        c3.setName("菜单");
        c3.setSub_button(new Button[] {c31, c32});

        Menu menu = new Menu();
        menu.setButton(new Button[] {c1,c2,c3});

        return new Gson().toJson(menu).toString();
    }
}
