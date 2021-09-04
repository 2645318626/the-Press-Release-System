<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/6/20
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" href="static/css/register.css" type="text/css">
    <script>
        window.onload = function () {
            let submitformBtn = document.getElementById('submitformBtn');
            let register_name = document.getElementById('register_name');
            let register_password = document.getElementById('register_password');
            let register_tell = document.getElementById('register_tell');
            let register_email = document.getElementById('register_email');

            submitformBtn.onclick = function () {
                // 验证昵称
                // 	* 不能为空，
                // 	* 不能使用特殊字符（除数字、字母、下划线、横杠），
                // 	* 长度6-20

                if (!/[\u4E00-\u9FA5A-z0-9]{2,15}$/.test(register_name.value)) {
                    if (register_name.value.trim() == "") {
                        alert('昵称不能为空！');
                    } else {
                        alert('您输入的用户名不合法');
                    }
                    register_name.focus();
                    return false;
                }

                if (register_password.value.trim() == "") {
                    alert('密码不能为空！');
                    register_password.focus();
                    return false;
                }

                /*
                    手机号码
                        11位
                        158 8888 8888
                        1 [3-9]
                 */
                if (!/^1[3-9]\d{9}$/.test(register_tell.value)) {
                    if (register_tell.value.trim() == "") {
                        alert('手机不能为空！');
                    } else {
                        alert('手机号不合法');
                    }
                    register_tell.focus();
                    return false;
                }

                /*
                    电子邮件
                        jinrong.xie@qq.com
                        123@qq.com
                        x_x@163.com
                        x-x@a-r.com.cn
                        x.x@laoxie.com
                        邮箱用户名必须3-30个字符
                 */
                if (!/^[a-z0-9][\w\-\.]{2,29}@[a-z0-9\-]{2,67}(\.[a-z\u2E80-\u9FFF]{2,6})+$/.test(register_email.value)) {
                    if (register_email.value.trim() == "") {
                        alert('邮箱不能为空！');
                    } else {
                        alert('邮箱格式不合法');
                    }
                    register_email.focus();
                    return false;
                }
                this.form.action = "/userServlet";
                this.form.submit();
            };
        };

        //取出传回来的参数error并与yes比较
        let errori = '<%=request.getParameter("error")%>';
        if (errori == 'no') {
            alert('该用户已存在！');
        }else if(errori == 'failure'){
            alert('注册失败！');
        }
    </script>
</head>
<body>
<nav class="navbar">
    <div class="container navbar-content">
        <a href="newsServlet?action=indexShow">首页</a>
        <a href="#">关于我们</a>s

    </div>
</nav>
<div id="message">
    <fieldset>
        <legend>注册</legend>
        <form method="post">
            <input type="hidden" name="action" value="register">
            <p>
                <span>昵称</span>
                <input type="text" name="regUsername" class="username" id="register_name" placeholder="用户名">
            </p>
            <p>
                <span>密码</span>
                <input type="password" name="regPassword" class="password" id="register_password" placeholder="密码">
            </p>
            <p>
                <span>电话</span>
                <input type="text" name="telphone" class="telphone" id="register_tell" placeholder="11位手机号码">
            </p>
            <p>
                <span>邮箱</span>
                <input type="text" name="email" class="email"  id="register_email" placeholder="Email">
            </p>
            <p>
                <button type="reset" id="resetBtn">重置</button>
                <button type="submit" id="submitformBtn">注册</button>
            </p>
        </form>
    </fieldset>
</div>
</body>
</html>
