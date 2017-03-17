package entity.wechat;

import com.google.gson.reflect.TypeToken;
import util.GsonUtil;
import util.HttpGetDataUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by magenta9 on 2017/3/2.
 */
public class AccessToken {
    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    private int expires_in;

    public static String gettoken() {
        String str = HttpGetDataUtil.sendGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc780fc7378aafeb0&secret=f6ae8731932922204d8a72760b2066a4");
        Map<String, String> map = GsonUtil.gson.fromJson(str, Map.class);

        return map.get("access_token");
    }

    public static void main(String[] args) {
        System.out.println(AccessToken.gettoken());
    }
}
