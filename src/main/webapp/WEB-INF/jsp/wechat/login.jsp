<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" >
	<title>会员绑定页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1,
	user-scalable=no">
	<meta name="format-deteciton" content="telephone=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<!-- Loading Bootstrap -->
	<link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	<!-- Loading SweetAlert CSS-->
	<link href="${ pageContext.request.contextPath }/static/css/sweetalert.css" rel="stylesheet">

   <!--自定义css -->
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/wechat/user_login.css">

</head>
<body>
	<div class="u_body">
	  <div class="title">会员绑定</div>

	  <div class="u_list">

	   <form action="login" method="post" id="form_login">
		   <input type="hidden" name="openId" value="${openid}">
		  <div class="form-group">
			<div style="width:100px;margin:10px auto; padding-top:7px;">
				<img id="user_pic" src="${ pageContext.request.contextPath }/static/img/wechat/user.png" style="width:100px;height:100px;border-radius:50%; border-style:solid; border-color:#eee; ">
			</div>
			<div style="clear:both;"></div>
		  </div>

			<div class="form-group">
				<div class="pic">
					<label>
						<img src="${ pageContext.request.contextPath }/static/img/wechat/name.png">
					</label>
				</div>
				<div class="info">
					<input name="userName" id="username" type="text"  placeholder="输入用户名">
				</div>
				<div style="clear:both;"></div>
			</div>

		  	<div class="form-group">
				  <div class="pic">
					  <label>
						  <img src="${ pageContext.request.contextPath }/static/img/wechat/password.png">
					  </label>
				  </div>
				  <div class="info">
					  <input name="userPassword" id="password" type="password" placeholder="输入密码" >
				  </div>
				  <div style="clear:both;"></div>
			  </div>

		    <div class="form-group">
		    <div style="width:100%; height:35px;">
				<button class="submitinfo" type="button" id="btn_login">进行绑定</button>
		    </div>
		    </div>


	  </form>
	  </div>		
	</div>




	<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.form.js"></script>
	<!-- Loading sweetalert.js-->
	<script src="${ pageContext.request.contextPath }/static/js/sweetalert.min.js"></script>

	<!--自定义JS -->
	<script src="${ pageContext.request.contextPath }/static/js/wechat/login.js"></script>

</body>
</html>