<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet"
	href="/bookstore/client/css/main.css" />
<title>修改我的密码</title>

<link type="text/css" rel="stylesheet"
	href="/bookstore/client/css/myaccount.css" />
</head>
<body>
	<div style="width: 1500px;margin:0 auto;">
		<!-- 传智书城顶部 -->
		<%@ include file="head.jsp"%>

		<!--账户使用的菜单栏-->
		<%@ include file="myaccount_menu.jsp"%>


		<!-- 修改密码 -->
		<div id="divcontent" align="center">
			<form action="/bookstore/ModifyUserPassword" method="post">
				<table width="850px" border="0" cellspacing="0">
					<tr>
						<td style="padding:30px;">
							<h1>修改密码</h1>
							<table width="70%" border="0" cellspacing="2" class="upline">
								<tr>
									<td style="text-align: right; width: 20%">当前密码：</td>
									<td><input type="password"
										name="current_password" value=${current_password }>
										<span><font color="red">${current_passwordMsg }</font></span>
									</td>
								</tr>
								<tr>
									<td style="text-align: right;">新密码：</td>
									<td><input type="password" name="new_password"
										value=${new_password }>
										<span><font color="red">${new_passwordMsg }</font></span>
									</td>
								</tr>

								<tr>
									<td style="text-align: right;">重复新密码：</td>
									<td colspan="2"><input type="password" name="new_password2"
										value="${new_password2 }">
										<span><font color="red">${new_password2Msg }</font></span>
									</td>

								</tr>
							</table>
							<table width="100%">
								<tr>
									<td style="padding-top: 20px;text-align: center;"><input
										type="image" src="/bookstore/client/images/botton_gif_025.gif" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>


	</div>
</body>
</html>