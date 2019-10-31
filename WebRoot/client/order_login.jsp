<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bookstore/client/css/main.css" />
<link rel="stylesheet" type="text/css" href="/bookstore/client/css/login.css" />

</head>
<body>
	<div style="width: 1500px;margin:0 auto;">
<!-- 传智书城顶部 -->
<%@ include file="head.jsp" %>
	<!-- 传智书城菜单栏 -->
<%@ include file="menu_search.jsp" %>
<div id="divlogin">
<div id="inner" width="1000">
			<div id="inner_form">
			<form action="/bookstore/OrderLoginServlet" method="post">

						<table id="input_table">
							<tr>
								<td class="textname">用户名:</td>
								<td><input type="text" name="username" class="textinput" value="${username}" /></td>
							</tr>
							<tr>
								<td class="textname">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
								<td><input type="password" name="password" class="textinput" value="${password}" /></td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: center;">
									<input type="checkbox" name="checkbox" value="checkbox01" />记住用户名
									<input type="checkbox" name="checkbox" value="checkbox02" />自动登陆
								</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: center;">
									<input type="image" name="imageButton" src="/bookstore/client/images/loginbutton.gif" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<img src="/bookstore/client/images/loginline.gif" />
								</td>
							</tr>
							<tr>
								<td colspan="2"><span><font color="red">${error}</font></span></td>
							</tr>
						</table>
	
			<div style="clear:both"></div>
			</form>
			</div>
			<div style="clear:both"></div>
</div>
<div style="clear:both"></div>
</div>
</div>
</body>
</html>