<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/bookstore/FindOrderByCondition" method="post" target="order_list">
	<table>
		<tr>
			<td>用户id</td>
			<td><input type="text" name="id"></td>
			<td><input type="submit" value="查询"></td>
		</tr>
	</table>	
</form>
</body>
</html>