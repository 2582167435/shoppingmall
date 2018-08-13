<%--
  Created by IntelliJ IDEA.
  User: CHN
  Date: 2018/8/8
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>淘淘网购物商城</title>
    <link rel="stylesheet" href="/css/login.css" type="text/css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">

</head>
<body>

<div id="wrap">
    <div id="header">
        <c:if test="${not empty sessionScope.userName}">
            <a href="/UserInfoServlet" class="login">${sessionScope.userName}</a>
            <a href="Login.jsp" class="login">注销</a>
        </c:if>
        <c:if test="${empty sessionScope.userName}">
            <a href="Login.jsp" class="login" target="a">登录</a>
            <a href="Home.jsp" class="login">注册</a>
        </c:if>
        <div class="logo">淘淘网购物商城</div>
        <div class="nav">
            <ul>
                <li><a href="#">主页</a></li>
                <li><a href="#">查看订单</a></li>
                <li><a href="#">购物车</a></li>
                <li><a href="#">关于我们</a></li>
            </ul>
        </div>
        <div id="find">
            <form method="post" action="/SelectServlet?index=0">
                <input type="text" name="find" width="100">
                <input type="submit" value="搜索" >
            </form>

        </div>
    </div>
    <div id="mainbody">
        <div id="sidebar">
            <dl>
                <dt>入库</dt>
                <dd><a href="Master.jsp?index=1">新增入库单</a></dd>
                <dd><a href="Master.jsp?index=2">修改入库单</a></dd>
                <dd><a href="Master.jsp?index=4">入库单确认</a></dd>
            </dl>
            <dl>
                <dt>出库</dt>
                <dd><a href="Master.jsp?index=6">出库单查询</a></dd>
            </dl>
        </div>
        <div id="content" >
            <c:if test="${param.index == 1}">
                <table>
                    <form action="/EntryServlet" method="post">
                        <tr><td>商品ID：<input type="text" name="gid" value="${sessionScope.entry.gID}"></td></tr>
                        <tr><td>供应商ID：<input type="text" name="sid" value="${sessionScope.entry.sID}"></td></tr>
                        <tr><td>管理员：<input type="text" name="entrymanager" value="${sessionScope.entry.entryManager}"></td></tr>
                        <tr><td>数量：<input type="text" name="count" value="${sessionScope.entry.eCount}"></td></tr>
                        <tr><td>入库方式：<input type="text" name="way" value="${sessionScope.entry.eWay}"></td></tr>
                        <tr><td><input type="submit" value="确认"></td></tr>
                    </form>
                    <c:if test="${param.flag==0}">
                        请确认信息
                    </c:if>
                    <c:if test="${param.flag==1}">
                        成功
                        <c:remove var="entry"/>
                    </c:if>
                    <td>
                        <tr></tr>
                    </td>
                </table>
            </c:if>
            <c:if test="${param.index == 2}">
                <c:forEach var="entry"  items="${sessionScope.entrylist}">
                    <a href="Master.jsp?index=3">链接${entry.eID}</a>
                    <c:set var="alterentry" value="${entry}" scope="session"/>
                    <br>
                </c:forEach>
            </c:if>
            <c:if test="${param.index==3}">
                <table>
                    <form action="/AlterEntryServlet" method="post">
                        <tr><td>商品ID：<input type="text" name="gid" value="${sessionScope.alterentry.gID}"></td></tr>
                        <tr><td>供应商ID：<input type="text" name="sid" value="${sessionScope.alterentry.sID}"></td></tr>
                        <tr><td>管理员：<input type="text" name="entrymanager" value="${sessionScope.alterentry.entryManager}"></td></tr>
                        <tr><td>数量：<input type="text" name="count" value="${sessionScope.alterentry.eCount}"></td></tr>
                        <tr><td>入库方式：<input type="text" name="way" value="${sessionScope.alterentry.eWay}"></td></tr>
                        <tr><td><input type="submit" value="确认"></td></tr>
                    </form>
                    <c:if test="${param.flag==1}">
                        修改成功
                    </c:if>
                    <td>
                        <tr></tr>
                    </td>
                </table>
            </c:if>
            <c:if test="${param.index == 4}">
                <c:forEach var="entry"  items="${sessionScope.entrylist}">
                    <a href="Master.jsp?index=5">链接${entry.eID}</a>
                    <c:set var="updateentry" value="${entry}" scope="session"/>
                    <br>
                </c:forEach>
            </c:if>
            <c:if test="${param.index==5}">
                <table>
                    <form action="/UpdateEntryServlet" method="post">
                        <tr><td>入库ID：<input type="text" name="gid" value="${sessionScope.updateentry.eID}"></td></tr>
                        <tr><td>商品ID：<input type="text" name="gid" value="${sessionScope.updateentry.gID}"></td></tr>
                        <tr><td>供应商ID：<input type="text" name="sid" value="${sessionScope.updateentry.sID}"></td></tr>
                        <tr><td>管理员：<input type="text" name="entrymanager" value="${sessionScope.updateentry.entryManager}"></td></tr>
                        <tr><td>入库时间：<input type="text" name="sid" value="${sessionScope.updateentry.entryDate}"></td></tr>
                        <tr><td>数量：<input type="text" name="count" value="${sessionScope.updateentry.eCount}"></td></tr>
                        <tr><td>入库方式：<input type="text" name="way" value="${sessionScope.updateentry.eWay}"></td></tr>
                        <tr><td><input type="submit" value="确认"></td></tr>
                    </form>
                    <c:if test="${param.flag==1}">
                        确认成功
                    </c:if>
                    <td>
                        <tr></tr>
                    </td>
                </table>
            </c:if>
            <c:if test="${param.index == 0}">
                <c:forEach var="entry"  items="${sessionScope.selectentry}">
                    <a href="Master.jsp?index=3">链接${entry.eID}</a>
                    <c:set var="alterentry" value="${entry}" scope="session"/>
                    <br>
                </c:forEach>
            </c:if>
        </div>
</body>

</html>
