<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/6/20
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<html>
<head>
    <%@include file="/pages/common/head.jsp" %>
    <link href="static/css/register.css" rel="stylesheet" type="text/css">
    <title>找回密码</title>
    <script language="JavaScript">
        let errori = '<%=request.getParameter("error")%>';
        if (errori == 'no') {
            alert('修改失败！');
        } else if (errori == 'yes') {
            alert('修改成功,将关闭页面！');
            closePage();
        }
        function closePage() {
            if (navigator.userAgent.indexOf("Firefox") != -1 || navigator.userAgent.indexOf("Chrome") != -1) {
                window.location.href = "about:blank";
                window.close();
            } else {
                window.opener = null;
                window.open("", "_self");
                window.close();
            }
        }
    </script>
</head>
<body>
<script type="text/javascript" src="static/js/repass.js"></script>
<nav class="navbar">
    <div class="container navbar-content">
        <a href="newsServlet?action=indexShow">首页</a>
        <a href="#">公告栏</a>
    </div>
</nav>
<div id="message">
    <fieldset>
        <legend>修改密码</legend>
        <form method="post" action="userServlet">
            <input type="hidden" name="action" value="pudate">
            <p>
                <span>昵称</span>
                <input type="text" name="repUsername" class="username" id="repUsername" placeholder="用户名"
                       value="${applicationScope.repUsername}">
            </p>
            <p>
                <span>密码</span>
                <input type="password" name="repPassword" class="password" id="repPassword" placeholder="密码">
            </p>
            <p>
                <span>密码</span>
                <input type="password" name="cfPassword" class="password" id="cfPassword" placeholder="密码">
            </p>
            <p>
                <button type="reset" id="resetBtn">重置</button>
                <button type="submit" id="submitformBtn">提交</button>
            </p>
        </form>
    </fieldset>
</div>
</body>
</html>
