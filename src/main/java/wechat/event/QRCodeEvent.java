package wechat.event;

/**
 *扫描带参数二维码
 * Created by magenta9 on 2017/3/5.
 */
public class QRCodeEvent extends BaseEvent {

    private String EventKey;    //事件key
    private String Ticket;      //换取二维码地址

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
