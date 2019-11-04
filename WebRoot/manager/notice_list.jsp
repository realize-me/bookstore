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
		<td>公告编号</td>
		<td>公告标题</td>
		<td>公告内容</td>
		<td>公告时间</td>
	</tr>
	<c:forEach items="${notices }" var="n">
		<tr>
			<td>${n.n_id }</td>
			<td>${n.title }</td>
			<td>${n.details }</td>
			<td>${n.n_time }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>