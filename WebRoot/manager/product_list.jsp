<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品数量</td>
			<td>商品类别</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price }</td>
				<td>${p.pnum }</td>
				<td>${p.category }</td>
				<td>
					<a href="/bookstore/FindProductById?id=${p.id}&type=admin">编辑</a>
				</td>
				<td>
					<a href="/bookstore/DeleteProductServlet?id=${p.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>