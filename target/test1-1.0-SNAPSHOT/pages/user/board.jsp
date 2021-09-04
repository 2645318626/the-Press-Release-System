<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 15312
  Date: 2021/7/2
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<img src="static/img/index/bg.jpg" style="position: absolute;z-index:-1;width: 100%">
<head>
    <title>公告栏</title>
    <%@include file="/pages/common/head.jsp"%>
    <link rel="stylesheet" href="static/css/style_1_common.css">
    <link rel="stylesheet" href="static/css/style_1_forum_guide.css">
    <style>
        #entry{
            margin-bottom: 14px;
        }
        #threadlist{
            width: 1230px;
            position: relative;
            text-align: center;
            top: 86px;
            left: 404px;
        }
        #title{
            width: 169px;
            text-align: center;
        }
        .common{
            width: 190px;
        }
    </style>
</head>
<body>
<%@include file="/pages/common/body.jsp"%>
<div id="threadlist" class="tl bm bmw">
    <div class="th">
        <table cellspacing="0" cellpadding="0">
            <tbody>
            <tr>
                <th colspan="2" id="title">
                    标题
                </th>
                <td class="by" id="group" style="text-align: center">版块/群组</td>
                <td class="by" id="time" style="text-align: center">最后发表</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="bm_c">
        <table cellspacing="0" cellpadding="0">
            <c:forEach items="${applicationScope.boardList}" varStatus="status" var="boadrs">
                <tbody id="normalthread_197409">
                <tr>
                    <td class="icn">
                        <a href="newsServlet?action=editBoard&dom=showBoardById&id=${boadrs.getId()}" title="新窗口打开">
                            ${status.index+1}
                        </a>
                    </td>
                    <th class="common">
                        <a href="newsServlet?action=editBoard&dom=showBoardById&id=${boadrs.getId()}"
                           class="xst">${boadrs.getTitle()}</a>&nbsp;
                    </th>
                    <td class="by"><a href="newsServlet?action=editBoard&dom=showBoardByGroup&type=${boadrs.getGroup()}">${boadrs.getGroup()}</a></td>
                    <td class="by">
                        <em>${boadrs.getDetailTime()}</em>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
