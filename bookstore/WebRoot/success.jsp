<%@page import="cn.edu.sjzc.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">success</h2>
<hr/>
<% UserBean userBean = (UserBean)request.getAttribute("userBean"); %>
<% String username = userBean.getUsername(); %>
<% String password = userBean.getPassword(); %>
<% String email = userBean.getEmail(); %>

<table>
	<tr>
		<td colspan="2">用户信息</td>
	</tr>
	<tr>
		<td>用户名：</td>
		<td><%=username %></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><%=password %></td>
	</tr>
	<tr>
		<td>邮箱:</td>
		<td><%=email %></td>
	</tr>
</table>
</body>
</html>