<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>
    <script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
    <link rel="stylesheet" href="/resource/css/index.css" />
</head>
<body>
<div class="content">
    <div class="center_div">
        <div class="reward_area">
            <p class="title_text">抽奖系统</p>
            <hr>
            <p><span><input name="rewardType" type="radio" value="5">&nbsp;&nbsp;特等奖</span></p>
            <p><span><input name="rewardType" type="radio" value="4">&nbsp;&nbsp;一等奖</span></p>
            <p><span><input name="rewardType" type="radio" value="3">&nbsp;&nbsp;二等奖</span></p>
            <p><span><input name="rewardType" type="radio" value="2">&nbsp;&nbsp;三等奖</span></p>
            <p><span><input name="rewardType" checked type="radio" value="1">&nbsp;&nbsp;幸运奖</span></p>
            <img id="gold1" src="/resource/img/gold1.png">
            <img id="gold2" src="/resource/img/gold2.png">
        </div>
    </div>

    <div class="center_div">
        <div class="reward_go_area">
            <img height="85%" src="/resource/img/reward_img.png">
            <p id="button_p">
                <input type="button" value="抽奖" id="go">
            <h1 id="name_h1"></h1>
            </p>
        </div>
    </div>

    <div class="right_div">
        <p class="title_text">获奖名单</p>
        <a id="empty">(清空数据)</a>
        <hr>
        <div id="div_rewardList">
            <div class="rewardList" id="rewardType5">
                <h>特等奖<span class="person_num"></span></h>
                <div>
                    <c:forEach items="${requestScope.lotteryList}" var="lottery">
                        <c:if test="${lottery.rewardType == 5}">
                            ${lottery.name}
                        </c:if>
                    </c:forEach>
                    <%--<span class="person" th:each="lottery:${lotteryList}" th:if="${lottery.rewardType} eq 5" th:text="${lottery.name}"></span>--%>
                </div>
            </div>
            <div class="rewardList" id="rewardType4">
                <h>一等奖<span class="person_num"></span></h>
                <div>
                    <c:forEach items="${requestScope.lotteryList}" var="lottery">
                        <c:if test="${lottery.rewardType == 4}">
                            ${lottery.name}
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <div class="rewardList" id="rewardType3">
                <h>二等奖<span class="person_num"></span></h>
                <div>
                    <c:forEach items="${requestScope.lotteryList}" var="lottery">
                        <c:if test="${lottery.rewardType == 3}">
                            ${lottery.name}
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <div class="rewardList" id="rewardType2">
                <h>三等奖<span class="person_num"></span></h>
                <div>
                    <c:forEach items="${requestScope.lotteryList}" var="lottery">
                        <c:if test="${lottery.rewardType == 2}">
                            ${lottery.name}
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <div class="rewardList" id="rewardType1">
                <h>幸运奖<span class="person_num"></span></h>
                <div>
                    <c:forEach items="${requestScope.lotteryList}" var="lottery">
                        <c:if test="${lottery.rewardType == 1}">
                            ${lottery.name}
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
        <img id="gold3" src="/resource/img/gold3.png">
    </div>
</div>
</body>
</html>