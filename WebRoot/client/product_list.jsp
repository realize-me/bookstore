<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
							


								<c:forEach items="${pageBean.products}" var="product">
									<table>
										<tr>
											<td>${product.name}</td>
											<td>${product.price}</td>
											<td>${product.category}</td>
											<td>${product.pnum}</td>
											<td>${product.description}</td>
										</tr>
									</table>
								</c:forEach>

						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</div>
</body>
</html>