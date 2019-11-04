<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table tr td{
		border: 1px solid;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td>商品id</td>
			<td>收件人</td>
			<td>地址</td>
			<td>联系电话</td>
			<td>总价</td>
			<td>所属用户id</td>
			<td>用户名</td>
			<td>订单状态</td>
			<td>查看</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${orders }" var="order">
			<tr>
				<td>${order.id }</td>
				<td>${order.receiverName }</td>
				<td>${order.receiverAddress }</td>
				<td>${order.receiverPhone }</td>
				<td>${order.money }</td>
				<td>${order.user_id }</td>
				<td>${order.user.username }</td>
				<td>${order.payState eq 0?"未支付":"已支付" }</td>
				<td><a href="/bookstore/FindOrderByIdServlet?id=${order.id }">查看</a></td>
				<td><a href="/bookstore/DeleteOrderServlet?id=${order.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>