<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>${param.group}</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>
<%@include file="/pages/common/body.jsp" %>
<div class="container">
    <h1>新闻发布系统</h1>
    <h4></h4>
    <div class="news-list">
        <div class="news-list-right">
            <div class="news-list-item">
                <c:forEach items="${applicationScope.boardList}" var="boards">
                    <div class="author-time">
                        发表于<span>${boards.getDetailTime()}</span>
                    </div>
                    <div class="news-des">
                        <h3 class="news-title"><i></i><a
                                href="#">【${boards.getGroup()}】${boards.getTitle()}</a></h3>
                        <div class="news-content-des">
                            <br>
                                ${boards.getContent()}
                        </div>
                    </div>
                    <br>
                </c:forEach>
            </div>
        </div>

        <div class="news-list-left">
            <div class="about">
                <h4>关于我们</h4>
                <div class="about-des">
                    <p>
                        这些栏目都采用信息发布与管理模块，信息发布系统根据用户选择的版块分类，自动发布所选的信息内容。可以使用此系统构造新闻内容页面，自动生成首页的新闻连接，同时产生历史新闻列表，提供新闻页面的管理界面，自动发布行业新闻，并且新闻内容页中支持插入图片方式和网页代码，自由设置新闻类别，自动显示信息及发布时间等。它大大减轻了网站更新维护的工作量，加快了信息的传播速度，使网站时时保持着活力和影响力。 我们为各个栏目设计不同的显示模板，使在让整个网站保持风格统一的前提下能够各有特色。</p>
                </div>
            </div>
        </div>

        <footer class="copyright">
        </footer>
    </div>
</div>
</body>
</html>
