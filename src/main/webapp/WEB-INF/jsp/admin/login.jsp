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

  <div style="background:url(${ pageContext.request.contextPath }/static/img/background.jpg) no-repeat center; opacity:0.5; position:absolute; z-index:-1; width:100%; height:100%; background-size:100%;">
  </div>


   		<div class="row">
		   		<div class="login-form" style="position:absolute;right: 250px; ">
		   			<form action="login" method="post" id="form_login">
		   				<h4 align="center">管理员登录</h4>
		   				<br/>
						<span style="font-size: 14px;color: #90111a" id="span_msg">${msg}</span>
			   			<div class="form-group">
				   			<input  id="username" type="text" class="form-control" placeholder="请输入用户名" name="adminName" value="${admin.adminName}"/>
				   			<span class="form-control-feedback fui-user" for="username"></span>
			   			</div>
			   			<div class="form-group">
				   			<input  id="password" type="password" class="form-control" placeholder="请输入密码" name="adminPassword" value="${admin.adminPassword}"/>
				   			<span class="form-control-feedback fui-lock" for="password"></span>
			   			</div>
			   			<input type="submit" class="btn btn-hg btn-primary btn-block" value="登录"/>
		   			</form>
		   		</div>
	   	</div>




	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>

	<script src="${ pageContext.request.contextPath }/static/js/flat-ui.min.js"></script>

  <script>
	  $(function () {
          $("#username").focus();
          $("#form_login").submit(function () {
              var username = $("#username").val();
              var password = $("#password").val();
			  if(username != null && username != "" && password != null && password != ""){
			      return true;
			  }else {
                  $("#span_msg").text("用户名和密码不能为空!");
			      return false;
			  }
          });

          $("#password").focus(function () {
              $("#span_msg").text("");
          });
          
      });

  </script>

  </body>
</html>
