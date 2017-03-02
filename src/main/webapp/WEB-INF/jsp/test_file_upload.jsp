<%--
  Created by IntelliJ IDEA.
  User: alienware
  Date: 2017/3/1
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form  action="/crm/user/addUsers" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>选择头像：</td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>
