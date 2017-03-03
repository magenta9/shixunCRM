<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>系统首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	  <!-- Loading Bootstrap -->
	  <link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	  <!-- Loading Flat UI -->
	  <link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	  <!-- 自定义 -->
	  <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/user.css">

	  <link rel="shortcut icon" href="${ pageContext.request.contextPath }/static/img/favicon.ico">

	  <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
	  <!--[if lt IE 9]>
	  <script src="${ pageContext.request.contextPath }/static/js/vendor/html5shiv.js"></script>
	  <script src="${ pageContext.request.contextPath }/static/js/vendor/respond.min.js"></script>
	  <![endif]-->

  </head>
  <body>

	<!--导航栏开始 -->
	<jsp:include page="${ pageContext.request.contextPath }/WEB-INF/jsp/controler/nav.jsp"></jsp:include>
	<!--导航栏结束 -->   

	<!-- 左侧开始-->
	<jsp:include page="${ pageContext.request.contextPath }/WEB-INF/jsp/controler/left.jsp"></jsp:include>
    <!--左侧结束 -->

    
	<div class="container div_main">
	
	   
	
	</div>

	<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>

	<script src="${ pageContext.request.contextPath }/static/js/flat-ui.min.js"></script>

  </body>
</html>
