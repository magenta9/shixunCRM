package wechat.response;

/**
 * 公众号 -> 用户
 * Created by magenta9 on 2017/3/5.
 */
public class BaseMessage {

    private String ToUserName;  //接收方ID
    private String FromUserName;//开发者微信号
    private long CreateTime;    //消息创建时间
    private String MsgType;     //消息类型 text/music/news

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
