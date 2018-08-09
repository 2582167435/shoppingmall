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
    <script type="text/javascript" src="../javascript/LoginformCheck.js"></script>
</head>
<body>

<form action="/SignUPServlet" method="post" onsubmit="return checkAll()">
    <table width="500"  align="center">
        <tr>
            <td style="text-align: right"><font color="red" >*</font> 用户名：</td>
            <td><input type="text" name="username" id="username" onblur="checkName()"/><span id="name_msg">数字字母下划线，长度6-10</td>
        </tr>
        <tr>
            <td style="text-align: right"><font color="red"/> *</font>密码：</td>
            <td><input type="password" name="password"  id="pwd1" onblur="checkPwd()"/><span id="pwd1_msg">长度6-10</span></td>
        </tr>
        <tr>
            <td><font color="red"/> *</font>确认密码</td>
            <td><input type="password" name="pwd2" id="pwd2" onblur="checkPwd2()"/><span id="pwd2_msg">长度6-10</span></td>
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
