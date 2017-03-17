package wechat.response;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class MusicMessage extends BaseMessage {
    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    private Music music;
}
