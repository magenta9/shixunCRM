<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>商品报表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	  <!-- Loading Bootstrap -->
	  <link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	  <!-- Loading Flat UI -->
	  <link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

	  <!--日期插件-->
	  <link href="${ pageContext.request.contextPath }/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

	  <!-- 自定义 -->
	  <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/body.css">
	  <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/report.css">

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

			<!-- 销售额统计报表开始-->
			<div class="row div_report">
				<div class="row">
					<div class="col-md-12" align="center"><h5>销售额统计</h5></div>
				</div>

				<div class="row" >
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div>
							<div><span>请选择日期范围</span></div>
							<input type="text"  class="startDate" id="sale_startDate" readonly>~
							<input type="text"  class="endDate" id="sale_endtDate" readonly>
							<span style="margin-left: 10px;"><button class="btn" id="btn_sale">确定</button></span>
						</div>
						<div id="saleCount"  style=" height:400px ; border: 1px solid #eeeeee;margin-top: 10px"></div>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
			<!-- 销售额统计报表结束-->

			<!-- 会员注册数统计报表开始-->
			<div class="row div_report">
				<div class="row">
					<div class="col-md-12" align="center"><h5>会员注册数</h5></div>
				</div>
				<div class="row" >
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div>
							<div><span>请选择日期范围</span></div>
								<input type="text"  class="startDate" id="user_startDate" readonly>~
								<input type="text"  class="endDate" id="user_endDate"  readonly>
								<span style="margin-left: 10px;"><button class="btn" id="btn_user">确定</button></span>
						</div>
						<div id="userAdd"  style=" height:400px ; border: 1px solid #eeeeee;margin-top: 10px"></div>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>

			<!-- 会员注册数统计报表结束-->
			<div class="row div_report">
				<div class="row">
					<div class="col-md-12" align="center"><h5>分类统计</h5></div>
				</div>

				<div class="row" >
					<div class="col-md-1"></div>
					<div class="col-md-5">
						<div id="catagoryRadio" style="border: 1px solid #eeeeee;margin-top: 10px;height: 600px;"></div>
					</div>
					<div class="col-md-5">
						<div id="userSexRadio" style="border: 1px solid #eeeeee;margin-top: 10px; height: 550px;"></div>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
		</div>

		<div class="col-md-1 div_footer"></div>
	</div>


	<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>

	<script src="${ pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
	<script src="${ pageContext.request.contextPath }/static/js/bootstrap-datetimepicker.min.js"></script>
	<script src="${ pageContext.request.contextPath }/static/js/bootstrap-datetimepicker.zh-CN.js"></script>

	<script src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>

	<!--自定义JS-->
	<script src="${pageContext.request.contextPath}/static/js/my/report/list.js"></script>

	<script type="application/javascript">

	</script>

  </body>
</html>
