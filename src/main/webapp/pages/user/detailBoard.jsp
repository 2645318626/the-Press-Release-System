<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>公告</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>
<%@include file="/pages/common/body.jsp" %>
<div class="container">
    <h1>新闻发布系统</h1>
    <h4></h4>
    <div class="news-list">
        <div class="news-list-left">
            <div class="about">
                <h4>关于我们</h4>
                <div class="about-des">
                    <p>公告详情查看</p>
                </div>
            </div>
        </div>

        <div class="news-list-right">
            <div class="news-list-item">
                <div class="author-time">
                    </span>发表于<span>${requestScope.board.getDetailTime()}</span>
                </div>
                <div class="news-des">
                    <h3 class="news-title"><i></i><a href="#">【${requestScope.board.getGroup()}】${requestScope.board.getTitle()}</a></h3>
                    <div class="news-content-des">
                        <br>
                        ${requestScope.board.getContent()}
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
