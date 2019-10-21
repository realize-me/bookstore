<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bookstore/client/css/main.css">
<script type="text/javascript">
		// 增加某个商品的数量
	function ChangeProductNum (id,count){
		window.location.href = "/bookstore/ChangeCartServlet?id="+id+"&count="+count;
	
	}


	function DeleteConfirm(){
   		 	return window.confirm("确认要删除吗");
	}
	


</script>
</head>
<body>
<%@ include file="head.jsp" %>
<%@ include file="menu_search.jsp" %>
<div align="center">
	<table width="1000" cellspacing="0">
		<tr>
			<td>
				<div style="text-align: right; margin: 5px 10px 5px 0px">
					<a href="${pageContext.request.contextPath}/client/index.jsp">首页</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;
					购物车
				</div>
				<table cellpadding="0" class="infocontent">
					<tr>
						<td style="text-align: center;">
							<img src="${pageContext.request.contextPath}/client/ad/page_ad.jpg" width="100%" height="89" />
							<table width="100%" border="0" cellpadding="0">
								<tr>
									<td>
										<img src="${pageContext.request.contextPath}/client/images/buy1.gif" width="635" height="38">
									</td>
								</tr>
								<tr>
									<td>
										<table cellpadding="1" class="carttable">
											<tr>
												<td width="10%">序号</td>
												<td width="30%">商品名称</td>
												<td width="10%">价格</td>
												<td width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量</td>
												<td width="10%">库存</td>
												<td width="10%">小计</td>
												<td width="10%">取消</td>
											</tr>
										</table>
										<c:set var="total" value="0"></c:set>
										<c:forEach items="${cart}" var="entry" varStatus="vs">
											<table width="100%" border="0" cellpadding="0">
												<tr>
													<td width="10%">${vs.count}</td>
													<td width="30%">${entry.key.name}</td>
													<td width="10%">${entry.key.price}</td>
													<td width="20%">
														<!-- 减少商品数量 -->
														<input type="button" value="-" style="width: 20%" onclick="ChangeProductNum(${entry.key.id},${entry.value}-1);"/>
														<!-- 商品数量显示 -->
														<input type="text" name="text" id="product_num" value="${entry.value}" style="width: 20%">
														<!-- 商品数量增加 -->
														<input type="button" value="+" style="width: 20%" onclick="ChangeProductNum(${entry.key.id},${entry.value+1});">
														<input type="text" id="key_id" style="display: none;" value="${entry.key.id}">
														<script type="text/javascript">
															// 添加事件监听器
																document.getElementById('product_num').addEventListener("keydown",function(event){
																	if (event.keyCode=='13'){
																		var input_text = document.getElementById('product_num');
																		count=input_text.value;
																		id = document.getElementById('key_id').value;
																		window.location.href = "/bookstore/ChangeCartServlet?id="+id+"&count="+count;
																	}
																	
																});
														</script>
													</td>
													<td width="10%">${entry.key.pnum}</td>
													<td width="10%">${entry.key.price*entry.value}</td>
													<td width="10%">
														<a href="${pageContext.request.contextPath}/ChangeCartServlet?id=${entry.key.id}&count=0" style="font-weight: bold;color:red" onclick="return DeleteConfirm();">X</a>
													</td>
												</tr>
											</table>
											<c:set value="${total+entry.key.price*entry.value}" var="total"></c:set>
										</c:forEach>
										<table cellspacing="1" class="carttable">
											<tr>
												<td style="text-align: right;padding-right: 40px;">
													<font style="color: #FF6600; font-weight: bold;">合计：&nbsp;&nbsp;&nbsp;${total}元</font>												
												</td>
											</tr>
										</table>
										
										<div style="text-align: right;margin-top: 10px;">
											<!-- 继续购物 -->
											<a href="/bookstore/showProductByPage">
												<img src="/bookstore/client/images/gwc_jx.gif" border="0" />
											</a>
											<!-- 结账 -->
											<a href="/bookstore/client/order.jsp">
												<img src="/bookstore/client/images/gwc_buy.gif" border="0" />
											</a>
										</div>
										
										
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>


			</td>
		</tr>
	</table>
</div>
</body>
</html>