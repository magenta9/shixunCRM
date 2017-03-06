package wechat.request;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class TextMessage extends BaseMessage{

    private String Content; //消息内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }
}
