package wechat.response;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class TextMessage extends BaseMessage {

    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
