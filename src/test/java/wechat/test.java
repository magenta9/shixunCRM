package wechat;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import util.GsonUtil;
import wechat.menu.Button;
import wechat.menu.ClickButton;
import wechat.menu.ComplexButton;
import wechat.menu.Menu;
import wechat.service.SendMessage;
import wechat.util.ConnUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class test {

    @Test
    public void testDom4j() throws DocumentException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        buffer.append("<person>");
        buffer.append("<name>zhang</name>");
        buffer.append("<sex>男</sex>");
        buffer.append("<address>江苏苏州</address>");
        buffer.append("</person>");

        Document document = DocumentHelper.parseText(buffer.toString());
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        for (Element element : elements) {
            System.out.println(element.getName() + "=>" + element.getText());
        }
    }

    public static String java2XML(Person person) {
        XStream xs = new XStream(new DomDriver());
        xs.alias("person", Person.class);
        return xs.toXML(person);
    }

    public static Object xml2Java(String xml) {
        XStream xs = new XStream(new DomDriver());
        xs.alias("person", Person.class);
        Person person = (Person) xs.fromXML(xml);
        return person;
    }

    @Test
    public void testXStream() {
        Person p1 = new Person();
        p1.setName("章铖");
        p1.setSex("男");
        p1.setAddress("江苏苏州");
        System.out.println(java2XML(p1));

        System.out.println(GsonUtil.gson.toJson(p1));

        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        buffer.append("<person>");
        buffer.append("<name>zhang</name>");
        buffer.append("<sex>男</sex>");
        buffer.append("<address>江苏苏州</address>");
        buffer.append("</person>");
        Person p2 = (Person) xml2Java(buffer.toString());
        System.out.println(p2.getName() + " --" + p2.getSex() + "--" + p2.getAddress());

    }

    @Test
    public void testJson() {
        String s1 = "{\"errcode\":0,\"errmsg\":\"ok\"}";
        Map<String, Object> map = new Gson().fromJson(s1, Map.class);
        System.out.println(map.get("errmsg"));
    }

    @Test
    public void testJsonMenu() {
        ClickButton c1 = new ClickButton();
        c1.setName("今日歌曲");
        c1.setType("click");
        c1.setKey("V10001_TODAY_MUSIC");

        ClickButton c2 = new ClickButton();
        c2.setName("歌手简介");
        c2.setType("view");
        c2.setKey("http://www.qq.com/");

        ClickButton c31 = new ClickButton();
        c2.setName("hello world");
        c2.setType("click");
        c2.setKey("V10001_HELLO_WORLD");

        ClickButton c32 = new ClickButton();
        c32.setName("赞一下");
        c32.setType("click");
        c32.setKey("V10001_GOOD");

        ComplexButton c3 = new ComplexButton();
        c3.setName("菜单");
        c3.setSub_button(new Button[] {c31, c32});

        Menu menu = new Menu();
        menu.setButton(new Button[] {c1,c2,c3});

        String jsonMenu = new Gson().toJson(menu).toString();
        System.out.println(jsonMenu);
    }

    @Test
    public void testSendMessage() {
        String jsonTextMsg = SendMessage.makeTextCustomMessage("oibdNwxhn5J2dMedaH8btQmzECI0", "<a href=\"http://www.baidu.com\">注册会员</a>");
        SendMessage.sendCustomMessage(ConnUtil.getToken(), jsonTextMsg);
    }

}
