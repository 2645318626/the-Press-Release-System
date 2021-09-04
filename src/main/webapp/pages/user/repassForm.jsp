<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/7/2
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="/pages/common/head.jsp" %>
    <link href="static/css/register.css" rel="stylesheet" type="text/css">
    <script src="static/js/repassForm.js"></script>
    <title>找回密码</title>
    <script>
        //取出传回来的参数error并与yes比较
        let errori = '<%=request.getParameter("error")%>';
        if (errori == 'no') {
            alert('该用户已存在！');
        } else if (errori == 'failure') {
            alert('注册失败！');
        }
    </script>
</head>
<body>
<script type="text/javascript" src="static/js/repassForm.js"></script>
<nav class="navbar">
    <div class="container navbar-content">
        <a href="newsServlet?action=indexShow">首页</a>
        <a href="#">公告栏</a>
    </div>
</nav>
<div id="message">
    <fieldset>
        <legend>修改密码</legend>
        <form method="post" action="userServlet?action=repass">
            <p>
                <span>昵称</span>
                <input type="text" name="repUsername" class="username" id="register_name" placeholder="用户名">
            </p>
            <p>
                <span>邮箱</span>
                <input type="text" name="repEmail" class="email" id="register_email" placeholder="Email">
            </p>
            <p>
                <button type="reset" id="resetBtn">重置</button>
                <button type="submit" id="repBtn">提交</button>
            </p>
        </form>
    </fieldset>
</div>
</body>
</html>
