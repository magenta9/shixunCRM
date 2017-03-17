<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>商品推荐页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	  <!-- Loading Bootstrap -->
	  <link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	  <!-- Loading Flat UI -->
	  <link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	  <!--自定义-->
	  <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/body.css">

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
		 <br/>
		 <!--用户信息栏-->
		 <div class="col-xs-3">
          <div class="tile">
			<div align="center" style="margin-bottom: 20px">
				<div style="width: 152px;height: 152px;">
					<img src="${ pageContext.request.contextPath }/static/img/pic.png" alt="会员头像"  id="user_pic" style="width: 150px;height: 150px;"/>
				</div>
				<div><span style="color: red;font-size: 14px;" id="span_warning"></span></div>
			</div>
			<a href="#" class="btn btn-primary btn-large btn-block" style="position:relative; overflow:hidden;" id="a_picture">更改用户
				<input type="file" style="position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);" name="user_pic" onchange="imgPreview(this)">
			</a>

			  <div style="margin-top: 50px;">
				<h6 class="btn btn-info btn-large btn-block" style="margin-top:10px">基本信息</h6>
				<ul class="list-group" style="margin-top:10px" id="basic_info">
					<li class="list-group-item">姓名ID：<span id="id"></span></li>
					<li class="list-group-item">姓名：<span id="username"></span></li>
					<li class="list-group-item">会员性别：<span id="sex"></span></li>
					<li class="list-group-item">会员手机：<span id="phone"></span></li>
					<li class="list-group-item">会员邮箱：<span id="email"></span></li>
					<li class="list-group-item">会员等级：<span id="grade"></span></li>
					<li class="list-group-item">会员积分：<span id="credit"></span></li>
				</ul>
			  </div>


			<%--<h6 class="btn btn-primary btn-large btn-block" style="margin-top:10px">行为分析</h6>--%>
			<%--<ul class="list-group" style="margin-top:10px" id="analysis_info">--%>

  				<%--<li class="list-group-item">情绪：<span id="usersex">开心</span></li>--%>
  				<%--<li class="list-group-item">喜好种类：<span id="hobby">化妆品</span></li>--%>
  				<%--<li class="list-group-item">喜好品牌：<span id="brand">嘉宝那</span></li>--%>
  				<%--<li class="list-group-item">喜好价格：<span id="price">300~500</span></li>--%>
			<%--</ul>--%>

          </div>
        </div>

        <!--针对该用户的推荐商品-->
        <div class="col-xs-9" id="div_product">
			<%--<div class="panel panel-info">--%>
				<%--<div class="panel-heading">--%>
					<%--<table>--%>
						<%--<tbody>--%>
						<%--<td class="col-xs-3">种类：奶</td>--%>
						<%--<td class="col-xs-3">品牌：妮维雅</td>--%>
						<%--<td class="col-xs-3">价格：2.22</td>--%>
						<%--</tbody>--%>
					<%--</table>--%>
				<%--</div>--%>
				<%--<div class="panel-body">--%>
					<%--<table>--%>
						<%--<tbody>--%>
						<%--<td class="col-md-2"><img src="${ pageContext.request.contextPath }/static/img/product/12.jpg"></td>--%>
						<%--<td class="col-md-2">--%>
							<%--妮维雅男士面霜保湿润肤露--%>
						<%--</td>--%>
						<%--<td class="col-md-8">--%>
							<%--牛奶是最古老的天然饮料之一，被誉为“白色血液”，对人体的重要性可想而知。牛奶顾名思义是从雌性奶牛身上所挤出来的。在不同国家，牛奶也分有不同的等级。目前最普遍的是全脂、低脂及脱脂牛奶。目前市面上牛奶的添加物也相当多，如高钙低脂牛奶，其中就增添了钙质--%>
						<%--</td>--%>

						<%--</tbody>--%>
					<%--</table>--%>
				<%--</div>--%>
			<%--</div>--%>
		</div>

	  </div>
	  <div class="col-md-1 div_footer"></div>
  	</div>

    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>
	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.form.js"></script>

	<script src="${ pageContext.request.contextPath }/static/js/flat-ui.min.js"></script>

	<script type="text/javascript" src="${ pageContext.request.contextPath }/static/js/bmob-min.js"></script>

  	<!--自定义js -->
  <script type="text/javascript" src="${ pageContext.request.contextPath }/static/js/my/user/recommand.js"></script>

  </body>
</html>
