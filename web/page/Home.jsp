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
            <a href="SignUP.jsp" class="login">注册</a>
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
            <form method="post" action="/GoodsServlet">
                <input type="text" name="find" width="100">
                <input type="submit" value="搜索" >
            </form>

        </div>
    </div>
    <div id="mainbody">
        <div id="sidebar">
            <dl>
                <dt>男装</dt>
                <dd><a href="#">上衣</a></dd>
                <dd><a href="#">裤子</a></dd>
                <dd><a href="#">鞋</a></dd>
                <dd><a href="#">更多男装</a></dd>
            </dl>
            <dl>
                <dt>女装</dt>
                <dd><a href="#">上衣</a></dd>
                <dd><a href="#">裤子</a></dd>
                <dd><a href="#">鞋</a></dd>
                <dd><a href="#">更多女装</a></dd>
            </dl>
            <dl>
                <dt>鞋</dt>
                <dd><a href="#">运动鞋</a></dd>
                <dd><a href="#">皮鞋</a></dd>
                <dd><a href="#">高跟鞋</a></dd>
                <dd><a href="#">篮球鞋</a></dd>
                <dd><a href="#">其他鞋类</a></dd>
            </dl>
            <dl>
                <dt>其他</dt>
                <dd><a href="#">袜子</a></dd>
                <dd><a href="#">包</a></dd>
                <dd><a href="#">头带</a></dd>
                <dd><a href="#">户外用品</a></dd>
                <dd><a href="#">水壶</a></dd>
            </dl>


        </div>
        <div id="content" >
            <h1>CSS 简介</h1>
            <div class="pageto"><a href="#">上一章</a> <a href="#">下一章</a></div>
            <h3>你应该知道这些知识</h3>
            <p>在继续之前，你应该有一个以下基本认识：</p>
            <p>&middot; HTML / XHTML</p>
            <p class="learn">如果您希望首先学习这些项目，我们的<a href="#">主页</a>上可以找到教程。</p>
            <div class="disline"></div>
            <h3>什么是CSS？</h3>
            <p>CSS即级联样式表。

            <div id="footer">&copy;版权所有</div>
        </div></body>

</html>
