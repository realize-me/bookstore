<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的账户</title>
</head>
<body>
	<div style="width: 1500px;margin:0 auto;">
<!-- 传智书城顶部 -->
<%@ include file="head.jsp" %>
	<!-- 传智书城菜单栏 -->
<%@ include file="menu_search.jsp" %>
 <!-- 我的账户 -->
 <div id="divcontent" align="center">
 	
 		<table width="850px" border="0" cellspacing="0">
 			<tr>
 				<td style="padding:30px;">
 					<h1>我的账户</h1>
 					<table width="70%" border="0" cellspacing="2" class="upline">
 						<tr>
 							<td style="text-align: right; width: 20%">会员邮箱：</td>
 							<td style="width: 40">
 								<input type="text" class="textinput" id="email" name="email" value="${formBean.email}" />
 							</td>
 							<td colspan="2"><span id="emailMsg">${errors.emailMsg}</span><font color="#999999">请输入有效的邮箱地址</font></td>
 						</tr>
 						<tr>
 							<td style="text-align: right;">会员名：</td>
 							<td>
 								<input type="text" class="textinput" name="username" id="username" value="${formBean.username}" />
 							</td>
 							<td><span id="usernameMsg">${errors.usernameMsg}</span><font color="#999999">字母数字下划线1到10位，不能是数字开头</font></td>

 						</tr>
 						<tr>
 							<td style="text-align: right;">密码：</td>
 							<td>
 								<input type="password" class="textinput" id="password" name="password" value="${formBean.password}" />
 							</td>
 							<td><span id="passwordMsg">${errors.passwordMsg}</span><font color="#999999999">密码设置6-19个字符</font></td>
 						</tr>
 						 <tr>
 							<td style="text-align: right;">重复密码：</td>
 							<td>
 								<input type="password" class="textinput" id="password2" name="password2" value="${formBean.password2}" />
 							</td>
 							<td><span id="confirmMsg">${errors.password2Msg}</span><font color="#999999999"></font>&nbsp;</td>
 						</tr>
 						<tr>
 							<td style="text-align: right;">性别：</td>

	
 							<td colspan="2">&nbsp;&nbsp; <input type="radio" name="gender" value="男" checked="${formBean.gender=='男'?'checked':'' }"/>男
 								&nbsp;&nbsp; &nbsp;&nbsp; <input type="radio" name="gender" value="女" checked="${formBean.gender=='女'?'checked':'' }"/>女

 								<span id="genderMsg">  ${errors.genderMsg}</span>
 							</td>
 						</tr>
 						<tr>
 							<td style="text-align: right;">联系电话：</td>
 							<td colspan="2">
 								<input type="text" name="telephone" class="textinput" style="width: 168px;" value="${formBean.telephone}" />
 								<span id="telephoneMsg">${errors.telephoneMsg}</span>
 							</td>
 						</tr>
 						<tr>
 							<td style="text-align: right;">个人介绍：</td>
 							<td colspan="2">
 								<textarea class="textarea" name="introduce"></textarea>
 							</td>
 						</tr>
 					</table>
 					<table width="100%">
 						<tr>
 							<td style="padding-top: 20px;text-align: center;">
 								<input type="image" src="/bookstore/client/images/signup.gif" />
 							</td>
 						</tr>
 					</table>
 				</td>
 			</tr>
 		</table>

 </div>
</div>
</body>
</html>