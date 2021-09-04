<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/6/19
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% session.invalidate();%>
<jsp:forward page="/index.jsp"></jsp:forward>
</body>
</html>
