<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2018/8/9
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 引入JQuery -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/esayUI/jquery.min.js"></script>
    <!-- 引入EasyUI -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/esayUI/jquery.easyui.min.js"></script>
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/esayUI/themes/default/easyui.css" type="text/css"/>
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/esayUI/themes/icon.css" type="text/css"/>
</head>
<body>
<h2>Custom TextBox</h2>
<p></p>
<div style="margin:20px 0;"></div>
<div align="center">
<form action="/SignServlet" method="post">
    <div class="easyui-panel" title="Login to system" style="width:100%;max-width:400px;padding:30px 60px;">
    <div style="margin-bottom:10px">
        <input class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Username',iconCls:'icon-man',iconWidth:38" type="text" name="username">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'Password',iconCls:'icon-lock',iconWidth:38" type="password" name="password">
    </div>
     <div style="margin-bottom:20px" align="center">
         <input type="submit" style="padding:5px 0px;width:60%;" value="注册" name="sign">
     </div>
        <div style="margin-bottom:20px" align="center">
            <input type="submit" style="padding:5px 0px;width:60%;" value="登录" name="sign">
        </div>
    </div>
</div>
</form>
<div style="color: red" align="center" >${sessionScope.LoginError}</div>
</body>
</html>