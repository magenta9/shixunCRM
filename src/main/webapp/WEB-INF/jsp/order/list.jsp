<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>会员购物记录页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	  <!-- Loading Bootstrap -->
	  <link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	  <!-- Loading Flat UI -->
	  <link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	<!-- 自定义 -->
  	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/body.css">
	<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/order.css">


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

	<div class="row">
		<!-- 左侧开始-->
		<jsp:include page="${ pageContext.request.contextPath }/WEB-INF/jsp/controler/left.jsp"></jsp:include>
		<!--左侧结束 -->

		<div class="col-md-9 div_main">
			<!-- 搜索框开始-->
			<div class="row div_search">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form action="list" role="search">
						<input type="hidden" name="userId" value="${userId}"/>
						<input type="hidden" name="userId" value="${pagination.currentPage}"/>
						<input type="hidden" name="pageSize" value="${pagination.pageSize}">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="搜索订单" name="text">
							<span class="input-group-btn">
				        <input type="submit" class="btn ">Go</input>
				      </span>
						</div><!-- /input-group -->
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>
			<!--搜索框结束 -->
			<br/>

	<c:if test="${empty pagination.items  && fn:length(pagination.items) <= 0}">
		<div class="alert alert-danger" role="alert">对不起，暂时还没有该会员的购物信息！</div>
	</c:if>

	<c:if test="${not empty pagination.items  && fn:length(pagination.items) > 0}">
			<!-- 订单-产品列表开始-->
			<div class="row" id="div_order">
				<div class="row">
					<c:forEach items="${pagination.items}" var="orderFormItem">
						<div class="panel panel-info">
							<div class="panel-heading">
								<table>
									<tbody>
									<td class="col-md-3">日期：${orderFormItem.date}</td>
									<td class="col-md-6">订单号：${orderFormItem.ordersCode}</td>
									<td class="col-md-3">品牌：${orderFormItem.productBrand}</td>
									</tbody>
								</table>
							</div>
							<div class="panel-body">
								<table>
									<tbody>
									<td class="col-md-2"><img  src="${orderFormItem.productImage}" style="width: 120px;height: 120px"></td>
									<td class="col-md-2">
											${orderFormItem.productName}
									</td>
									<td class="col-md-2">
										价格：${orderFormItem.productPrice}
									</td>
									<td class="col-md-1">
										数量：${orderFormItem.itemNum}
									</td>
									<td class="col-md-2">
										总价：${orderFormItem.productPrice}
									</td>
									<td class="col-md-3">
										实付：${orderFormItem.productPrice}
									</td>
									</tbody>
								</table>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- 订单-产品列结束-->

			<!-- 分页列表开始-->
			<jsp:include page="${ pageContext.request.contextPath }/WEB-INF/jsp/controler/page.jsp"></jsp:include>
			<!--分页列表结束-->
	</c:if>
		</div>
		<div class="col-md-1 div_footer"></div>
	</div>


	<!-- 右侧用户信息开始 -->
	<div class="div_right">
		<div class="div_img">
			<img src="
			<c:if test='${not empty user.userImageUrl}'>${user.userImageUrl}</c:if>
			<c:if test='${empty user.userImageUrl}'>
				${ pageContext.request.contextPath }/static/img/wechat/user.png
			</c:if>
			">
		</div>
		<div class="div_info">
			<span style="font-size: 12px;">${user.userName}</span><br/>
			<span style="font-size: 12px;">积分：${user.userScore}</span><br/>
		</div>
	</div>
	<!-- 右侧用户信息结束 -->


	<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>

	<script src="${ pageContext.request.contextPath }/static/js/flat-ui.min.js"></script>

  </body>
</html>
