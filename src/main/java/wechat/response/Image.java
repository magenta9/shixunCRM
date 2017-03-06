package wechat.response;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class Image {
    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    private String MediaId; //媒体文件ID
}
