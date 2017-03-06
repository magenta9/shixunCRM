package wechat.request;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class BaseMessage {

    private String  ToUserName;     //开发者微信号
    private String  FromUserName;   //发送者账号
    private long    CreateTime;     //消息创建秒数
    private String  MsgType;        //消息类型(text/image/location/link/voice)
    private long    MsgId;          //消息Id

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

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
