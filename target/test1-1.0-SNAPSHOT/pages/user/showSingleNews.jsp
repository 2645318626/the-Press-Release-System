<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/7/1
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻详细信息</title>
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" href="static/css/index.css">
    <link rel="stylesheet" href="static/css/newspages.css">
</head>
<body>
<%@include file="/pages/common/body.jsp"%>
<div class="container">
    <h1>新闻发布系统</h1>
    <h4></h4>
    <div class="news-list">
        <div class="news-list-left">
            <div class="about">
                <h4>关于我们</h4>
                <div class="about-des">
                    <p>新闻详情查看</p>
                </div>
            </div>
        </div>

        <div class="news-list-right">
            <div class="news-list-item">
                <div class="author-time">
                    <span>${requestScope.news.getAuthor()}</span>发表于<span>${requestScope.news.getGetDate()}</span>
                </div>
                <div class="news-des">
                    <h3 class="news-title"><i></i><a href="#">【${requestScope.news.getType()}】${requestScope.news.getTitle()}</a></h3>
                    <div class="news-content-des">
                        <img src="${requestScope.news.getImgPath()}">
                        <br>
                        ${requestScope.news.getContent()}
                    </div>
                </div>
            </div>
        </div>

        <footer class="copyright">

        </footer>
    </div>
</div>
</body>
</html>
