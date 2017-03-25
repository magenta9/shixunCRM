<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>商品推荐</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Loading Flat UI -->
	<link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">


	<!--自定义的css文件-->
	<link href="${ pageContext.request.contextPath }/static/css/wechat/user_recommand.css" rel="stylesheet">


	<!-- 引入下面两个库让 IE8 支持 HTML5 元素 -->
    <!-- 警告: Respond.js 通过 file:// 浏览的时候不能正常工作！-->
    <!--[if lt IE 9]>
    <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
    <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<input type="hidden" name="openid" value="${openid}" id="openid"/>
	<div class="u_body">
	  <div id="glist_box">
	  	<header class="u_header">
	  		<span>商品推荐</span>
	  	</header>
<!--
	  <div class="form-group" style="height:120px; background-color:#fff; margin-bottom:0px;">
	  	<div style="width:100px;margin:5px auto; padding-top:10px">
	  		<img id="user_pic" src="../img/timg_1.jpg" style="width:100px;height:100px;border-radius:50%">
	  	</div>
	  	<div style="clear:both;"></div>
	  </div>
	  -->

	  	<section>
	  		<ul id="goods_ul" class="u_goods_img">
	  			<%--<li>--%>
	  				<%--<div>--%>
	  					<%--<a href="">--%>
	  						<%--<img src="${ pageContext.request.contextPath }/static/img/wechat/product.jpg">--%>
	  					<%--</a>--%>
	  					<%--<div>女装 牛仔衬衫(长袖)(水洗产品) 181620 优衣库UNIQLO</div>--%>
	  					<%--<div>单价：<span>16</span></div>--%>
	  				<%--</div>--%>
	  			<%--</li>--%>
	  		</ul>
	  	</section>
	  	<div class="u_goods_toolbar"></div>
	  </div>
	</div>

</body>
<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>
<script src="${ pageContext.request.contextPath }/static/js/wechat/recommand.js"></script>

</html>