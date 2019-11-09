<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>传智书城购物车</title>
<link rel="stylesheet" type="text/css" href="/bookstore/client/css/main.css">
<script type="text/javascript">
			// 增加某个商品的数量
	function ChangeProductNum (id,count,max){
		
		if (parseInt(count)>parseInt(max)){

			window.alert('受库存限制，无法增加数量');


		}else if (parseInt(count)<1){

			window.alert('无法减小数量');
		
		}else{
			window.location.href = "/bookstore/ChangeCartServlet?id="+id+"&count="+count;
		}
		
	}
	function DeleteConfirm(){
   		 	return window.confirm("确认要删除吗");
	}

</script>
</head>
<body>
<div style="width: 1500px;margin:0 auto;">
<%@ include file="head.jsp" %>
<%@ include file="menu_search.jsp" %>

<%
	HttpSession hs = request.getSession();
	Map<String,Integer> cart = (Map<String,Integer>)hs.getAttribute("cart");

 %>

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
										
										<c:choose>
											<c:when test="<%=cart!=null && !cart.isEmpty() %>">
												<c:set var="total" value="0"></c:set>
												<c:forEach items="${cart}" var="entry" varStatus="vs">
													<table width="100%" border="0" cellpadding="0">
														<tr>
															<td width="10%">${vs.count}</td>
															<td width="30%">${entry.key.name}</td>
															<td width="10%">${entry.key.price}</td>
															<td width="20%">
																<!-- 减少商品数量 -->
																<input type="button" value="-" style="width: 20%" onclick="ChangeProductNum('${entry.key.id}',${entry.value}-1,${entry.key.pnum });" />
																<!-- 商品数量显示 -->
																<input type="text" name="text" id="product_num_${entry.key.id}" value="${entry.value}" style="width: 20%">
																<!--隐藏的数量，如果输入数量错误，则用隐藏变量使其恢复-->
																<input type="hidden" id="text_backup_${entry.key.id}" value="${entry.value}" />


																<!-- 商品数量增加 -->
																<input type="button" value="+" style="width: 20%" onclick="ChangeProductNum('${entry.key.id}',${entry.value+1},${entry.key.pnum });" />
															
																
																
																
																<script type="text/javascript">
																	// 给输入框添加回车事件监听器
																		document.getElementById('product_num_${entry.key.id}').addEventListener("keydown",function(event){
																			if (event.keyCode=='13'){
																				var input_text = document.getElementById('product_num_${entry.key.id}');
																				count=input_text.value;
																				max_count = "${entry.key.pnum}";
																				

																				if (isNaN(parseInt(count))){
																					window.alert('输入有误');

																					//恢复数据
																					document.getElementById('product_num_${entry.key.id}').value=document.getElementById('text_backup_${entry.key.id}').value;
																				}else if (parseInt(count)>parseInt(max_count)){
																				
																					window.alert('输入数量大于库存量');
																					
																					// 恢复数据
																					document.getElementById('product_num_${entry.key.id}').value=document.getElementById('text_backup_${entry.key.id}').value;
																					
																				}else if (parseInt(count)<1) {
																					window.alert('输入数量不能为0或者负数');
																					
																					// 恢复数据
																					document.getElementById('product_num_${entry.key.id}').value=document.getElementById('text_backup_${entry.key.id}').value;
																				}else{
																					id = "${entry.key.id}";
																					window.location.href = "/bookstore/ChangeCartServlet?id="+id+"&count="+parseInt(count);	
																				}

																				
																			};
																			
																		});
																</script>
															</td>
															<!--库存-->
															<td width="10%">${entry.key.pnum}</td>
															<td width="10%">${entry.key.price*entry.value}</td>
															<td width="10%">
																<a href="${pageContext.request.contextPath}/ChangeCartServlet?id=${entry.key.id}&count=0" style="font-weight: bold;color:red" onclick="return DeleteConfirm();">X</a>
															</td>
														</tr>
													</table>
													<c:set value="${total+entry.key.price*entry.value}" var="total"></c:set>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<div align="center">
													<p>购物车中还未添加商品</p>
												</div>
											</c:otherwise>
										</c:choose>
										
										<table cellspacing="1" class="carttable">
											<tr>
												<td style="text-align: right;padding-right: 40px;">
													<font style="color: #FF6600; font-weight: bold;">合计：&nbsp;&nbsp;&nbsp;${total!=null?total:"0"}元</font>												
												</td>
											</tr>
										</table>
										
										<div style="text-align: right;margin-top: 10px;">
											<!-- 继续购物 -->
											<a href="/bookstore/ShowProductByPage">
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
</div>
</body>
</html>