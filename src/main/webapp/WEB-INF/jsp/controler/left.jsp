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
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/static/css/my/left.css">
    <div class="col-md-2 div_left">
        <div class="left-col .pin">
            <ul class="nav">
                <li class="<c:if test='${tab == 1}'>active</c:if> li_top">
                    <a href="${ pageContext.request.contextPath }/message/list">
                        <span class="glyphicon glyphicon-envelope left" aria-hidden="true"></span>
                        <span class="midden">会员留言</span>
                        <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                    </a>
                </li>
                <li <c:if test="${tab == 2}">class="active"</c:if>>
                    <a href="${ pageContext.request.contextPath }/user/list">
                        <span class="glyphicon glyphicon-user left" aria-hidden="true"></span>
                        <span class="midden">会员管理</span>
                        <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                    </a>
                </li>
                <li <c:if test="${tab == 3}">class="active"</c:if>>
                    <a href="${ pageContext.request.contextPath }/report/list">
                        <span class="glyphicon glyphicon-indent-left left" aria-hidden="true"></span>
                        <span class="midden">报表展示</span>
                        <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                    </a>
                </li>
                <li class="<c:if test='${tab == 4}'>active</c:if> li_bottom">
                    <a href="${ pageContext.request.contextPath }/user/toRecommand">
                        <span class="glyphicon glyphicon-heart left" aria-hidden="true"></span>
                        <span class="midden">商品推荐</span>
                        <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                    </a>
                </li>
            </ul>
        </div>
    </div>