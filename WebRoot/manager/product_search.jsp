<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/bookstore/FindProductByCondition" method="post" target="product_list">
	<table width="100%">
		<tr>
			<td>
					<table>
						<tr>
							<td>商品编号</td>
							<td><input type="text" name="id"></td>
						</tr>
						<tr>
							<td>商品名称</td>
							<td><input type="text" name="name"></td>
						</tr>
					</table>
			</td>
			<td>
					<table>
						<tr>
							<td>类别</td>
							<td><input type="text" name="category"></td>
						</tr>
						<tr>
							<td>价格区间</td>
							<td>
								<input type="text" name="minprice">-
								<input type="text" name="maxprice">
							</td>
						</tr>
					</table>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="查询">
				<input type="reset" name="重置">
				<a href="product_add.jsp" target="product_list"><input type="button" value="添加"></a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>