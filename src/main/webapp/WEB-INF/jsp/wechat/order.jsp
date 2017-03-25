<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<title>购物记录查询界面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

    <!-- Loading Bootstrap -->
    <link href="${ pageContext.request.contextPath }/static/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="${ pageContext.request.contextPath }/static/css/flat-ui.min.css" rel="stylesheet">

    <!-- Loading SweetAlert CSS-->
    <link href="${ pageContext.request.contextPath }/static/css/sweetalert.css" rel="stylesheet">


    <!-- 自定义 -->
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/static/css/wechat/myList.css">

</head>
<body>    
	<!-- 订单-产品列表开始-->
    <div class="body" style="background:#fff;">

        <div class="u_body" style="max-width:720px; height:100%; margin:0px auto;">
	        <div class="tour" style="backgroud:#FA1616;">
             <p>我的订单</p>
            </div>
            <div class="qbdd">
                <ul>
                    <li>全部订单</li>
                </ul>
            </div>

            <!--*************************订单列表开始******************************-->
            <div id="div_order">

            </div>


            <div align="center"><a href="javascript:void(0);" id="a_order">点击加载更多</a></div>
            <!--*************************订单列表结束******************************-->

        </div>
    </div>

</body>

<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="${ pageContext.request.contextPath }/static/js/vendor/jquery.min.js"></script>
<!-- Loading sweetalert.js-->
<script src="${ pageContext.request.contextPath }/static/js/sweetalert.min.js"></script>

<script>
    var openid = "${openid}";
    var currentPage = 1;
    $(function () {
        ajaxOrder(currentPage);
    });

    $("#a_order").click(function () {
        currentPage ++;
        ajaxOrder(currentPage );
    });

    /**
     * 异步加载订单
     */
    function ajaxOrder(currentPage) {
        $.ajax({
            type:"get",
            url:"order?openid=" + openid + "&currentPage=" + currentPage,
            success:function (pagination) {
                if(pagination.items.length < 1){
                    swal("对不起没有更多了!");
                }else{
                    for(var i = 0; i < pagination.items.length; i++){
                        var orderFormItem = pagination.items[i];
                        var div_order = $("#div_order");
                        div_order.append("" +
                            "<div class='item'>" +
                            "<div class='ddbh'>" +
                            "<ul>" +
                            "<li class='li1'>订单编号：" + orderFormItem.ordersCode +"</li>" +
                            "<li class='li2'>" + orderFormItem.date + "</li>" +
                            "</ul>" +
                            "<div style='clear: both'></div>" +
                            "</div>" +
                            "<div class='zfdd'>" +
                            "<ul>" +
                            "<li class='li3'>" +
                            "<img src='"+orderFormItem.productImage +"'  style='width: 60px;height: 60px'/>" +
                            "</li>" +
                            "<li class='li4'>" +
                            "<span>×" + orderFormItem.ItemNum +"</span><br><span>"+ orderFormItem.productName+"</span> <br>" +
                            "<span style='color: red'>总额：￥" + orderFormItem.productPrice +"</span>" +
                            "</li>" +
                            "</ul>" +
                            "<div style='clear: both'></div>" +
                            "</div>" +
                            "</div>");
                    }
                }
            }
        });
    }
</script>

</html>