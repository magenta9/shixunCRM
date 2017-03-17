package wechat.response;


/**
 * Created by magenta9 on 2017/3/5.
 */
public class VoiceMessage extends BaseMessage {
    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    private Voice voice;
}
