<%@page  contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>员工信息增加页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/index.css" />
	</head>

	<body>
		<div class="content">
			<h1>
				增加员工信息:
			</h1>
			<div action="${pageContext.request.contextPath}/emp/save" method="post">
				<div>
					<tr>
						<td valign="middle" align="right">
							名字:
						</td>
						<td valign="middle" align="left">
							<input type="text" name="name" />
						</td>
					</tr>
				</div>
				<div>
					<tr>
						<td valign="middle" align="right">
							工资:
						</td>
						<td valign="middle" align="left">
							<input type="text" name="salary" />
						</td>
					</tr>
				</div>
				<div>
					<tr>
						<td valign="middle" align="right">
							年龄:
						</td>
						<td valign="middle" align="left">
							<input type="text" name="age" />
						</td>
					</tr>
				</div>
				<p>
					<input type="submit" class="button" value="确认" />
				</p>
			</div>
		</div>
	</body>
</html>
