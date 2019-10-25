<%@page import="cn.edu.sjzc.domin.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bookstore/client/css/main.css" />
<script type="text/javascript">
	function jumpPage(){

		pageIndex = goToPageIndex.value;

		if ( isNaN(parseInt(pageIndex)) || parseInt(pageIndex)>parseInt(maxIndex.value) || parseInt(pageIndex)<1){
			window.alert("页码不正确");
		}else{
			category = category.value;	
			pageSize = pageSize.value;

			window.location.href = "http://localhost:8080/bookstore/ShowProductByPage?currentPage="+pageIndex+"&category="+category+"&currentCount="+pageSize;	
		}
		
	}

</script>


</head>
<body>
<%@ include file="head.jsp" %>
<%@ include file="menu_search.jsp" %>
<div align="center">
<%
	PageBean pageBean = (PageBean)request.getAttribute("pageBean");
	long totalNum = pageBean.getTotalNum();
	long pageSize = pageBean.getPageSize();
	
	
	long max_current = totalNum/pageSize;
	
	if (totalNum%pageSize>0){
		max_current++;
	}
	
	
	long pageIndex = pageBean.getPageIndex();
	String category = pageBean.getCategory();
	
 %>

	<table width="1000" cellspacing="0">
		<tr>
			<td>
				<table cellpadding="0" class="infocontent">
					<tr>
						<td>
							
	
									

									
								
									<c:forEach items="${pageBean.products}" var="product">

											<table align="center">
												<tr>
													<td rowspan="7">
														<img src="/bookstore/client/bookcover/101.jpg" />
													</td>
												</tr>
												<tr>
													<td>书名：</td>
													<td>${product.name}</td>
												</tr>
												<tr>
													<td>价格：</td>
													<td>${product.price}</td>
												</tr>
												<tr>
													<td>分类：</td>
													<td>${product.category}</td>
												</tr>
												<tr>
													<td>库存：</td>
													<td>${product.pnum}</td>
												</tr>
												<tr>
													<td>描述：</td>
													<td>${product.description}</td>
												</tr>
												<tr>
													<td colspan="2">
														<a href="/bookstore/AddCartServlet?id=${product.id}">加入购物车</a>
													</td>
												</tr>
											</table>
											<hr />
									</c:forEach>									
									
									<!-- 隐藏数据 -->
									<div>
										<input type="hidden" id="pageIndex" value="<%= pageIndex %>" />
										<input type="hidden" id="pageSize" value="<%= pageSize %>" />
										<input type="hidden" id="maxIndex" value="<%= max_current %>" />
										<input type="hidden" id="category" value="<%= category %>" />
									</div>



									<div align="center">
										<!-- 上一页 -->
										<a href="/bookstore/ShowProductByPage?currentPage=<%=pageIndex==1?1:pageIndex-1 %>&category=<%=category!=null?category:""%>">上一页</a>
										
										<!-- 第1页 -->
										<c:if test="<%=pageIndex!=1 %>">
											<a href="/bookstore/ShowProductByPage?currentPage=1&category=<%=category!=null?category:""%>">1</a>
										</c:if>
										

										<!-- 当前页 -->
										<font color="red"><%=pageIndex %></font>
										
										<!-- 尾页 -->
										<c:if test="<%=pageIndex!=max_current %>">
											<a href="/bookstore/ShowProductByPage?currentPage=<%=max_current %>&category=<%=category!=null?category:""%>"><%=max_current %></a>
										</c:if>
										
										<!-- 下一页 -->
										<a href="/bookstore/ShowProductByPage?currentPage=<%=pageIndex==max_current?max_current:pageIndex+1 %>&category=<%=category!=null?category:""%>">下一页</a>
										
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;到<input type="text" id="goToPageIndex" style="width: 20px"/>页，
										

										<button onclick="jumpPage();">确定</button>
										
										<p>共查到<%=totalNum %>条数据，共<%=max_current %>页</p>
										
									</div>
															
							
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</div>

<%@ include file="foot.jsp" %>
</body>
</html>