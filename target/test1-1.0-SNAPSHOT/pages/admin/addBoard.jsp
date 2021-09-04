<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/7/2
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>添加新闻</title>
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" href="static/css/newspages.css">
    <script>
        let errori = '<%=request.getParameter("error")%>';
        if (errori === 'no') {
            alert('添加失败！');
        } else if (errori === 'yes') {
            alert('添加成功！');
        }
    </script>
</head>
<body>
<%@include file="/pages/common/body.jsp"%>
<script type="text/javascript" src="static/js/addBoard.js"></script>
<div class="container">
    <h1>新闻发布系统</h1>
    <h4></h4>
    <div class="news-list">
        <div class="news-list-left">
            <div class="about">
                <h4>关于我们</h4>
                <div class="about-des">
                    <p><a href="newsServlet?action=editBoard&dom=showBoardList">编辑新闻</a></p>
                    <p><a href="addNews.jsp">增添新闻</a></p>
                </div>
            </div>
        </div>

        <div class="news-list-right">
            <div class="news-list-item">
                <form action="newsServlet?action=editBoard&dom=addBoard" method="post">
                    <%--                    <input type="hidden" name="action" value="add">--%>
                    <h1 id="h1style">
                        <span id="addTitle"><img src="static/img/addNews/addnews.png" id="addimg">添加公告</span>
                    </h1>
                    <p>
                        <span class="addNewsForm">标题 :</span>
                        <input id="title" type="text" name="title" class="addSerier" required>
                    </p>
                    <p>
                        <span class="addNewsForm">组群/板块 :</span>
                        <input id="author" type="text" name="group" class="addSerier">
                    </p>
                    <p>
                        <span class="addNewsForm">内容 :</span>
                        <textarea id="message" name="content" required></textarea>
                    </p>
                    <p>
                        <button type="submit" class="button" id="addBtn">发布</button>
                    </p>

                </form>

            </div>
        </div>

        <footer class="copyright">

        </footer>
    </div>
</div>
</body>
</html>
