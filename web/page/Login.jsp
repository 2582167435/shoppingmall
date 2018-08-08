<%--
  Created by IntelliJ IDEA.
  User: CHN
  Date: 2018/8/8
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
    <form action="/SignServlet" method="post">
        <table width="260" border="1" align="center">
            <tr>
                <td>ID：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="登陆" name="sign">
                    &nbsp;
                    &nbsp;
                    <input type="submit" value="注册" name="sign"></td>
            </tr>
        </table>
    </form>
        <div style="color: red" align="center" >${sessionScope.LoginError}</div>
</body>
</html>
