<%@page  contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>员工管理系统登录界面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="resource/css/styles.css">
	</head>

	<body>
		<div class="form-wrapper">
			<div class="header">
				登录界面
			</div>

			<form action="/user/login" class="input-wrapper" id="login" method="post">
				<div class="border-wrapper">
					<input type="text" name="username" placeholder="用户名" class="border-item">
				</div>
				<div class="border-wrapper">
					<input type="password" name="password" placeholder="密码" class="border-item">
				</div>
			</form>

			<div class="action">
				<div class="btn" onclick="document.getElementById('login').submit()">登陆</div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="btn" onclick="location.href='${pageContext.request.contextPath}/resource/register.jsp'">注册</div>
			</div>

			<div>
				<br/>
				<a href="${pageContext.request.contextPath}/resource/findPassword.jsp">忘记密码</a>
			</div>

		</div>
	</body>
</html>
