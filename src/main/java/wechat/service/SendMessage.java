package wechat.service;

import com.sun.javafx.binding.StringFormatter;
import util.GsonUtil;
import wechat.response.Article;
import wechat.response.Music;
import wechat.util.ConnUtil;
import wechat.util.HttpGetDataUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by magenta9 on 2017/3/6.
 */
public class SendMessage {

    /**
     * 拼接文本json信息
     * @param openId 用户微信号
     * @param content 文本内容
     * @return json串
     */
    public static String makeTextCustomMessage(String openId, String content) {
        content = content.replace("\"", "\\\"");
        String gsonMsg = "{\"touser\":\"%s\", \"msgtype\":\"text\", \"text\":{\"content\":\"%s\"}}";
        System.out.println(gsonMsg);
        return String.format(gsonMsg, openId, content);
    }

    /**
     * 拼接图像json信息
     * @param openId 用户微信号
     * @param mediaId 图像Id
     * @return json串
     */
    public static String makeImgaeCustomMessage(String openId, String mediaId) {
        String gsonMsg = "{\"touser\":\"%s\", \"msgtype\":\"image\", \"image\":{\"media_id\":\"%s\"}}";
        return String.format(gsonMsg, openId, mediaId);
    }

    /**
     * 拼接语音json消息
     * @param openId 用户微信号
     * @param mediaId 图像Id
     * @return json串
     */
    public static String makeVoiceCustomMessage(String openId, String mediaId) {
        String gsonMsg = "{\"touser\":\"%s\", \"msgtype\":\"voice\", \"voice\":{\"media_id\":\"%s\"}}";
        return String.format(gsonMsg, openId, mediaId);
    }

    /**
     * 拼接视频json信息
     * @param openId 用户微信号
     * @param mediaId 图像Id
     * @param thumbMediaId 缩略图Id
     * @return json串
     */
    public static String makeVideoCustomMessage(String openId, String mediaId, String thumbMediaId) {
        String gsonMsg = "{\"touser\":\"%s\", \"msgtype\":\"video\", \"video\":{\"media_id\":\"%s\", \"thumb_media_id\":\"%s\"}}";
        return String.format(gsonMsg, openId, mediaId, thumbMediaId);
    }

    /**
     * 拼接音乐json信息
     * @param openId 用户微信号
     * @param music 音乐对象
     * @return json串
     */
    public static String makeMusicCustomMessage(String openId, Music music) {
        String gsonMsg = "{\"touser\":\"%s\", \"msgtype\":\"music\", \"music\":%s}";
        gsonMsg = String.format(gsonMsg, openId, GsonUtil.gson.toJson(music));
        gsonMsg = gsonMsg.replace("thumbmediaid", "thumb_media_id");
        return gsonMsg;
    }


    /**
     * 拼接图文json信息
     * @param openId 用户微信号
     * @param articleList 图文list
     * @return json信息串
     */
    public static String makeNewsCustomMessage(String openId, List<Article> articleList) {
        String gsonMsg = "{\"touser\":\"%s\", \"msgtype\":\"news\", \"news\":{\"articles\":%s}}";
        gsonMsg = String.format(gsonMsg, openId, GsonUtil.gson.toJson(articleList).replaceAll("\"", "\\\""));
        gsonMsg = gsonMsg.replace("picUrl", "picurl");
        return gsonMsg;
    }

    /**
     * 发送客服消息
     * @param accessToken 访问Token
     * @param jsonMsg json格式的信息
     * @return 发送结果
     */
    public static boolean sendCustomMessage(String accessToken, String jsonMsg) {
        boolean result = false;
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        String gsonObject = ConnUtil.httpRequest(requestUrl, "POST", jsonMsg);
        gsonObject = gsonObject.substring(1, gsonObject.length() - 1);
        gsonObject = gsonObject.replace("\\\"", "\"");
        if (gsonObject != null) {
            Map<String, String> map = GsonUtil.gson.fromJson(gsonObject, Map.class);
            double errorCode = Double.valueOf(((Object)(map.get("errcode"))).toString()).doubleValue();
            String errorMsg = map.get("errmsg");
            if(errorCode > -0.1 && errorCode < 0.1) {
                result = true;
                System.out.printf("客服消息发送成功！ errorcode:%s errmsg:%s\n", errorCode, errorMsg);
            } else {
                System.out.printf("客服消息发送失败 errorcode:%s errmsg:%s\n", errorCode, errorMsg);
            }
        }

        return result;
    }

    /**
     * 发送文本信息
     * @param openid
     * @param content
     */
    public static void sendTextMessage(String openid, String content) {
        String jsonTextMsg = SendMessage.makeTextCustomMessage(openid, content);
        SendMessage.sendCustomMessage(ConnUtil.getToken(), jsonTextMsg);
    }

    /**
     * 发送图文消息
     * @param openid
     * @param list
     */
    public static void sendNewsMessage(String openid, List<Article> list) {
        String jsonNewsMsg = SendMessage.makeNewsCustomMessage(openid, list);
        SendMessage.sendCustomMessage(ConnUtil.getToken(), jsonNewsMsg);
    }
}
