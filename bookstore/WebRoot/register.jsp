<%@page import="cn.edu.sjzc.RegisterFormBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		td{
			text-align:right;
		}

	</style>
</head>

<body>
	<form action="/chapter11/servlet/ControllerServlet" method="post">
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value="${formBean.username }" /></td>
				<td><span>${errorMap.username}</span></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password1" value="${formBean.password1 }" /></td>
				<td><span>${errorMap.password1}</span></td>
			</tr>
			<tr>
				<td>再次填写密码：</td>
				<td><input type="password" name="password2" value="${formBean.password2 }"></td>
				<td><span>${errorMap.password2}</span></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email" value="${formBean.email }"></td>
				<td><span>${errorMap.email}</span></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="注册">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>