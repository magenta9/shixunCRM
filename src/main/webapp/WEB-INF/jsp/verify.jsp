<%--
  Created by IntelliJ IDEA.
  User: magenta9
  Date: 2017/3/2
  Time: 上午10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.security.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="javax.xml.parsers.*"%>
<%--<%--%>
    <%--Enumeration parameterNames = request.getParameterNames();--%>
    <%--String parameterName = null;--%>
    <%--String parameterValue = null;--%>
    <%--while (parameterNames.hasMoreElements()) {--%>
        <%--parameterName = (String) parameterNames.nextElement();--%>
        <%--parameterValue = request.getParameter(parameterName);--%>
        <%--System.out.println("weixin_test-param:"+parameterName+"="+parameterValue);--%>
    <%--}--%>


    <%--String TOKEN = "misfgahgkhsdsgfal";--%>
    <%--String echostr = request.getParameter("echostr");--%>
    <%--String signature = request.getParameter("signature");--%>
    <%--String timestamp = request.getParameter("timestamp");--%>
    <%--String nonce = request.getParameter("nonce");--%>
    <%--System.out.println("weixin_test:echostr="+echostr+",signature="+signature+",timestamp="+timestamp+",nonce="+nonce);--%>
    <%--List values = new ArrayList();--%>
    <%--values.add(TOKEN);--%>
    <%--values.add(timestamp);--%>
    <%--values.add(nonce);--%>
    <%--Collections.sort(values);--%>
    <%--StringBuffer content = new StringBuffer();--%>
    <%--for (int i = 0; i < values.size(); i++) {--%>
        <%--content.append(values.get(i));--%>
    <%--}--%>
    <%--MessageDigest md = MessageDigest.getInstance("SHA-1");--%>
    <%--byte[] b = md.digest(content.toString().getBytes("UTF-8"));--%>
    <%--String stmp = "";--%>
    <%--StringBuffer signInfo = new StringBuffer();--%>
    <%--for (int n = 0; n < b.length; n++) {--%>
        <%--stmp = Integer.toHexString(b[n] & 0XFF);--%>
        <%--if (stmp.length() == 1){--%>
            <%--signInfo.append("0");--%>
            <%--signInfo.append(stmp);--%>
        <%--}else{--%>
            <%--signInfo.append(stmp);--%>
        <%--}--%>
    <%--}--%>


    <%--System.out.println("weixin_test:signInfo="+signInfo+",signature="+signature);--%>
    <%--if(signInfo.toString().equals(signature)){--%>
        <%--out.clear();--%>
        <%--out.print(echostr);--%>

        <%--System.out.println("weixin_test(001):ok");--%>

        <%--//receive user's message from weixin platform--%>
        <%--BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));--%>
        <%--String line = null;--%>
        <%--StringBuffer sb = new StringBuffer();--%>
        <%--while((line = br.readLine())!=null){--%>
            <%--sb.append(line);--%>
        <%--}--%>
        <%--System.out.println("weixin_message:"+sb.toString());--%>

        <%--//recieved message :text--%>
        <%--if(sb.length()>0){--%>
            <%--Element root=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(sb.toString().getBytes("UTF-8"))).getDocumentElement();--%>
            <%--NodeList nodes = root.getChildNodes();--%>
            <%--int count = nodes.getLength();--%>
            <%--String textContent = null;--%>
            <%--String FromUserName = null;--%>
            <%--String ToUserName = null;--%>
            <%--boolean isText = false;--%>
            <%--for(int i=0;i<count;i++){--%>
                <%--String nodeName = nodes.item(i).getNodeName();--%>
                <%--String nodeValue = nodes.item(i).getFirstChild().getNodeValue();--%>
                <%--if("MsgType".equals(nodeName) && "text".equals(nodeValue)){--%>
                    <%--isText = true;--%>
                <%--}--%>
                <%--if("Content".equals(nodeName)){--%>
                    <%--textContent = nodeValue;--%>
                <%--}--%>
                <%--if("FromUserName".equals(nodeName)){--%>
                    <%--FromUserName = nodeValue;--%>
                <%--}--%>
                <%--if("ToUserName".equals(nodeName)){--%>
                    <%--ToUserName = nodeValue;--%>
                <%--}--%>
            <%--}--%>
            <%--System.out.println("weixin_message:textContent="+textContent);--%>

            <%--//reply text message--%>
            <%--if(isText){--%>
                <%--StringBuffer replyInfo = new StringBuffer();--%>
                <%--Date d = new Date();--%>
                <%--long CreateTime = d.getTime()/1000;--%>
                <%--replyInfo.append("<xml>");--%>
                <%--replyInfo.append("<ToUserName>");--%>
                <%--replyInfo.append("<![CDATA[").append(FromUserName).append("]]>");--%>
                <%--replyInfo.append("</ToUserName>");--%>
                <%--replyInfo.append("<FromUserName>");--%>
                <%--replyInfo.append("<![CDATA[").append(ToUserName).append("]]>");--%>
                <%--replyInfo.append("</FromUserName>");--%>
                <%--replyInfo.append("<CreateTime>");--%>
                <%--replyInfo.append(CreateTime);--%>
                <%--replyInfo.append("</CreateTime>");--%>
                <%--replyInfo.append("<MsgType>");--%>
                <%--replyInfo.append("<![CDATA[text]]>");--%>
                <%--replyInfo.append("</MsgType>");--%>
                <%--replyInfo.append("<Content>");--%>
                <%--replyInfo.append("<![CDATA[hello,你好！]]>");--%>
                <%--replyInfo.append("</Content>");--%>
                <%--replyInfo.append("</xml>");--%>
                <%--out.clear();--%>
                <%--out.print(replyInfo.toString());--%>
            <%--}--%>
        <%--}--%>
        <%--return;--%>
    <%--}else{--%>
        <%--System.out.println("weixin_test:err");--%>
    <%--}--%>
<%--%>--%>
<html>
<head>
</head>
<body>
<h2>Hello World!</h2>
</body>
</html>

