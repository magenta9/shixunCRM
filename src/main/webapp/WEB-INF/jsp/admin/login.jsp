<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>管理员登录页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

    <!-- 自定义 -->
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/login.css">

    <link rel="shortcut icon" href="${ pageContext.request.contextPath }/static/img/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="${ pageContext.request.contextPath }/static/js/vendor/html5shiv.js"></script>
      <script src="${ pageContext.request.contextPath }/static/js/vendor/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    
   	<div class="container">
   		<div class="row">
   			<div class="col-md-3"></div>
		   		<div class="login-form col-md-4">
		   			<form action="login" method="post">
		   				<h4 align="center">管理员登录</h4>
		   				<br/>
			   			<div class="form-group">
				   			<input  id="username" type="text" class="form-control" placeholder="请输入用户名"/>
				   			<span class="form-control-feedback fui-user" for="username"></span>
			   			</div>
			   			<div class="form-group">
				   			<input  id="password" type="text" class="form-control" placeholder="请输入密码"/>
				   			<span class="form-control-feedback fui-lock" for="password"></span>
			   			</div>
			   			<input type="submit" class="btn btn-hg btn-primary btn-block" value="登录"/>
		   			</form>
		   			<div id="div_forget_password"><a href="#">忘记密码？</a></div>
		   		</div>
		   		<div class="col-md-3"></div>
	   	</div>

   	</div>


    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
    <script src="${ pageContext.request.contextPath }/static/js/dist/js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${ pageContext.request.contextPath }/static/js/dist/js/flat-ui.min.js"></script>

  </body>
</html>
