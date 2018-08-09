<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2018/8/8
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<form action="/UpdateServlet" method="post">
    <table width="260"  align="center">
        <tr>
            <td style="text-align: right"><font color="red" >*</font> 用户名:</td>
            <td><input type="text" name="username" value="${requestScope.user.uName}" disabled="disabled"></td>
        </tr>
        <tr>
            <td style="text-align: right"><font color="red" >*</font>密码:</td>
            <td><input type="password" name="password" value="${requestScope.user.uPassword}"></td>
        </tr>
        <tr>
            <td style="text-align: right"><font color="red" >*</font>电话:</td>
            <td><input type="text" name="telephone" value="${requestScope.userInfo.uiTelephone}"></td>
        </tr>
        <tr>
            <td style="text-align: right"><font color="red" >*</font>地址:</td>
            <td><input type="text" name="address" value="${requestScope.userInfo.uiAddress}"></td>
        </tr>
        <tr>
            <td style="text-align: right">E-mail:</td>
            <td><input type="text" name="email" value="${requestScope.userInfo.uiEmail}"></td>
        </tr>
        <tr>
            <td  align="center"><input type="submit" value="修改"></td>
            <td  align="center"><input type="reset" value="重置"></td>
        </tr>
    </table>
    <div style="color: red" align="center">*为必填项目</div>
    <<div style="color: red" align="center">${sessionScope.UpdateError}</div>>
</form>

</body>
</html>
