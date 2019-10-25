<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/bookstore/client/css/main.css" />
</head>
<body>
<%@ include file="head.jsp" %>
<%@ include file="menu_search.jsp" %>
<div align="center">
	<table width="1000" cellspacing="0">
		<tr>
			<td>
				<table cellpadding="0" class="infocontent">
					<tr>
						<td>
							
	
									

									
							<pg:pager url="/bookstore/ShowProductByPage" items="${pageBean.totalNum}" maxItems="4" maxIndexPages="5" export="currentPageNumber=pageNumber">
									<c:forEach items="${pageBean.products}" var="product">
										<pg:item>
											<table>
												<tr>
													<td>${product.name}</td>
													<td>${product.price}</td>
													<td>${product.category}</td>
													<td>${product.pnum}</td>
													<td>${product.description}</td>
												</tr>
											</table>
										</pg:item>
									</c:forEach>									

									
									
								<pg:param name="currentPage" />
								<pg:param name="currentCount" />
								
	

									<pg:first><a href="${pageUrl }">首页</a></pg:first>
									<pg:prev><a href="${pageUrl }">上一页</a></pg:prev>
									<pg:pages>
										<c:choose>
											<c:when test="${currentPage eq pageNumber}">
												<font color="red">${pageNumber}</font>
											</c:when>
											<c:otherwise>
												<a href="${pageUrl}">${pageNumber }</a>
											</c:otherwise>
											
										</c:choose>
									</pg:pages>					
									<pg:next><a href="${pageUrl }">下一页</a></pg:next>
									<pg:last><a href="${pageUrl }">尾页</a></pg:last>

								
								
								
							</pg:pager>
															
							
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</div>
</body>
</html>