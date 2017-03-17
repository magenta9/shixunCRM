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
<div class="row">
    <div class="col-md-12" align="center">
        <ul class="pagination">
            <!-- 后退按钮开始 -->
            <c:if test="${pagination.currentPage > 1}">
                <li class="previous"><a href="${queryParames}&currentPage=${pagination.currentPage - 1}" class="fui-arrow-left"></a></li>
            </c:if>
            <!-- 后退按钮结束 -->

            <!--页码列表开始 -->
            <c:if test="${pagination.totalPages < 10 }">
                <c:forEach begin="1" end="${pagination.totalPages}" step="1" var="i">
                    <c:if test="${pagination.currentPage == i}">
                        <li class="active"><a href="${queryParames}&currentPage=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${pagination.currentPage != i}">
                        <li><a href="${queryParames}&currentPage=${i}">${i}</a></li>
                    </c:if>
                </c:forEach>
            </c:if>

            <c:if test="${pagination.currentPage - 4 <= 0 && pagination.totalPages >= 10}">
                <c:forEach begin="1" end="10" step="1" var="i">
                    <c:if test="${pagination.currentPage == i}">
                        <li class="active"><a href="${queryParames}&currentPage=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${pagination.currentPage != i}">
                        <li><a href="${queryParames}&currentPage=${i}">${i}</a></li>
                    </c:if>
                </c:forEach>
            </c:if>

            <c:if test="${pagination.currentPage - 4 > 0 && pagination.currentPage + 5 <= pagination.totalPages && pagination.totalPages >= 10 }">
                <c:forEach begin="${pagination.currentPage - 4}" end="${pagination.currentPage + 5}" step="1" var="i">
                    <c:if test="${pagination.currentPage == i}">
                        <li class="active"><a href="${queryParames}&currentPage=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${pagination.currentPage != i}">
                        <li><a href="${queryParames}&currentPage=${i}">${i}</a></li>
                    </c:if>
                </c:forEach>
            </c:if>

            <c:if test="${pagination.currentPage + 5 > pagination.totalPages && pagination.totalPages >= 10}">
            <c:forEach begin="${pagination.totalPages - 9}" end="${pagination.totalPages}" step="1" var="i">
                <c:if test="${pagination.currentPage == i}">
                    <li class="active"><a href="${queryParames}&currentPage=${i}">${i}</a></li>
                </c:if>
                <c:if test="${pagination.currentPage != i}">
                    <li><a href="${queryParames}&currentPage=${i}">${i}</a></li>
                </c:if>
            </c:forEach>
            </c:if>
            <!-- 页码列表结束-->

            <!-- 上拉框开始-->
            <li class="pagination-dropdown dropup">
                <a href="#fakelink" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="fui-triangle-up"></i>
                </a>
                <ul class="dropdown-menu">
                    <c:forEach begin="5" end="15" step="2" var="i">
                        <c:if test="${pagination.pageSize == i}">
                            <li class="active"><a href="${queryParames}&changePageSize=${i}">${i}</a></li>
                        </c:if>
                        <c:if test="${pagination.pageSize != i}">
                            <li><a href="${queryParames}&changePageSize=${i}">${i}</a></li>
                        </c:if>
                    </c:forEach>
                </ul>
            </li>
            <!--上拉框结束-->

            <!--后退按钮开始-->
            <c:if test="${pagination.currentPage < pagination.totalPages}">
                <li class="next"><a href="${queryParames}&currentPage=${pagination.currentPage + 1}" class="fui-arrow-right"></a></li>
            </c:if>
            <!-- 后退按钮结束-->
        </ul>
    </div>
</div>
