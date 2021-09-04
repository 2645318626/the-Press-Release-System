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
    <title>编辑新闻信息</title>
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" href="static/css/newspages.css">
    <script>
        function PreviewImage(imgFile) {
            const pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
            if (!pattern.test(imgFile.value)) {
                alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
                imgFile.focus();
            }
            const path = URL.createObjectURL(imgFile.files[0]);
            document.getElementById("imgPreview").innerHTML = "<img src='" + path + "' style='width:227px; height:130px;'/>";
        };
        let errori = '<%=request.getParameter("error")%>';
        if (errori === 'no') {
            alert('修改失败！');
        } else if (errori === 'yes') {
            alert('修改成功！');
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
                    <p><a href="newsServlet?action=showNews&from=user">编辑新闻</a></p>
                    <p><a href="addNews.jsp">增添新闻</a></p>
                </div>
            </div>
        </div>

        <div class="news-list-right">
            <div class="news-list-item">
                <form action="newsServlet?action=pudateNews&id=${param.id}" method="post" enctype="multipart/form-data">
                    <h1 id="h1style">
                        <span id="addTitle"><img src="static/img/addNews/addnews.png" id="addimg">编辑新闻信息</span>
                    </h1>
                    <p>
                        <span class="addNewsForm">标题 :</span>
                        <input id="title1" type="text" name="title" class="addSerier"
                               value="${requestScope.news.getTitle()}">
                    </p>
                    <p>
                        <span class="addNewsForm">作者 :</span>
                        <input id="author" type="text" name="author" class="addSerier"
                               value="${requestScope.news.getAuthor()}">
                    </p>
                    <p>
                        <span class="addNewsForm">内容 :</span>
                        <textarea id="message" name="content">${requestScope.news.getContent()}</textarea>
                    </p>
                    <p>
                        <span class="addNewsForm">关键词 :</span>
                        <input id="keyWords" type="text" name="keyWords" class="addSerier" value="${requestScope.news.getKeyWords()}" placeholder="国际、国内、要闻、热点等">
                    </p>
                    <p>
                        <span class="addNewsForm">类型 :</span>
                        <select name="type" value="${requestScope.news.getType()}" id="category">
                            <c:forEach items="${applicationScope.categoryList}" var="typeList">
                                <c:if test="${typeList.getType()==requestScope.news.getType()}">
                                    <option value="${typeList.getType()}" selected>${typeList.getType()}</option>
                                </c:if>
                                <c:if test="${typeList.getType()!=requestScope.news.getType()}">
                                    <option value="${typeList.getType()}">${typeList.getType()}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </p>
                    <p>
                        <br/><span class="addNewsForm">图片 :</span>
                    <div id="imgPath">
                        <input type="file" name="imgPath" onchange='PreviewImage(this)'>
                        <div id="imgPreview" value="${requestScope.news.getImgPath()}"></div>
                    </div>
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
