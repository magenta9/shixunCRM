package wechat.event;

/**
 * 自定义菜单事件
 * Created by magenta9 on 2017/3/5.
 */
public class MenuEvent extends BaseEvent {

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    private String EventKey;    //事件的key，与自定义菜单接口的key对应
}
