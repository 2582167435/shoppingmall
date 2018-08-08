<%--
  Created by IntelliJ IDEA.
  User: CHN
  Date: 2018/8/8
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/SignServlet" method="post">
    <table width="260" border="1" align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td ><input type="submit" value="注册" name="sign"></td>
        </tr>
    </table>
</form>
<div style="color: red" ></div>
</body>
</html>
