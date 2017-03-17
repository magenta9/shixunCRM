package wechat.request;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class VideoMessage extends BaseMessage {

    private String MediaId;     //视频消息媒体Id
    private String ThumbMediaId;//视频消息缩略图媒体Id

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
