package wechat.response;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class Video {
    private String MediaId;
    private String ThumbMediaId; //缩略图媒体Id

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
