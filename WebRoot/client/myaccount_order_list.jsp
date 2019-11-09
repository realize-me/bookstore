<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单列表</title>
<link type="text/css" rel="stylesheet" href="/bookstore/client/css/main.css" />
<link type="text/css" rel="stylesheet" href="/bookstore/client/css/myaccount.css" />
<style type="text/css">
	.headline{
		text-align: center;
		background-color: #f59f1d;
		color:#fcfdef;
	}
	
	.colorline{
		background-color: #eaeaea;
	}
	.lookline:HOVER .lookcell{
		display:block;
	}
	.lookcell{
		display: none;
	}
	.lookline:HOVER td{
		background-color: #cccccc !important;
	}
}
}
}
	
</style>
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
						<h1>我的订单</h1>
						<table align="center" width="100%">
							<tr>
								<td width="20%"  class="headline">收货地址</td>
								<td width="15%"  class="headline">收件人</td>
								<td width="15%" class="headline">手机号</td>
								<td width="20%" class="headline">订单创建时间</td>
								<td width="10%" class="headline">总金额</td>
								<td width="10%" class="headline">支付状态</td>
								<td width="10%" class="headline">查看订单详情</td>
							</tr>
						<c:set var="count" value="1"></c:set>
						<c:forEach items="${orders }" var="order">
							<c:choose>
								<c:when test="${count%2==1 }">
									<tr class="lookline">
										<td width="20%"  style="text-align: center;">${order.receiverAddress }</td>
										<td width="15%" style="text-align: center;">${order.receiverName }</td>
										<td width="15%" style="text-align: center;">${order.receiverPhone }</td>
										<td width="20%" style="text-align: center;">${order.orderTime }</td>
										<td width="10%" style="text-align: center;">${order.money }</td>
										<td width="10%" style="text-align: center;">${order.payState==0?'未支付':'已支付' }</td>
										<td width="10%" style="text-align: center;" ><a class="lookcell" href="/bookstore/FindOrderByIdServlet?id=${order.id }&type=client">查看</a></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr class="lookline">
										<td width="20%"  style="text-align: center;" class="colorline">${order.receiverAddress }</td>
										<td width="15%" style="text-align: center;" class="colorline">${order.receiverName }</td>
										<td width="15%" style="text-align: center;" class="colorline">${order.receiverPhone }</td>
										<td width="20%" style="text-align: center;" class="colorline">${order.orderTime }</td>
										<td width="10%" style="text-align: center;" class="colorline">${order.money }</td>
										<td width="10%" style="text-align: center;" class="colorline">${order.payState==0?'未支付':'已支付' }</td>
										<td width="10%" style="text-align: center;" class="colorline"><a class="lookcell" href="/bookstore/FindOrderByIdServlet?id=${order.id }&type=client">查看</a></td>
									</tr>
								</c:otherwise>
							</c:choose>
							<c:set var="count" value="${count+1 }"></c:set>
						</c:forEach>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>