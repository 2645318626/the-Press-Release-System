<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/6/29
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <%@include file="../common/head.jsp"%>
    <link rel="stylesheet" href="static/css/register.css" type="text/css">
    <title>注册</title>
    <script>
        window.onload = function () {
            let loginBtn = document.getElementById('loginBtn');
            let adminLogUsername = document.getElementById('adminLogUsername');
            let adminLogPassword = document.getElementById('adminLogPassword');

            loginBtn.onclick = function () {
                if (adminLogUsername.value.trim() == "") {
                    alert("用户名不能为空!");
                    adminLogUsername.focus();
                    return false;
                }
                if (adminLogPassword.value.trim() == "") {
                    alert("密码不能为空!");
                    adminLogPassword.focus();
                    return false;
                }

            };

        }
        //取出传回来的参数error并与yes比较
        let errori = '<%=request.getParameter("error")%>';
        if (errori == 'no') {
            alert('用户名或密码不正确！');
        }
    </script>
</head>
<body>
<nav class="navbar">
    <div class="container navbar-content">
        <a href="newsServlet?action=indexShow">首页</a>
        <a href="#">关于我们</a>
    </div>
</nav>
<div id="message">
    <fieldset>
        <legend>管理员登录</legend>
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="adminLogin">
            <p>
                <span>昵称</span>
                <input type="text" name="adminLogUsername" id="adminLogUsername" placeholder="用户名">
            </p>
            <p>
                <span>密码</span>
                <input type="password" name="adminLogPassword" id="adminLogPassword" placeholder="密码">
            </p>
            <p>
                <button type="reset" id="resetBtn">重置</button>
                <button type="submit" class="submit" id="loginBtn">登 录</button>
            </p>
<%--            <p style="text-align:center;"><a href="../repass.html">忘记密码？</a></p>--%>
        </form>
    </fieldset>
</div>
</body>
</html>
