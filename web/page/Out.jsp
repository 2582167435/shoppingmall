<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2018/8/13
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Out</title>
</head>
<body>
<c:forEach var="i" begin="0" items="${sessionScope.outlist}">
    <a href="/OutServlet?index=${i}">链接${i}</a>
    <br>
</c:forEach>

</body>
</html>
