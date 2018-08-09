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
    <title>淘淘</title>
    <link rel="stylesheet" href="/css/login.css" type="text/css">
</head>
<body>
<c:if test="${not empty sessionScope.userName}">
    <a href="/UserInfoServlet" class="login">${sessionScope.userName}</a>
    <a href="Login.jsp" class="login">注销</a>
</c:if>
<c:if test="${empty sessionScope.userName}">
    <a href="Login.jsp" class="login">登录</a>
    <a href="SignUP.jsp" class="login">注册</a>
</c:if>
</body>
</html>
