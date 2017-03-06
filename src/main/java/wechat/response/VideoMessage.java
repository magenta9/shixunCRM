package wechat.response;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class VideoMessage extends BaseMessage {
    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    private Video video;
}
