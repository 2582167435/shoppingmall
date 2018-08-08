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

<form action="/SignUPServlet" method="post">
    <table width="260"  align="center">
        <tr>
            <td style="text-align: right"><font color="red" >*</font> 用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td style="text-align: right"><font color="red" >*</font>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td style="text-align: right"><font color="red" >*</font>电话：</td>
            <td><input type="text" name="telephone"></td>
        </tr>
        <tr>
            <td style="text-align: right"><font color="red" >*</font>地址：</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td style="text-align: right">E-mail：</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册" ></td>
        </tr>
    </table>
</form>
<div style="color: red" align="center">*为必填项目</div>
<div style="color: red" align="center" >${sessionScope.registerError}</div>
</body>
</html>
