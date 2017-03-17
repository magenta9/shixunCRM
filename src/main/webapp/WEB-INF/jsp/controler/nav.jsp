<%--
  Created by IntelliJ IDEA.
  User: zwd
  Date: 2017/3/2
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
                    <span class="sr-only">Toggle navigation</span>
                </button>
                <a class="navbar-brand" href="#">CRM</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse-01">
                <ul class="nav navbar-nav">
                    <li <c:if test="${tab == 0}">class="active"</c:if>><a href="/admin/main">首页</a></li>
                    <li <c:if test="${tab == 1}">class="active"</c:if>><a href="${ pageContext.request.contextPath }/message/list">会员留言</a></li>
                    <li <c:if test="${tab == 2}">class="active"</c:if>><a href="${ pageContext.request.contextPath }/user/list">会员管理</a></li>
                    <li <c:if test="${tab == 3}">class="active"</c:if>><a href="${ pageContext.request.contextPath }/report/list">报表展示</a></li>
                    <li <c:if test="${tab == 4}">class="active"</c:if>><a href="${ pageContext.request.contextPath }/user/toRecommand">商品推荐</a></li>
                </ul>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <li><p class="navbar-text">欢迎您，${admin.adminName}</p></li>
                        <li><a href="/admin/logout">[<span>注销</span><span class="glyphicon glyphicon-log-out" style="margin-left: 10px"></span>]</a></li>
                    </ul>
                </div>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
