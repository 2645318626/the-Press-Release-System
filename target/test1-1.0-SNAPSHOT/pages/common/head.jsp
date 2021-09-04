<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/6/26
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<base href="<%=basePath%>">
<link href="static/css/index.css" rel="stylesheet"
      type="text/css">
<script src="https://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script>
    window.onload = function () {
        document.getElementById('loginBtn').onclick = function () {
            let login_form = document.getElementById('login_form');
            let login_name = document.getElementById('login_name');
            let login_pwd = document.getElementById('login_pwd');
            if (login_name.value.trim() === "") {
                alert("用户名不能为空!");
                login_name.focus();
                return false;
            }
            if (login_pwd.value.trim() === "") {
                alert("密码不能为空!");
                login_pwd.focus();
                return false;
            }
        };
    };
</script>

