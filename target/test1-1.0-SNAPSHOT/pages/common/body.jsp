<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/6/24
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div id="entry">
    <c:if test="${sessionScope.username==null}">
        <div class="login1">
            <form id="login_form" action="userServlet" method="post">
                <input type="hidden" value="userLogin" name="action">
                <label>用户名</label>
                <input type="text" name="logUsername" id="login_name">
                <label>密码</label>
                <input type="password" name="logPassword" id="login_pwd">
                <input type="submit" id="loginBtn" value="登录">
                <a href="register.jsp"><input type="button" id="registerBtn" value="注册"></a>
                <a href="pages/user/repassForm.jsp" id="forgetPwd">忘记密码？</a>
                <label id="error"></label>
            </form>
        </div>
    </c:if>
    <c:if test="${sessionScope.username != null}">
        <div class="login1">${sessionScope.username},欢迎使用新闻发布系统!<a
                href="pages/common/exit.jsp" target="_top">退出</a>
        </div>
    </c:if>
    <c:if test="${sessionScope.adminName==null}">
        <div class="login2">
            <a href="pages/admin/adminEntry.jsp">管理员入口</a>
        </div>
    </c:if>
    <c:if test="${sessionScope.adminName != null}">
        <div class="login2">${sessionScope.adminName},欢迎使用新闻发布系统！ <a
                href="pages/common/exit.jsp"
                target="_top">退出</a>
        </div>
    </c:if>
</div>
<%--<img src="img/index/bg.jpg" class="index-bg">--%>
<nav class="navbar">
    <div class="container navbar-content">
        <label><a href="newsServlet?action=indexShow">首页</a></label>
        <label class="location"><a href="newsServlet?action=indexShow" id="newspages">新闻中心</a>
            <ul class="sub-nav">
                <div class="news_left">
                    <li>
                        <a href="newsServlet?action=keyShow&key=娱乐"
                           class="new">娱乐</a></li>
                    <li>
                        <a href="newsServlet?action=keyShow&key=政治"
                           class="new">政治</a></li>
                    <li>
                        <a href="newsServlet?action=keyShow&key=社会"
                           class="new">社会</a></li>
                    <li>
                        <a href="newsServlet?action=keyShow&key=财经"
                           class="new">财经</a></li>
                    <li>
                        <a href="newsServlet?action=keyShow&key=科技"
                           class="new">科技</a></li>
                </div>
                <div class="news_right">
                    <li>
                        <a href="newsServlet?action=keyShow&key=健康"
                           class="new">健康</a></li>
                    <li>
                        <a href="newsServlet?action=keyShow&key=教育"
                           class="new">体育</a></li>
                    <li>
                        <a href="newsServlet?action=keyShow&key=旅游"
                           class="new">旅游</a></li>
                    <li>
                        <a href="newsServlet?action=keyShow&key=军事"
                           class="new">军事</a></li>
                    <li>
                        <a href="newsServlet?action=keyShow&key=其他"
                           class="new">其他</a></li>
                </div>
            </ul>
        </label>
        <label><a href="newsServlet?action=newspagesShow">更多</a></label>
        <label><a href="newsServlet?action=editBoard&dom=boardShow">公告栏</a></label>
        <c:if test="${sessionScope.username != null}">
            <label><a href="newsServlet?action=showNews&from=user">编辑新闻</a></label>
        </c:if>
        <c:if test="${sessionScope.adminName != null}">
            <label><a href="newsServlet?action=showNews&from=admin">编辑新闻</a></label>
            <label><a href="newsServlet?action=editBoard&dom=showBoardList">公告栏编辑</a></label>
        </c:if>
        <form action="newsServlet">
            <input type="hidden" name="action" value="keySearch">
            <label><input type="text" id="searchBox" placeholder="关键词" name="keySearch"></label>
            <label>
                <button type="submit" id="searchBtn"></button>
            </label>
        </form>
    </div>
</nav>
