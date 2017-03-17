<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>找回密码</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<meta name="format-deteciton" content="telephone=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<!-- Loading Bootstrap -->
	<link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	<!-- Loading SweetAlert CSS-->
	<link href="${ pageContext.request.contextPath }/static/css/sweetalert.css" rel="stylesheet">

	<!--自定义的css文件-->
	<link href="${ pageContext.request.contextPath }/static/css/wechat/find_password.css" rel="stylesheet">

</head>
<body>

  <div class="u_body">
    <div class="title">找回密码</div>
    <div class="phone_form">
    	<form id="form_password" action="update" method="post">
		<input type="hidden" id="openid" name="openId" value="${openid}"/>
    	<div style="background:#fff; padding-left:10px; margin-top:20px; padding-right:5px;">

	    	<div class="form-group" style="padding-top:10px">
			    <div class="phone_pic" style="width:10px; float:left;">
			    		<label class="ness"> 
			    			<img style="height:30px;" src="${ pageContext.request.contextPath }/static/img/wechat/Login_Psw@2x.png">
			    		</label>
			    </div>
			    <div class="input_phone" style="width:90%; float:right;">
			    	<input style="line-height:35px; font-size:14px; line-height:normal; border:none; height:35px; width:100%;" type="password" class="input_phone" placeholder="请输入6-12新密码" id="password" name="userPassword" />
			    </div>
			    <div style="clear:both"></div>
		    </div>

		    <div class="form-group" style="padding-top:10px">
			    <div class="phone_pic" style="width:10px; float:left;">
			    		<label class="ness">
			    			<img style="height:30px;" src="${ pageContext.request.contextPath }/static/img/wechat/Login_Psw@2x.png">
			    		</label>
			    </div>
			    <div class="input_phone" style="width:90%; float:right;">
			    	<input style="line-height:35px; font-size:14px; line-height:normal; border:none; height:35px; width:100%;" type="password" class="input_phone" placeholder="请再次输入密码" id="repassword">
			    </div>
			    <div style="clear:both"></div>
		    </div>


		    <div class="form-group" style="padding-top:10px">
		      <div style="width:100%; margin:auto;">
				  <Button type="button" style="width:100%; margin:auto; height:35px; color:#fff; background:#FA1818; border-radius:5px; border:none;" id="btn_password">提交</Button>
		      </div>
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

  <!-- 自定义js -->
  <script src="${ pageContext.request.contextPath }/static/js/wechat/update.js"></script>

</body>
</html>