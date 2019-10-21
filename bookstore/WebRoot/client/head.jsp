<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--传智书城顶部-->
	<div id="divhead">
		<table cellspacing="0" class="headtable">
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/client/index.jsp"><img src="/bookstore/client/images/logo.png" /></a>
				</td>
				<td>
					<a href="#"><img src="/bookstore/client/images/cart.gif"></a>
					|<a href="/bookstore/client/cart.jsp">购物车</a>
					|<a href="#">帮助中心</a>
					|<a href="#">我的账户</a>
					|<a href="${pageContext.request.contextPath}/client/register.jsp">新账户注册</a>
				</td>
			</tr>
		</table>
	</div>