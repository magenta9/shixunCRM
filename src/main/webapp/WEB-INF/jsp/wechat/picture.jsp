<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" >
	<title>上传会员照片</title>
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


</head>
<body>
	<div class="u_body">

		<div class="u_list">

			<form enctype="multipart/form-data" method="post" action="#">
				<input type="hidden" name="openid" value="${openid}" id="openid">

				<div class="form-group" style="height:230px;">
					<div style="width:150px; height:200px; margin:10px auto; padding-top:35px; ">
						<img id="user_pic"
							 <c:if test="${empty user.userImageUrl}">
							 	src="${ pageContext.request.contextPath }/static/img/wechat/user.png" 							</c:if>
							 <c:if test="${not empty user.userImageUrl}">
							 	src="${ user.userImageUrl}"
							</c:if>
							 style="width:150px; height:150px;border-radius:50%">
					</div>
				</div>


				<div class="form-group" style="padding-bottom:15px; ">
					<div style="width:100%; height:35px; background:#FA1616; color:#FFF; border:none; border-radius:4px; text-align:center; position:relative">上传用户头像
						<a href="#" style="display:block; width:100%" id="a_file">
							<input type="file" style="position:absolute; left:0; top:0; opacity:0; filter:alpha(opacity=0); width:100%;" onchange="imgPreview(this)">
						</a>
					</div>
				</div>

			</form>
		</div>
	</div>


<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>
	<script src="${ pageContext.request.contextPath }/static/js/bmob-min.js"></script>
	<!-- Loading sweetalert.js-->
	<script src="${ pageContext.request.contextPath }/static/js/sweetalert.min.js"></script>

<!--自定义js-->
	<script src="${ pageContext.request.contextPath }/static/js/wechat/picture.js"></script>


</body>
</html>