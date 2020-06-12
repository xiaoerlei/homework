<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>员工信息更新</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="/js/index.js"></script>
		<link rel="stylesheet" href="/resource/css/index.css" />
	</head>

	<body>
		<div class="content">
			<h1>
				更改员工信息:
			</h1>
			<form action="${pageContext.request.contextPath}/emp/update?id=${sessionScope.emp.id}" method="post">
				<div>
					<td valign="middle" align="right">
						姓名:
					</td>
					<td valign="middle" align="left">
						<input type="text" name="name" value="${sessionScope.emp.name}"/>
					</td>
				</div>
				<div>
					<td valign="middle" align="right">
						工资:
					</td>
					<td valign="middle" align="left">
						<input type="text" name="salary" value="${sessionScope.emp.salary}"/>
					</td>
				</div>
				<div>
					<td valign="middle" align="right">
						年龄:
					</td>
					<td valign="middle" align="left">
						<input type="text" name="age" value="${sessionScope.emp.age}"/>
					</td>
				</div>
				<p>
					<input type="submit" class="button" value="确认" />
				</p>
			</form>
		</div>
	</body>
</html>
