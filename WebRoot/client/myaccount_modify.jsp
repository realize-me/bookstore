<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改我的信息</title>
<link type="text/css" rel="stylesheet" href="/bookstore/client/css/main.css" />
<link type="text/css" rel="stylesheet" href="/bookstore/client/css/myaccount.css" />
</head>
<body>
<div style="width: 1500px;margin:0 auto;">
		<!-- 传智书城顶部 -->
		<%@ include file="head.jsp"%>

		<!--账户使用的菜单栏-->
		<%@ include file="myaccount_menu.jsp" %>
		

		 	<!-- 修改我的信息 -->
		<div id="divcontent" align="center">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px;">
						<h1>修改我的账户信息</h1>
								<form action="/bookstore/ModifyUserServlet" method="post">
								<table width="70%" border="0" cellspacing="2" class="upline">
									<tr>
										<td colspan="3"><input type="hidden" name="id" value="${user.id }"></td>
									</tr>
									<tr>
										<td style="text-align: right; width: 20%">会员邮箱：</td>
										<td style="width: 40">
											<input type="text" name="email" value="${user.email}">
											<span><font color="red">${errors.emailMsg }</font></span>	
										</td>
										
									</tr>
									<tr>
										<td style="text-align: right;">会员名：</td>
										<td>
											<input type="text" name="username" value="${user.username}">
											<span><font color="red">${errors.usernameMsg }</font></span>
										</td>
										
									</tr>
		
									<tr>
										<td style="text-align: right;">性别：</td>
										<td colspan="2">&nbsp;&nbsp; <input type="radio" name="gender" value="男" checked="${user.gender=='男'?'checked':'' }"/>男
		 								&nbsp;&nbsp; &nbsp;&nbsp; <input type="radio" name="gender" value="女" checked="${user.gender=='女'?'checked':'' }"/>女
										<span><font color="red">${errors.genderMsg }</font></span>
										</td>
										
									</tr>
									<tr>
										<td style="text-align: right;">联系电话：</td>
										<td>
											<input type="text" name="telephone" value="${user.telephone}">
											<span><font color="red">${errors.telephoneMsg }</font></span>
										</td>
										
									</tr>
									<tr>
										<td style="text-align: right;">个人介绍：</td>
										<td colspan="2"><textarea name="introduce">${user.introduce}</textarea></td>
									</tr>
								</table>
								<table width="100%">
									<tr>
										<td style="padding-top: 20px;text-align: center;"><input
											type="image" src="/bookstore/client/images/botton_gif_025.gif" /></td>
									</tr>
								</table>
								</form>
						
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>