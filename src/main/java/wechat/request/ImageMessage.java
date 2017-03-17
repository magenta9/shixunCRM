package wechat.request;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class ImageMessage extends BaseMessage {
    private String PicUrl;  //图片链接

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
