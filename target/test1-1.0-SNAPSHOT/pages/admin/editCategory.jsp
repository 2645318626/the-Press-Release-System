<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/6/24
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>新闻种类</title>
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" href="static/css/newspages.css">
    <script>
        let errori = '<%=request.getParameter("error")%>';
        if (errori === 'no') {
            alert('添加失败！');
        } else if (errori === 'yes') {
            alert('添加成功！');
        } else if (errori === 'exist') {
            alert('该类别已存在！');
        } else if (errori === 'delete') {
            alert('删除成功！');
        }
    </script>
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
                    <p><a href="newsServlet?action=adminShow">编辑新闻</a>
                    </p>
                    <p>
                        <a href="newsServlet?action=editCategory&dom=showCategoryBoard">新闻类别</a>
                    </p>
                </div>
            </div>
        </div>

        <div class="news-list-right">
            <h1 id="h1style">
                <span id="addTitle"><img src="static/img/addNews/addnews.png" id="addimg">添加新闻种类</span>
            </h1>
            <div class="news-list-item-left">
                <form action="newsServlet?action=addCategory&dom=addCategory" method="post">
                    <p>
                        <span class="addNewsForm">类型 :</span>
                        <input id="addType" type="text" name="addType" class="addSerier" required>
                    </p>
                    <p>
                        <button type="submit" class="button" id="addBtn">增加种类</button>
                    </p>
                </form>
            </div>
            <div class="news-list-item-right">
                <table id="showTable" style="width: 324px;text-align: center">
                    <tbody>
                    <tr>
                        <th>序号</th>
                        <th>类别名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${applicationScope.categoryList}" var="typeList" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${typeList.getType()}</td>
                            <td>
                                <a href="newsServlet?action=editCategory&sid=${typeList.getSid()}&dom=deleteCategory&type=${typeList.getType()}"
                                   class="editBtn">删除</a>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="news-list-item"></div>
        </div>
        <div class="news-list-item"></div>
    </div>
    <footer class="copyright">
    </footer>
</div>
</div>
</body>
</html>
