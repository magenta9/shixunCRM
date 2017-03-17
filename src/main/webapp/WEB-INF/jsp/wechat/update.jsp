<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" >
	<title>修改会员信息</title>
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
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/wechat/revise_information.css">


</head>
<body>
	<div class="u_body">
		<div class="title">修改信息</div>

		<div class="u_list">
			<form action= "update" method="post" id="form_update">
				<input type="hidden" id="openid" name="openId" value="${openid}"/>

				<div class="form-group">
					<div class="pic" style="width:10%; float:left;">
						<label>
							<img src="${ pageContext.request.contextPath }/static/img/wechat/Register_name.png" style="height:35px;">
						</label>
					</div>
					<div class="info" style="width:90%; float:right;">
						<input type="text" id="username" style="width:100%; height:35px; border:none;" placeholder="输入用户名" name="userName" value="${user.userName}">
					</div>
					<div style="clear:both;"></div>
				</div>

				<div class="form-group">
					<div class="pic" style="width:10%; float:left;">
						<label>
							<img src="${ pageContext.request.contextPath }/static/img/wechat/Register_vCode.png" style="height:35px;">
						</label>
					</div>
					<div class="info" style="width:90%; float:right;">
						<input type="text" id="email" style="width:100%; height:35px; border:none;" placeholder="输入邮箱" name="userEmail" value="${user.userEmail}">
					</div>
					<div style="clear:both;"></div>
				</div>

				<div class="form-group">
					<div class="pic" style="width:10%; float:left;">
						<label>
							<img src="${ pageContext.request.contextPath }/static/img/wechat/Register_phone.png" style="height:35px;">
						</label>
					</div>
					<div class="info" style="width:90%; float:right;">
						<input type="text" id="phone" style="width:100%; height:35px; border:none;" placeholder="输入手机号" name="userPhone" value="${user.userPhone}">
					</div>
					<div style="clear:both;"></div>
				</div>

				<div class="form-group">
				<div style="width:100%; height:35px;">
					<button type="button"  style="width:100%; background:#FA1616; color:#FFF; border:none; border-radius:4px;" id="btn_update">确定</button>
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