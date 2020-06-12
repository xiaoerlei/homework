<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>员工信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="/js/index.js"></script>
		<link rel="stylesheet" href="/resource/css/index.css" />
		<link rel="stylesheet" href="/resource/css/search.css">
	</head>

	<body>
	<div class="content">
		<div id="wrap">
			<h1>
				欢迎 ${sessionScope.user.username}!
				<div id="container" class="search bar6">
					<form action="${pageContext.request.contextPath}/emp/search" method="get">
						<input type="text" placeholder="请查询内容" name="content">
						<button type="submit"></button>
					</form>
				</div>
			</h1>
				<div class="left_2">
				<table class="table">
					<tr class="table_header">
						<td>
							ID
						</td>
						<td>
							名字
						</td>
						<td>
							工资
						</td>
						<td>
							年龄
						</td>
						<td>
							操作
						</td>
					</tr>
					<c:forEach items="${sessionScope.emps}" var="emp">
						<tr class="row1">
							<td>
								${emp.id}
							</td>
							<td>
								${emp.name}
							</td>
							<td>
								${emp.salary}
							</td>
							<td>
								${emp.age}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/emp/delete?id=${emp.id}">删除信息</a>&nbsp;
								<a href="${pageContext.request.contextPath}/emp/findOne?id=${emp.id}">更改信息</a>
							</td>
						</tr>
					</c:forEach>
				</table>

				<div class="left_1">
					<input type="button" class="button" value="修改个人信息" onclick="location='${pageContext.request.contextPath}/resource/edit.jsp?user=${sessionScope.user}'"/>
					<input type="button" class="button" value="增加员工信息" onclick="location='${pageContext.request.contextPath}/resource/addEmp.jsp'"/>
					<input type="button" class="button" value="开始抽奖" onclick="location='${pageContext.request.contextPath}/lottery/loadLotteryData'"/>
				</div>
			</div>
		</div>
	</div>
	</body>
</html>
