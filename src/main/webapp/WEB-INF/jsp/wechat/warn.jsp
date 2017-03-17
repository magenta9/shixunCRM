<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>操作失败</title>

	<!-- Loading Bootstrap -->
	<link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css"rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

</head>
<body>
	<div style="max-width:720px; min-height:100%; margin:0 auto;">
		<div style="width:100%; margin-top:20%;text-align: center">
			<img src="${ pageContext.request.contextPath }/static/img/wechat/warning.png" >
			<div style="text-align:center;font-weight:bold;font-size:50px;">${msg}</div>
		</div>
	</div>
</body>
</html>