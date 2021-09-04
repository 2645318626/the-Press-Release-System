<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<img src="static/img/index/bg.jpg" style="position: absolute;z-index:-1;width: 100%">
<head>
    <title>更多新闻就在这里！</title>
    <%@include file="/pages/common/head.jsp" %>
    <link rel="stylesheet" href="static/css/text/style_1_common.css"
          type="text/css">
    <link rel="stylesheet"
          href="static/css/text/style_1_forum_index.css"
          type="text/css">
</head>
<body>
<%@include file="/pages/common/body.jsp" %>
<div class="container">
    <h1></h1>
    <h4></h4>
    <div class="news-list">
        <%--       大图 --%>
        <div class="area" id="diy_chart">
            <div id="frame648i8N" class="frame move-span cl frame-1-3">
                <div id="frame648i8N_left" class="column frame-1-3-l">
                    <div id="portal_block_1106" class="block move-span">
                        <div id="portal_block_1106_content" class="dxb_bc" style="position: relative;">
                            <div class="module cl slidebox" id="0.8774978489999203" style="display: block;">
                                <ul class="slideshow">
                                    <li style="height: 225px; display: block;"><a
                                            href="index.jsp"><img
                                            src="static/img/images/index.jpg"
                                            width="auto" height="225"></a><span class="title">更多新闻【预告，敬请期待】</span></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <%--            中--%>
                <div id="frame648i8N_center" class="column frame-1-3-r">
                    <div id="frameIUI5Gh" class="frame move-span cl frame-3-1">
                        <div id="frameIUI5Gh_left" class="column frame-3-1-l">
                            <div id="frameIUI5Gh_left_temp" class="move-span temp"></div>
                            <div id="frameLbN73m" class="frame move-span cl frame-1-1-1">
                                <div id="frameLbN73m_left" class="column frame-1-1-1-l">
                                    <div id="frameLbN73m_left_temp" class="move-span temp"></div>
                                    <div id="portal_block_1108" class="block move-span">
                                        <%--                                要闻板块--%>
                                        <div class="blocktitle title"><span class="titletext">要闻</span></div>
                                        <div id="portal_block_1108_content" class="dxb_bc">
                                            <div class="module cl xl xl1">
                                                <ul>
                                                    <c:forEach var="news"
                                                               items="${applicationScope.keyWordsList1}" begin="0"
                                                               end="9">
                                                        <li>
                                                            <a href="newsServlet?action=detailNews&id=${news.getId()}"
                                                               title="${news.getTitle()}"
                                                               target="_blank">${news.getTitle()}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%--                                最新发表 --%>
                                <div id="frameLbN73m_center" class="column frame-1-1-1-c">
                                    <div id="frameLbN73m_center_temp" class="move-span temp"></div>
                                    <div id="portal_block_1109" class="block move-span">
                                        <div class="blocktitle title"><span class="titletext">最新发表</span></div>
                                        <div id="portal_block_1109_content" class="dxb_bc">
                                            <div class="module cl xl xl1">
                                                <ul>
                                                    <c:forEach var="news" items="${applicationScope.keyWordsList2}"
                                                               begin="0" end="9"
                                                               varStatus="status">
                                                        <li>
                                                            <a href="newsServlet?action=detailNews&id=${news.getId()}"
                                                               title="${news.getTitle()}"
                                                               target="_blank">${news.getTitle()}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%--                                热点追踪--%>
                                <div id="frameLbN73m_right" class="column frame-1-1-1-r">
                                    <div id="frameLbN73m_right_temp" class="move-span temp"></div>
                                    <div id="portal_block_1110" class="block move-span">
                                        <div class="blocktitle title"><span class="titletext">热点追踪</span></div>
                                        <div id="portal_block_1110_content" class="dxb_bc">
                                            <div class="module cl xl xl1">
                                                <ul>
                                                    <c:forEach var="news"
                                                               items="${applicationScope.keyWordsList3}" begin="0"
                                                               end="9">
                                                        <li>
                                                            <a href="newsServlet?action=detailNews&id=${news.getId()}"
                                                               title="${news.getTitle()}"
                                                               target="_blank">${news.getTitle()}</a>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--                        国际--%>
                        <div id="frameIUI5Gh_center" class="column frame-3-1-r">
                            <div id="frameIUI5Gh_center_temp" class="move-span temp"></div>
                            <div id="tab35v6d9" class=" frame-tab move-span cl">
                                <div id="tab35v6d9_title" class="tab-title title column cl" switchtype="click">
                                    <ul class="tb cl">
                                        <li id="portal_block_1111" class="a">国际
                                        </li>
                                    </ul>
                                </div>
                                <div id="tab35v6d9_content" class="tb-c">
                                    <div id="portal_block_1111_content" class="dxb_bc" style="">
                                        <div class="module cl xl xl1">
                                            <ol>
                                                <c:forEach var="news" items="${applicationScope.keyWordsList4}"
                                                           begin="0"
                                                           end="9" varStatus="status">
                                                    <li>
                                                        <img class="vm" src="${news.getImgPath()}"
                                                             width="16" height="16" alt="${news.getTitle()}"
                                                             style="width: 16px;height: 16px;"><a
                                                            href="newsServlet?action=detailNews&id=${status.index+1}'"
                                                            target="_blank"
                                                            title="${news.getTitle()}">${status.index+1}.标题：${news.getTitle()}</a>
                                                    </li>
                                                </c:forEach>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--                            <script type="text/javascript">initTab("tab35v6d9", "click");</script>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%--关键词分类--%>
    <div class="mn">
        <div class="fl bm">
            <div class="bm bmw flg cl">
                <div class="bm_h cl">
    <span class="o">
    </span>
                    <h2>
                        <a href="#">分类</a></h2>
                </div>
                <div id="category_27" class="bm_c" style="">
                    <table cellspacing="0" cellpadding="0" class="fl_tb">
                        <tbody>
                        <tr>
                            <c:forEach items="${applicationScope.categoryList}" var="news" varStatus="status">
                            <c:if test="${(status.index+1)mod 3 != 1}">
                            <td class="fl_g" width="32.9%">
                                <dl style="margin-left: 64px;">
                                    <dt>
                                        <a href="newsServlet?action=keyShow&key=${news.getType()}">
                                                ${news.getType()}</a></dt>
                                </dl>
                            </td>
                            </c:if>
                            <c:if test="${(status.index+1)mod 3 == 1}">
                        <tr class="fl_row">
                            <td class="fl_g" width="32.9%">
                                <dl style="margin-left: 64px;">
                                    <dt>
                                        <a href="newsServlet?action=keyShow&key=${news.getType()}">
                                                ${news.getType()}</a></dt>
                                </dl>
                            </td>
                            </c:if>
                            </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="bm bmw flg cl">
                <div class="bm_h cl">
                    <h2>
                        <a href="https://localhost:7780newsServlet?action=keyWords&keyWords=国内"
                           style="">国内</a></h2>
                </div>
                <div id="category_28" class="bm_c" style="">
                    <table cellspacing="0" cellpadding="0" class="fl_tb">
                        <tbody>
                        <tr>
                            <c:forEach items="${applicationScope.keyWordsList5}" var="news" varStatus="status">
                            <c:if test="${(status.index+1)mod 3 != 1}">
                            <td class="fl_g" width="32.9%">
                                <dl style="margin-left: 64px;">
                                    <dt>
                                        <div class="fl_icn_g" style="width: 64px;">
                                            <a href="newsServlet?action=detailNews&id=${news.getId()}"><img
                                                    src="${news.getImgPath()}" align="left"
                                                    alt="${news.getType()}" style="width: 64px;height: 64px;"></a></div>
                                        <a href="newsServlet?action=detailNews&id=${news.getId()}">
                                                ${news.getTitle()}</a></dt>
                                    <dd>
                                        <span title="更新时间">最后发表:${news.getGetDate()}&nbsp;</span>
                                    </dd>
                                </dl>
                            </td>
                            </c:if>
                            <c:if test="${(status.index+1)mod 3 == 1}">
                        <tr class="fl_row">
                            <td class="fl_g" width="32.9%">
                                <dl style="margin-left: 64px;">
                                    <dt>
                                        <div class="fl_icn_g" style="width: 64px;">
                                            <a href="newsServlet?action=detailNews&id=${news.getId()}"><img
                                                    src="${news.getImgPath()}" align="left"
                                                    alt="${news.getType()}" style="width: 64px;height: 64px;"></a></div>
                                        <a href="newsServlet?action=detailNews&id=${news.getId()}">
                                                ${news.getTitle()}</a></dt>
                                    <dd>
                                        <span title="更新时间">最后发表:${news.getGetDate()}&nbsp;</span>
                                    </dd>
                                </dl>
                            </td>
                            </c:if>
                            </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>

        <div id="online" class="bm oll">
            <div class="bm_h">
            </div>
        </div>

    </div>
    <footer class="copyright">
    </footer>
</div>
</body>
</html>

