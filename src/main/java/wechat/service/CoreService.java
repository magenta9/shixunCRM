package wechat.service;

import dao.MessageBoardDao;
import dao.UserDao;
import entity.MessageBoard;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.MessageBoardService;
import wechat.response.TextMessage;
import wechat.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class CoreService {

    private static UserDao userDao;
    private static MessageBoardDao messageBoardDao;

    public static String processRequest(HttpServletRequest request) {
        String responseXML = "";
        String responseContent = "未知的消息类型！";

        try {
            Map<String, String> requestMap = MessageUtil.parseXml(request);

            String fromUserName = requestMap.get("FromUserName");
            String toUserName = requestMap.get("ToUserName");
            String msgType = requestMap.get("MsgType");

            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//                responseContent = "您发送的是文本消息！";
                String content = requestMap.get("Content");
                if(content.substring(0, 2).equals("反馈")) {
                    responseContent = "您的反馈已提交，我们会尽快处理。";
                    MessageBoard mb = new MessageBoard();
                    System.out.println(fromUserName + " and " + toUserName);
                    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
                    userDao = (UserDao) ctx.getBean("userDao");
                    messageBoardDao = (MessageBoardDao) ctx.getBean("messageBoardDao");
                    User user = userDao.findUserByOpenId(fromUserName);
                    if(user == null) {
                        responseContent = "请首先绑定您的账户或者注册账户！";
                    } else {
                        mb.setUserId(user.getUserId());
                        mb.setState(0);
                        mb.setMessage(content.substring(2));
                        mb.setUserName(user.getUserName());
                        messageBoardDao.add(mb);
                    }
                } else {
                    responseContent = "你在说啥子";
                }
            } else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                responseContent = "您发送的是图片消息！";
            } else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                responseContent = "您发送的是语音消息！";
            } else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                responseContent = "您发送的是视频消息！";
            } else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                responseContent = "您发送的是地理位置消息！";
            } else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                responseContent = "您发送的是链接消息！";
            } else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                String eventType = requestMap.get("Event");
                if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    responseContent = "谢谢您的关注！请首先绑定账号或注册账号，然后上传头像信息，然后可使用其他功能";
                } else if(eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    //TODO
                } else if(eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    //TODO
                } else if(eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    //TODO
                } else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    //TODO 处理菜单单击
                    String eventKey = requestMap.get("EventKey");
                    if(eventKey.equals("BIND")) {
                        responseContent = "点击<a href=\"http://www.weiwoduzun.me/admin/toLogin\">绑定</a>以绑定会员账号";
                    } else if(eventKey.equals("REGISTER")) {
                        responseContent = "点击<a href=\"http://www.weiwoduzun.me/admin/toLogin\">注册</a>进行注册";
                    } else if(eventKey.equals("ALTER")) {
                        responseContent = "点击<a href=\"http://www.weiwoduzun.me/admin/toLogin\">修改</a>修改本人相关信息";
                    } else if(eventKey.equals("QUERY")) {
                        responseContent = "点击<a href=\"http://www.weiwoduzun.me/admin/toLogin\">查询订单</a>查看订单";
                    } else if(eventKey.equals("COMMEND")) {
                        responseContent = "<a href=\"http://www.weiwoduzun.me/admin/toLogin\">本日推荐商品</a>";
                    }
                }
            }
            textMessage.setContent(responseContent);
            responseXML = MessageUtil.messageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseXML;
    }
}
