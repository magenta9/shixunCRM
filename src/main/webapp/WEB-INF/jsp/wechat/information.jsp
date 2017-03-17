<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" >
	<title>查询会员信息</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1,
	user-scalable=no">
	<meta name="format-deteciton" content="telephone=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<!-- Loading Bootstrap -->
	<link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	<!--引入文件上传插件 -->
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/wechat/revise_information.css">

</head>
<body>
	<div class="u_body">
	  <div class="title">会员信息</div>

	  <div class="u_list">

	  <div class="form-group" style="height:120px;">
	  	<div style="width:100px;margin:5px auto; padding-top:10px">
	  		<img id="user_pic"
			<c:if test="${empty user.userImageUrl}">
				 src="${ pageContext.request.contextPath }/static/img/wechat/user.png" 							</c:if>
			<c:if test="${not empty user.userImageUrl}">
				 src="${ user.userImageUrl}"
			</c:if>
			 style="width:100px;height:100px;border-radius:50%">
	  	</div>
	  	<div style="clear:both;"></div>
	  </div>

	  		<div class="form-group">
		    	<div class="pic" style="width:10%; float:left;">
		    		<label>
		    			<img src="${ pageContext.request.contextPath }/static/img/wechat/name.png" style="height:35px; ">
		    		</label>
		    	</div>
		    	<div class="info" style="width:90%; float:right;">
		    		<div style="width:100%; height:35px; border:none;">
		    		<span id="username" style="font-size:22px">${user.userName}</span>
		    		</div>
		    	</div>
		    	<div style="clear:both;"></div>
		    </div>

		    		    <div class="form-group">
		    	<div class="pic" style="width:10%; float:left;">
		    		<label>
		    			<img src="${ pageContext.request.contextPath }/static/img/wechat/credit.png" style="height:35px;">
		    		</label>
		    	</div>
		    	<div class="info" style="width:90%; float:right;">
		    		<div style="width:100%; height:35px; border:none;">
		    		<span id="credit" style="font-size:22px">${user.userScore}</span>
		    		</div>
		    	</div>
		    	<div style="clear:both;"></div>
		    </div>

		    <div class="form-group">
		    	<div class="pic" style="width:10%; float:left;">
		    		<label>
		    			<img src="${ pageContext.request.contextPath }/static/img/wechat/grade.png" style="height:35px;">
		    		</label>
		    	</div>
		    	<div class="info" style="width:90%; float:right;">
		    		<div style="width:100%; height:35px; border:none;">
		    		<span id="grade" style="font-size:22px">${user.userLevel}</span>
		    		</div>
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
		    		<div style="width:100%; height:35px; border:none;">
		    		<span id="phone" style="font-size:22px">${user.userPhone}</span>
		    		</div>
		    	</div>
		    	<div style="clear:both;"></div>
		    </div>

		    <div class="form-group">
		    	<div class="pic" style="width:10%; float:left;">
		    		<label>
		    			<img src="${ pageContext.request.contextPath }/static/img/wechat/email.png" style="height:35px;">
		    		</label>
		    	</div>
		    	<div class="info" style="width:90%; float:right;">
		    		<div style="width:100%; height:35px; border:none;">
		    		<span id="email" style="font-size:22px">${user.userEmail}</span>
		    		</div>
		    	</div>
		    	<div style="clear:both;"></div>
		    </div>

		    <div class="form-group">
		    	<div style="height:10px;"></div>
		    </div>

	  </div>

	</div>

</body>
</html>