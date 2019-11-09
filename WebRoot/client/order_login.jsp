<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请先登陆</title>
<link rel="stylesheet" type="text/css"
	href="/bookstore/client/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="/bookstore/client/css/login.css" />
<link rel="stylesheet" type="text/css"
	href="/bookstore/client/css/autoplay.css" />
<script type="text/javascript" src="/bookstore/client/js/autoplay.js"></script>
<script type="text/javascript">
	
	window.onload = function (){
		setTimeout('autosubmit()',3000); 
	};
	
	
	function autosubmit(){
		password = document.getElementsByName('password')[0].value;
		if (password!=""){
			loginform.submit();
		}
	}

</script>
<style type="text/css">
	body {
		background-color:#efefef;
	}
	#box_autoplay{
		left: -204px;
		margin: 40px auto;
	}
	#divfoot{
		position: relative;
	}
}
</style>

</head>
<body>
	<div style="width: 1500px;margin:0 auto;">
		<!-- 顶部 -->
		<%@ include file="head.jsp" %>
		<!-- 用户登陆 -->
		<div id="divsearch">
			<table style="padding-left: 320px;">
				<tr>
					<td style="padding-right:30px; font-size: 16px;">
						用户登陆
					</td>
				</tr>
			</table>
		</div>
				<!-- 传智书城轮播图片 -->
				<div id="box_autoplay">
					<div class="list">
						<ul>
							<li><img src="/bookstore/client/ad/index_ad0.jpg" width="900" height="335" /></li>
							<li><img src="/bookstore/client/ad/index_ad1.jpg" width="900" height="335" /></li>
							<li><img src="/bookstore/client/ad/index_ad2.jpg" width="900" height="335" /></li>
							<li><img src="/bookstore/client/ad/index_ad3.jpg" width="900" height="335" /></li>
						</ul>
					</div>
				</div>


		<!-- 登陆部分 -->
<%
	Cookie[] cookies = request.getCookies();
	String username = "";
	String password = "";
	for (Cookie cookie:cookies){
		if (cookie.getName().equals("username")){
			username = cookie.getValue();
		}else if (cookie.getName().equals("password")){
			password = cookie.getValue();
		}
	}
	
 %>
<c:set var="username" value="<%=username %>"></c:set>
<c:set var="password" value="<%=password %>"></c:set>

											<div id="inner_form">
												<form action="/bookstore/OrderLoginServlet" method="post" id="loginform">

													<table id="input_table">
														<tr>
															<td class="textname">用户名:</td>
															<td><input type="text" name="username" class="textinput"
																value="${username}" />
															</td>
														</tr>
														<tr>
															<td class="textname">密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
															<td><input type="password" name="password"
																class="textinput" value="${password}" />
															</td>
														</tr>
														<tr>
															<td colspan="2" style="text-align: center;"><input
																type="checkbox" name="checkbox" value="checkbox01" <%= username==""?"":"checked='checked'" %>/>记住用户名 <input
																type="checkbox" name="checkbox" value="checkbox02" <%= password==""?"":"checked='checked'" %>/>自动登陆</td>
														</tr>
														<tr>
															<td colspan="2" style="text-align: center;"><input
																type="image" name="imageButton"
																src="/bookstore/client/images/loginbutton.gif" /></td>
														</tr>
														<tr>
															<td colspan="2"><img
																src="/bookstore/client/images/loginline.gif" /></td>
														</tr>
														<tr>
															<td colspan="2"><span><font color="red">${error}</font>
															</span>
															</td>
														</tr>
													</table>

													<div style="clear:both"></div>
												</form>
											</div>
											
			<!-- 底部 -->
			<%@ include file="foot.jsp" %>
			<div style="clear: both;"></div>
	</div>
</body>
</html>