<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/6/24
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>编辑新闻</title>
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" href="static/css/newspages.css">
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
                    <p><a href="newsServlet?action=showNews&from=admin">编辑新闻</a></p>
                    <p><a href="newsServlet?action=editCategory&dom=showCategoryBoard">新闻类别</a></p>
                </div>
            </div>
        </div>

        <div class="news-list-right">
            <c:if test="${requestScope.list.size()==0}">
                <p>暂无可编辑的新闻，请添加新闻！</p>
            </c:if>
            <c:if test="${requestScope.list.size()>0}">
                <div class="news-list-item">
                    <table id="showTable">
                        <tr>
                            <th>序号</th>
                            <th>作者</th>
                            <th>类别</th>
                            <th>标题</th>
                            <th>更新时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        <c:forEach items="${requestScope.list}" var="news" varStatus="status">
                            <tr>
                                <td>${status.index+1}</td>
                                <td>${news.getAuthor()}</td>
                                <td>${news.getType()}</td>
                                <td class="overEllipsis" title="${news.getTitle()}">${news.getTitle()}</td>
                                <td>${news.getGetDate()}</td>
                                <td>
                                    <a href="newsServlet?action=detailNews&id=${news.getId()}&from=admin"
                                       class="editBtn" id="detailsBtn">详情</a>
                                    <a href="newsServlet?action=deleteNews&id=${news.getId()}"
                                       class="editBtn" id="deleteBtn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
        </div>

        <footer class="copyright">

        </footer>
    </div>
</div>
</body>
</html>
