package wechat.util;

import com.google.gson.Gson;
import util.GsonUtil;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Objects;

/**
 * Created by magenta9 on 2017/3/8.
 */
public class Oauth2Util {

    /**
     * 获取accesstoken串
     *
     * @param code
     * @return
     */
    public static WeixinOauth2Token getOauth2AccessToken(String code) {
        WeixinOauth2Token wat = null;

        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", ConnUtil.appId);
        requestUrl = requestUrl.replace("SECRET", ConnUtil.appSecret);
        requestUrl = requestUrl.replace("CODE", code);

        String gsonObject = ConnUtil.httpRequest(requestUrl, "GET", null);
        gsonObject = gsonObject.substring(1, gsonObject.length() - 1);
        gsonObject = gsonObject.replace("\\\"", "\"");
        Map<String, String> map = GsonUtil.gson.fromJson(gsonObject, Map.class);
        try {
            wat = new WeixinOauth2Token();
            wat.setAccessToken(map.get("access_token"));
//            wat.setExpiresIn(Integer.valueOf(((Object) (map.get("expires_in"))).toString()).intValue());
            wat.setExpiresIn(7200);
            wat.setOpenId(map.get("openid"));
            wat.setRefreshToken(map.get("refresh_token"));
            wat.setScope(map.get("scope"));
        } catch (Exception e) {
//            e.printStackTrace();
            wat = null;
            int errcode = Integer.valueOf(((Object) (map.get("errcode"))).toString()).intValue();
            String errMsg = map.get("errmsg");
            System.out.printf("网页授权认证失败！errorcode: %s errormsg: %s\n", errcode, errMsg);

        }
        return wat;
    }

    public static SNSUserInfo getSNSUserInfo(String accessToken, String openid) {
        SNSUserInfo snsUserInfo;
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
        String gsonObject = ConnUtil.httpRequest(requestUrl, "GET", null);
        gsonObject = gsonObject.substring(1, gsonObject.length() - 1);
        gsonObject = gsonObject.replace("\\\"", "\"");
        Map<String, String> map = GsonUtil.gson.fromJson(gsonObject, Map.class);
        try {
            snsUserInfo = new SNSUserInfo();
            snsUserInfo.setOpenId(map.get("openid"));
            snsUserInfo.setNickname(map.get("nickname"));
//            snsUserInfo.setSex(Integer.valueOf(((Object) (map.get("sex"))).toString()).intValue());
            snsUserInfo.setSex(1);
            snsUserInfo.setCity(map.get("country"));
            snsUserInfo.setProvince(map.get("province"));
            snsUserInfo.setCity(map.get("city"));
            snsUserInfo.setHeadImgUrl(map.get("headimgurl"));
        } catch (Exception e) {
            e.printStackTrace();
            snsUserInfo = null;
            int errorcode = Integer.valueOf(((Object) (map.get("errcode"))).toString()).intValue();
            String errmsg = map.get("errmsg");
            System.out.printf("网页授权认证失败！errorcode: %s errormsg: %s\n", errorcode, errmsg);
        }
        return snsUserInfo;
    }

    /**
     * 刷新token串
     * @param refreshToken
     * @return
     */
    public static WeixinOauth2Token refreshOauth2AccessToken(String refreshToken) {
        WeixinOauth2Token wat = null;
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?" +
                "appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
        requestUrl = requestUrl.replace("APPID", ConnUtil.appId);
        requestUrl = requestUrl.replace("REFRESH_TOKEN", refreshToken);
        String gsonObject = ConnUtil.httpRequest(requestUrl, "GET", null);
        gsonObject = gsonObject.substring(1, gsonObject.length() - 1);
        gsonObject = gsonObject.replace("\\\"", "\"");
        Map<String, String> map = GsonUtil.gson.fromJson(gsonObject, Map.class);
        try {
            wat = new WeixinOauth2Token();
            wat.setAccessToken(map.get("access_token"));
            wat.setExpiresIn(Integer.valueOf(((Object) (map.get("expire_in"))).toString()).intValue());
            wat.setOpenId(map.get("openid"));
            wat.setRefreshToken(map.get("refresh_token"));
            wat.setScope(map.get("scope"));
        } catch (Exception e) {
            wat = null;
            int errcode = Integer.valueOf(((Object) (map.get("errcode"))).toString()).intValue();
            String errMsg = map.get("errmsg");
            System.out.printf("刷新网页授权认证失败！errorcode: %s errormsg: %s\n", errcode, errMsg);

        }
        return wat;
    }

    public static String urlEncodeUtf8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
