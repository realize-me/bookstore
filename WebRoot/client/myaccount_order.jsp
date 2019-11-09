<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
<link type="text/css" rel="stylesheet" href="/bookstore/client/css/main.css" />
<link type="text/css" rel="stylesheet" href="/bookstore/client/css/myaccount.css" />
<style type="text/css">
	
	.headline{
		background-color: #b4d76d;
		color: #ffffff;
	}
	.contentline{
		background-color: #979191;
		color: #ffffff;
	}
	.tableproduct{
		width: 100%;
		border: ridge;
		border-collapse:collapse;
	}
	.productheadline{
		background-color: #b4d76d;
	}
	.productline{
		border-bottom:1px dotted #5e880a;
		
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
						<h1>我的订单详情</h1>
										<table width="100%">
											<tr>
												<td width="10%" class="headline">订单编号</td>
												<td width="40%" class="contentline">${orderBean.id}</td>
												<td width="10%" class="headline">所属用户</td>
												<td width="40%" class="contentline">${orderBean.user.username }</td>
											</tr>
											<tr>
												<td width="10%" class="headline">收件人</td>
												<td width="40%" class="contentline">${orderBean.receiverName }</td>
												<td width="10%" class="headline">联系电话</td>
												<td width="40%" class="contentline">${orderBean.receiverPhone }</td>
											</tr>
											<tr>
												<td width="10%" class="headline">收货地址</td>
												<td width="40%" class="contentline">${orderBean.receiverAddress }</td>
												<td width="10%" class="headline">总价</td>
												<td width="40%" class="contentline">${orderBean.money }
											</tr>
											<tr>
												<td width="10%" class="headline">下单时间</td>
												<td colspan="3" width="90%" class="contentline">${orderBean.orderTime }</td>
											</tr>
											<tr>
												<td width="10%" class="headline">商品信息</td>
												<td colspan="3"  width="90%">
													<table class="tableproduct">
														<tr class="productheadline">
															<td style="text-align: center;">序号</td>
															<td style="text-align: center;">商品</td>
															<td style="text-align: center;">编号</td>
															<td style="text-align: center;">名称</td>
															<td style="text-align: center;">价格</td>
															<td style="text-align: center;">数量</td>
															<td style="text-align: center;">类别</td>
															<td style="text-align: center;">描述</td>
														</tr>
														<c:set var="count" value="1"></c:set>
														<c:forEach items="${orderBean.orderItemBeans }" var="item">
															<tr class="productline">
																<td style="vertical-align:middle;text-align: center;">${count}</td>
																<td style="vertical-align:middle;text-align: center;"><img src="${item.product.imgurl}" width="200"></img></td>
																<td style="vertical-align:middle;text-align: center;">${item.product.id }</td>
																<td style="vertical-align:middle;text-align: center;">${item.product.name }</td>
																<td style="vertical-align:middle;text-align: center;">${item.product.price }</td>
																<td style="vertical-align:middle;text-align: center;">${item.buynum }</td>
																<td style="vertical-align:middle;text-align: center;">${item.product.category }</td>
																<td style="vertical-align:middle;text-align: center;">${item.product.description }</td>
															</tr>
															<c:set var="count" value="${count+1 }"></c:set>
														</c:forEach>
													</table>
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