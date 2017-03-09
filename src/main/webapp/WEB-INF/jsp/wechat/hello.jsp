<%--
  Created by IntelliJ IDEA.
  User: magenta9
  Date: 2017/3/3
  Time: 下午3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>hello</title>
    <%
        String openid = (String) request.getAttribute("openid");
    %>
</head>
<body>
 hello wechat.<%=openid%>
</body>
</html>
