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
    <div class="left-col">
        <ul class="nav">
            <li>
                <a href="${ pageContext.request.contextPath }/message/list">
                    <span class="glyphicon glyphicon-envelope left" aria-hidden="true"></span>
                    <span class="midden">会员留言</span>
                    <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                </a>
            </li>
            <li>
                <a href="${ pageContext.request.contextPath }/user/list">
                    <span class="glyphicon glyphicon-user left" aria-hidden="true"></span>
                    <span class="midden">会员管理</span>
                    <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                </a>
            </li>
            <li>
                <a href="#link-one">
                    <span class="glyphicon glyphicon-th left" aria-hidden="true"></span>
                    <span class="midden">商品管理</span>
                    <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                </a>
            </li>
            <li>
                <a href="#link-one">
                    <span class="glyphicon glyphicon-indent-left left" aria-hidden="true"></span>
                    <span class="midden">商品报表</span>
                    <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                </a>
            </li>
            <li>
                <a href="#link-one">
                    <span class="glyphicon glyphicon-heart left" aria-hidden="true"></span>
                    <span class="midden">商品推荐</span>
                    <span class="glyphicon glyphicon-chevron-right right" aria-hidden="true"></span>
                </a>
            </li>
        </ul>
    </div>
