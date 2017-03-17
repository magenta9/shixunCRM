<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<title>会员列表页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Loading Bootstrap -->
	<link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Loading Flat UI -->
	<link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	<!-- 自定义 -->
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/body.css">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/user.css">

	<link rel="shortcut icon" href="${ pageContext.request.contextPath }/static/img/favicon.ico">

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
	<!--[if lt IE 9]>
	<script src="${ pageContext.request.contextPath }/static/js/vendor/html5shiv.js"></script>
	<script src="${ pageContext.request.contextPath }/static/js/vendor/respond.min.js"></script>
	<![endif]-->

	<style>

	</style>
</head>
<body>

<!-- 会员录入模态框开始-->
<div class="modal fade" id="model_append" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">录入会员信息</h4>
			</div>
			<form action="add" method="post" class="form-horizontal" >
				<div class="modal-body">
					<div class="form-group">
						<label for="username" class="col-sm-3 control-label">输入用户名</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="username" name="userName" placeholder="4-12个字符"/>
							<span id="username_warning" class="span_warning"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-3 control-label">输入密码</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="password" name="userPassword" placeholder="6-12个字符，初始密码为123456" value="123456" />
							<span id="password_warning" class="span_warning"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="repassword" class="col-sm-3 control-label">重新输入密码</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="repassword" placeholder="6-12个字符，初始密码为123456" value="123456" />
							<span id="repassword_warning" class="span_warning"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="repassword" class="col-sm-3 control-label">选择性别</label>
						<div class="col-sm-9">
							<label class="radio" for="radio1">
								<input type="radio" value="男" id="radio1" name="userSex" data-toggle="radio" checked="checked" >
								男
							</label>
							<label class="radio" for="radio2">
								<input type="radio"  value="女" id="radio2"  name="userSex" data-toggle="radio">
								女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-3 control-label">输入e-mail</label>
						<div class="col-sm-9">
							<input type="email" class="form-control" id="email" name="userEmail" placeholder="输入正确的邮编" />
							<span id="email_warning" class="span_warning"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-3 control-label">输入手机号码</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="phone" name="userPhone" placeholder="输入正确的手机号" />
							<span id="phone_warning" class="span_warning"></span>
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<input type="submit" class="btn btn-primary" value="提交"/>
				</div>
			</form>
		</div>

	</div>
</div>
<!-- 会员录入模态框结束-->


<!--会员文件上传模态框开始!-->
<div class="modal fade" id="model_file" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-sm" role="document">

		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="gridSystemModalLabel">导入会员excel</h4>
			</div>
			<form action="addUsers" method="post" enctype="multipart/form-data" id="form_file">
			<div class="modal-body">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10"></div>
						<div class="form-group">
								<div class="col-sm-12" align="center">
									<div >
										<img src="" id="file_img" style="width: 130px;height: 130px">
										<div><span id="file_name">只支持xls文件</span></div>
										<div><span id="file_warning" style="font-size: 12px;color: red"></span></div>
									</div>
								</div>

								<div col-sm-12>
									<div class="col-sm-2"></div>
									<div class="col-sm-8" style="height:35px; background:#FA1616; color:#FFF; border:none; border-radius:4px; text-align:center;position: relative">选择文件
											<a href="javascript:void(0)">
											<input type="file" id="input_file" style="position:absolute; right:0; top:0;opacity:0;filter:alpha(opacity=0);" name="file"/>
											</a>
									</div>
									<div class="col-sm-2"></div>
								</div>
						</div>

				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="modal-footer">
				<input type="submit" class="btn" value="上传" id="sub_file" disabled/>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</form>
		</div><!-- /.modal-content -->
	</div>
</div>
<!--会员文件上传模态框结束-->

<!--导航栏开始 -->
<jsp:include page="${ pageContext.request.contextPath }/WEB-INF/jsp/controler/nav.jsp"></jsp:include>
<!--导航栏结束 -->

