<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>新闻发布系统</title>
    <%@include file="/pages/common/head.jsp"%>
    <script>
        //取出传回来的参数error并与yes比较
        let errori = '<%=request.getParameter("error")%>';
        if (errori === 'no') {
            alert('用户名或密码不正确！');
        } else if (errori === 'success') {
            alert('注册成功，请登录！');
        }else if (errori === 'repass') {
            alert('请到您的邮箱前往修改密码界面!');
        }else if (errori === 'failure') {
            alert('失败，请重试！');
        }else if (errori === 'exist'){
            alert('用户名已存在！');
        }else if(errori === 'yes'){
            alert('登陆成功！');
        }
    </script>
</head>
<body>
<%@include file="/pages/common/body.jsp"%>
<div class="container">
    <H1>新闻发布系统</H1>
    <H4></H4>
    <div class="news-list">
        <div class="news-list-right">
            <c:if test="${requestScope.list==null}">
                <a class="click" href="newsServlet?action=indexShow">点击显示新闻</a>
            </c:if>
            <div class="news-list-item">
                <c:forEach items="${requestScope.list}" var="news">
                    <div class="author-time">
                        <span>${news.getAuthor()}</span>  发表于<span>${news.getGetDate()}</span>
                    </div>
                    <div class="news-des">
                        <h3 class="news-title"><i></i><a href="#">【${news.getType()}】${news.getTitle()}</a></h3>
                        <div class="news-content-des">
                            <img src="${news.getImgPath()}">
                            <br>
                                ${news.getContent()}
                        </div>
                    </div>
                    <br>
                </c:forEach>
            </div>
        </div>

        <div class="news-list-left">
            <div class="about">
                <h4>${applicationScope.boardTitle}</h4>
                <div class="about-des">
                    <p>${applicationScope.boardContent}</p>
                </div>
            </div>
        </div>

        <footer class="copyright">
        </footer>
    </div>
</div>
</body>
</html>
