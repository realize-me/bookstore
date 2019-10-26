<%@page import="cn.edu.sjzc.domin.SearchPageBean"%>
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
			textfield = bookname.value;	
			pageSize = pageSize.value;

			window.location.href = "http://localhost:8080/bookstore/MenuSearchServlet?currentPage="+pageIndex+"&textfield="+textfield+"&currentCount="+pageSize;	
		}
	}

</script>


</head>
<body>
<%@ include file="head.jsp" %>
<%@ include file="menu_search.jsp" %>
<div align="center">
<%
	SearchPageBean searchPageBean = (SearchPageBean)request.getAttribute("searchPageBean");
	long totalNum = searchPageBean.getTotalNum();
	long pageSize = searchPageBean.getPageSize();
	
	
	long max_current = totalNum/pageSize;
	
	if (totalNum%pageSize>0){
		max_current++;
	}
	
	
	long pageIndex = searchPageBean.getPageIndex();
	String textfield = searchPageBean.getName();
	
 %>

	<table width="1000" cellspacing="0">
		<tr>
			<td>
				<table cellpadding="0" class="infocontent">
					<tr>
						<td>
							
	
									

									
								
									<c:forEach items="${searchPageBean.products}" var="product">

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
										<input type="hidden" id="bookname" value="<%= textfield %>" />
									</div>


									<!-- 如果商品数量为0则不显示页码 -->
									
									<c:choose>
										<c:when test="<%=totalNum>0 %>">
											<div align="center">
												<!-- 上一页 -->
												<a href="/bookstore/MenuSearchServlet?currentPage=<%=pageIndex==1?1:pageIndex-1 %>&textfield=<%=textfield!=null?textfield:""%>">上一页</a>
												
												<!-- 第1页 -->
												<c:if test="<%=pageIndex!=1 %>">
													<a href="/bookstore/MenuSearchServlet?currentPage=1&textfield=<%=textfield!=null?textfield:""%>">1</a>
												</c:if>
												
		
												<!-- 当前页 -->
												<font color="red"><%=pageIndex %></font>
												
												<!-- 尾页 -->
												<c:if test="<%=pageIndex!=max_current %>">
													<a href="/bookstore/MenuSearchServlet?currentPage=<%=max_current %>&textfield=<%=textfield!=null?textfield:""%>"><%=max_current %></a>
												</c:if>
												
												<!-- 下一页 -->
												<a href="/bookstore/MenuSearchServlet?currentPage=<%=pageIndex==max_current?max_current:pageIndex+1 %>&textfield=<%=textfield!=null?textfield:""%>">下一页</a>
												
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;到
													<input type="text" id="goToPageIndex" style="width: 20px"/>	
												页，
												<!--添加回车事件监听器-->
												<script type="text/javascript">
													goToPageIndex.addEventListener(
													    "keydown",
													    function(event){
													        if (event.keyCode=='13'){
													          jumpPage();  
													        } 
													    }
													);

												</script>
		
												<button onclick="jumpPage();">确定</button>
												
												<p>共查到<%=totalNum %>条数据，共<%=max_current %>页</p>
												<p>您搜索的关键字为<font color="red"><%=textfield%></font></p>
												
											</div>
										
										</c:when>
										<c:otherwise>
											<div align="center">
												<p>这里空空如也</p>
												<p>您搜索的关键字为<font color="red"><%=textfield%></font></p>
											</div>
										</c:otherwise>
									</c:choose>
									
										
									
							
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