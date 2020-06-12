<%@page  contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">>
	<head>
		<title>用户信息修改</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/styles.css">
	</head>
	<body>
		<div class="form-wrapper">
			<div class="header">
				用户信息修改界面
			</div>

			<form action="/user/edit?id=${sessionScope.user.id}" class="input-wrapper" id="editUser" method="post">
				<div class="border-wrapper">
					&nbsp;姓&nbsp;名&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="username" placeholder="请输入昵称" class="border-item" th:field="*{username}">
				</div>
				<div class="border-wrapper">
					&nbsp;昵&nbsp;称&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="nickname" placeholder="请输入姓名" class="border-item" th:field="*{nickname}">
				</div>
				<div class="border-wrapper">
					&nbsp;密&nbsp;码&nbsp;&nbsp;&nbsp;&nbsp;
					<%--<td valign="middle" align="right">密码:</td>--%>
					<input type="password" name="password" placeholder="请输入密码" class="border-item" th:field="*{password}">
				</div>
				<div class="border-wrapper">
					&nbsp;手&nbsp;机&nbsp;号&nbsp;
					<input type="text" name="tel" placeholder="请输入手机号" class="border-item" th:field="*{tel}"/>
				</div>
				<div>
					性别:
					<div>
						男<input type="radio" name="sex" value="男" checked="checked"/>
						女<input type="radio" name="sex" value="女"/>
					</div>
				</div>
			</form>

			<div class="action">
				<div class="btn" onclick="document.getElementById('editUser').submit()">提交</div>
			</div>
		</div>

	</body>
</html>
