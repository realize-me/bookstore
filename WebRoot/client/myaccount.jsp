<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的账户</title>
<link type="text/css" rel="stylesheet" href="/bookstore/client/css/main.css" />
<link type="text/css" rel="stylesheet" href="/bookstore/client/css/myaccount.css" />

</head>
<body>
	<div style="width: 1500px;margin:0 auto;">
		<!-- 传智书城顶部 -->
		<%@ include file="head.jsp"%>

		<!--账户使用的菜单栏-->
		<%@ include file="myaccount_menu.jsp" %>
		

		 	<!-- 我的账户 -->
		<div id="divcontent" align="center">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px;">
						<h1>我的账户</h1>
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align: right; width: 20%">会员邮箱：</td>
								<td style="width: 40">${user.email}</td>

							</tr>
							<tr>
								<td style="text-align: right;">会员名：</td>
								<td>${user.username}</td>

							</tr>

							<tr>
								<td style="text-align: right;">性别：</td>
								<td colspan="2">${user.gender}</td>
							</tr>
							<tr>
								<td style="text-align: right;">联系电话：</td>
								<td colspan="2">${user.telephone}</td>
							</tr>
							<tr>
								<td style="text-align: right;">个人介绍：</td>
								<td colspan="2">${user.introduce}</td>
							</tr>
						</table>

				</tr>
			</table>
			</div>

		
	</div>
</body>
</html>