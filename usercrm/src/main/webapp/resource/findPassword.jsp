<%@page  contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>找回密码</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/resource/css/styles.css">
</head>

<body>
<div class="form-wrapper">
    <div class="header">
        找回密码界面
    </div>

    <form action="/user/findPassword" class="input-wrapper" id="findPsd" method="post">
        <div class="border-wrapper">
            &nbsp;手&nbsp;机&nbsp;号&nbsp;
            <input type="text" name="tel" placeholder="请输入手机号" class="border-item" th:field="*{tel}"/>
        </div>
        <div class="border-wrapper">
            &nbsp;密&nbsp;码&nbsp;&nbsp;&nbsp;&nbsp;
            <%--<td valign="middle" align="right">密码:</td>--%>
            <input type="password" name="password" placeholder="请输入密码" class="border-item" th:field="*{password}">
        </div>
        <div class="border-wrapper">
            &nbsp;验&nbsp;证&nbsp;码&nbsp;
            <input type="text" name="code" placeholder="请输入验证码" class="border-item"/>
        </div>
        <div>
            <div valign="middle" align="left">
                验证码:
                <img id="num" src="${pageContext.request.contextPath}/user/getImage" />
                <a href="javascript:;" onclick="document.getElementById('num').src = '${pageContext.request.contextPath}/user/getImage?'+(new Date()).getTime()">换一张</a>
            </div>
        </div>
        <%--<button type="submit">提交</button>--%>
    </form>

    <div class="action">
        <div class="btn" onclick="document.getElementById('findPsd').submit()">提交</div>
    </div>

</div>
</body>
</html>
