package wechat.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import wechat.response.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class MessageUtil {
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  //请求消息文本
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";//请求图片
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";//语音
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";//视频
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  //地理位置
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  //链接

    public static final String REQ_MESSAGE_TYPE_EVENT = "event";    //事件推送

    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  //订阅
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  //取消订阅
    public static final String EVENT_TYPE_SCAN = "scan";        //扫描带参数的二维码
    public static final String EVENT_TYPE_LOCATION = "LOCATION";//上传地理位置
    public static final String EVENT_TYPE_CLICK = "CLICK";  //自定义菜单点击

    public static final String RESP_MESSAGE_TYPE_TEXT = "text"; //响应消息文本
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";   //图片
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";   //语音
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";   //视频
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";   //音乐
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";     //图文

    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<>();

        InputStream inputStream =  request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);

        Element root = document.getRootElement();
        List<Element> elementList = root.elements();

        for (Element element : elementList) {
            map.put(element.getName(), element.getText());
        }
        inputStream.close();
        inputStream = null;
        return map;
    }

    /**
     * 扩展支持CDATA
     */
    private static XStream xstream = new XStream(new XppDriver() {
       public HierarchicalStreamWriter createWriter(Writer out) {
           return new PrettyPrintWriter(out) {
               boolean cdata = true;

               public void startNode(String name, Class clazz) {
                   super.startNode(name, clazz);
               }

               protected void writeText(QuickWriter writer, String text) {
                   if(cdata) {
                       writer.write("<![CDATA[");
                       writer.write(text);
                       writer.write("]]>");
                   } else {
                       writer.write(text);
                   }
               }
           };
       }
    });

    /**
     * 文本转XML
     * @param textMessage
     * @return
     */
    public static String messageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 图像转XML
     * @param imageMessage
     * @return
     */
    public static String messageToXml(ImageMessage imageMessage) {
        xstream.alias("xml", imageMessage.getClass());
        return xstream.toXML(imageMessage);
    }

    /**
     * 语音转XML
     * @param voiceMessage
     * @return
     */
    public static String messageToXml(VoiceMessage voiceMessage) {
        xstream.alias("xml", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }

    /**
     * 视频转XML
     * @param videoMessage
     * @return xml
     */
    public static String messageToXml(VideoMessage videoMessage) {
        xstream.alias("xml", videoMessage.getClass());
        return xstream.toXML(videoMessage);
    }

    /**
     * 音乐转XML
     * @param musicMessage
     * @return xml
     */
    public static String messageToXml(MusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }

    /**
     * 图文消息转XML
     * @param newsMessage
     * @return xml
     */
    public static String messageToXml(NewsMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);
    }


}