<div class="row">
	<!-- 左侧开始-->
	<jsp:include page="${ pageContext.request.contextPath }/WEB-INF/jsp/controler/left.jsp"></jsp:include>
	<!--左侧结束 -->



	<div class="col-md-9 div_main">
		<form id="form_search" action="list" role="search">
			<input type="hidden" name="pageSize" value="${pagination.pageSize}"/>
			<!-- 搜索框开始-->
			<div class="row div_search">
				<div class="col-md-3"></div>
				<div class="col-md-6">

					<div class="input-group">
						<input type="text" name="condition" id="condition" class="form-control" placeholder="搜索会员" value="${condition}">
						<span class="input-group-btn">
								<input class="btn " type="submit" id="btn_search" value="Go"/>
							  </span>
					</div><!-- /input-group -->

				</div>
				<div class="col-md-3"></div>
			</div>
			<!--搜索框结束 -->
			<div class="row div_radio">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<label class="radio">
						<input type="radio" name="radio"  value="1" data-toggle="radio" <c:if test="${radio == 1}">checked</c:if>/>
						按会员名查找
					</label>
					<label class="radio">
						<input type="radio" name="radio"  value="2" data-toggle="radio" <c:if test="${radio == 2}">checked</c:if>>
						按等级查找
					</label>
				</div>
				<div class="col-md-3"></div>
			</div>
		</form>

		<br/>

	<c:if test="${empty pagination.items  && fn:length(pagination.items) <= 0}">
		<div class="alert alert-danger" role="alert">对不起，暂时还没有会员信息！</div>
	</c:if>

	<c:if test="${not empty pagination.items  && fn:length(pagination.items) > 0}">
		<!-- 用户列表-->
		<div class="row" id="div_user">
			<table class="table table-hover table-bordered">
				<thead>
				<td><input type="checkbox" id="allcheck" onclick="checkBox('ids',this.checked)"></td>
				<td>ID</td>
				<td>会员名</td>
				<td>会员性别</td>
				<td>会员邮箱</td>
				<td>会员手机号码</td>
				<td>会员等级</td>
				<td>会员积分</td>
				<td>会员创建时间</td>
				<td>操作</td>
				</thead>

				<tbody>
					<form id="form_delete">
					<c:forEach items="${pagination.items}" var="user">
						<tr>

							<td><input type="checkbox" class="check_user"  name="ids" value="${user.userId }"></td>
							<td>${user.userId }</td>
							<td>${user.userName}</td>
							<td>${user.userSex}</td>
							<td>${user.userEmail}</td>
							<td>${user.userPhone}</td>
							<td>

								<c:forEach begin="1" end="${user.userLevel}" step="1">
									<span class="glyphicon glyphicon-star"></span>
								</c:forEach>

								<c:if test="${user.userLevel < 5 }">
									<c:forEach begin="${user.userLevel + 1}" end="5" step="1">
										<span class="glyphicon glyphicon-star-empty"></span>
									</c:forEach>
								</c:if>

							</td>
							<td>${user.userScore}</td>
							<td>${user.userCreateData}</td>
							<td>
								<div class="btn-group" role="group" aria-label="工具组">
									<a class="btn btn-xs btn-default" href="/order/list?userId=${user.userId }">详情</a>
									<a href="javascript:void(0);" class="btn btn-xs btn-default user_update" onclick="
									<c:if test="${not empty radio && not empty condition}">
											updateUser(${user.userId },${pagination.currentPage},${pagination.pageSize},${radio},'${condition}')
									</c:if>
									<c:if test="${empty radio && empty condition }">
											updateUser(${user.userId },${pagination.currentPage},${pagination.pageSize})
									</c:if>
											">
										修改
									</a>
									<a class="btn btn-xs btn-default"
									   href="delete?userId=${user.userId }&currentPage=${pagination.currentPage}&pageSize=${pagination.pageSize}&radio=${radio}&condition=${condition}">
										删除
									</a>
								</div>
							</td>
						</tr>
					</c:forEach>

					</form>
				</tbody>

			</table>
		</div>
		<!-- 用户列表结束-->


		<!-- 分页列表-->
		<jsp:include page="${ pageContext.request.contextPath }/WEB-INF/jsp/controler/page.jsp"></jsp:include>
		<!--分页列表结束-->
	</c:if>
	</div>


	<div class="col-md-1 div_footer"></div>
</div>

<!--右侧工具组开始-->
<div class="btn-group div_btn_group" role="group" aria-label="工具组">
	<button type="button" id="btn_append" class="btn btn-inverse" data-toggle="modal" data-target="#model_append">添加</button>
	<button type="button" class="btn btn-inverse" data-toggle="modal" data-target="#model_file">导入</button>
	<button type="button"  class="btn btn-inverse" onclick="
	<c:if test="${not empty radio && not empty condition}">
			deleteUsers(${pagination.currentPage},${pagination.pageSize},${radio},'${condition}')
	</c:if>
	<c:if test="${empty radio && empty condition }">
			deleteUsers(${pagination.currentPage},${pagination.pageSize})
	</c:if>
			">
		删除
	</button>
</div>
<!-- 右侧工具组结束-->

<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.form.js"></script>

<script src="${ pageContext.request.contextPath }/static/js/flat-ui.min.js"></script>

<!--自定义的js-->
<script type="text/javascript" src="${ pageContext.request.contextPath }/static/js/my/user/list.js"></script>


</body>

</html>
