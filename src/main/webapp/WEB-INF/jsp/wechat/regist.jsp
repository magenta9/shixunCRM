<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" >
	<title>注册会员</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1,
	user-scalable=no">

	<!-- Loading Bootstrap -->
	<link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	<!-- Loading SweetAlert CSS-->
	<link href="${ pageContext.request.contextPath }/static/css/sweetalert.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/wechat/user_register.css">

    <!--引入js文件-->
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
	<!--[if lt IE 9]>
	<script src="${ pageContext.request.contextPath }/static/js/vendor/html5shiv.js"></script>
	<script src="${ pageContext.request.contextPath }/static/js/vendor/respond.min.js"></script>
	<![endif]-->
</head>


<body>

	<div class="container-fluid">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header" style="background:#FA1616;">
			    <h4 class="modal-title" id="myModalLabel" style="color:#fff;">注册会员</h4>
			  </div>
			  <div class="modal-body">
			  	<form class="form-horizontal" action="regist" method="post" enctype="multipart/form-data"  id="form_regist">
					<input type="hidden" name="openId" value="${openid}">
		  			<div class="form-group">
		  				<label for="username" class="col-sm-3 control-label">输入用户名</label>
		  				<div class="col-sm-9">
		  					<input type="text" class="form-control" id="username" placeholder="4-12个字符" name="userName" />
		  					<span id="username_warning" class="span_warning"></span>
		  				</div>
				   	</div>

				   	<div class="form-group">
		  				<label for="password" class="col-sm-3 control-label">输入密码</label>
		  				<div class="col-sm-9">
		  					<input type="password" class="form-control" id="password" placeholder="6-12个字符"  name="userPassword"  />
							<span id="password_warning" class="span_warning"></span>
		  				</div>
				   	</div>

				   	<div class="form-group">
		  				<label for="repassword" class="col-sm-3 control-label">重新输入密码</label>
		  				<div class="col-sm-9">
		  					<input type="password" class="form-control" id="repassword" placeholder="6-12个字符" />
							<span id="repassword_warning" class="span_warning"></span>
		  				</div>
				   	</div>

				   	<div class="form-group">
		  				<label for="repassword" class="col-sm-3 control-label">选择性别</label>
		  				<div class="col-sm-2">
		  					<label class="radio" for="radio1">
                  				<input type="radio" name="userSex" value="男" id="radio1" data-toggle="radio" checked="checked" >
                  				男
                			</label>
                		</div>
                		<div class="col-sm-2">
                			<label class="radio" for="radio2">
                  				<input type="radio" name="userSex" value="女" id="radio2" data-toggle="radio">
                  				女
                			</label>
		  				</div>
				   	</div>

				   	<div class="form-group">
		  				<label for="email" class="col-sm-3 control-label">输入e-mail</label>
		  				<div class="col-sm-9">
		  					<input type="email" class="form-control" id="email" placeholder="输入正确的邮箱"  name="userEmail" />
							<span id="email_warning" class="span_warning"></span>
		  				</div>
				   	</div>

				   	<div class="form-group">
		  				<label for="phone" class="col-sm-3 control-label">输入手机号码</label>
		  				<div class="col-sm-9">
		  					<input type="text" class="form-control" id="phone" placeholder="输入正确的手机号" name="userPhone" />
							<span id="phone_warning" class="span_warning"></span>
		  				</div>
				   	</div>

	                <div class="modal-footer">
			    		<button type="button" class="btn btn-primary" id="btn_regist">提交</button>
			  		</div>

			  	</form>
			   
			  </div>
			</div>
		</div>
	</div>




	<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.form.js"></script>

	<!-- Loading sweetalert.js-->
	<script src="${ pageContext.request.contextPath }/static/js/sweetalert.min.js"></script>

	<!--自定义js-->
	<script src="${ pageContext.request.contextPath }/static/js/wechat/regist.js"></script>

</body>
</html>