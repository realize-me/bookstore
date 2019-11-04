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
			<td>订单编号</td>
			<td>${orderBean.id}</td>
			<td>所属用户</td>
			<td>${orderBean.user.username }</td>
		</tr>
		<tr>
			<td>收件人</td>
			<td>${orderBean.receiverName }</td>
			<td>联系电话</td>
			<td>${orderBean.receiverPhone }</td>
		</tr>
		<tr>
			<td>收货地址</td>
			<td>${orderBean.receiverAddress }</td>
			<td>总价</td>
			<td>${orderBean.money }</tr>
		</tr>
		<tr>
			<td>下单时间</td>
			<td colspan="3">${orderBean.orderTime }</td>
		</tr>
		<tr>
			<td>商品信息</td>
			<td colspan="3">
				<table>
					<tr>
						<td>序号</td>
						<td>商品</td>
						<td>商品编号</td>
						<td>商品名称</td>
						<td>商品价格</td>
						<td>购买数量</td>
						<td>商品类别</td>
						<td>商品描述</td>
					</tr>
					<c:set var="count" value="1"></c:set>
					<c:forEach items="${orderBean.orderItemBeans }" var="item">
						<tr>
							<td>${count}</td>
							<td><img src="${item.product.imgurl}" width="200"></img></td>
							<td>${item.product.id }</td>
							<td>${item.product.name }</td>
							<td>${item.product.price }</td>
							<td>${item.buynum }</td>
							<td>${item.product.category }</td>
							<td>${item.product.description }</td>
						</tr>
						<c:set var="count" value="${count+1 }"></c:set>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>