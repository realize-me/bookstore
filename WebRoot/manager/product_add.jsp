<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/bookstore/AddProductServlet" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>库存量</td>
				<td><input type="text" name="pnum"></td>
			</tr>
			<tr>
				<td>商品类别</td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<td>上传图片</td>
				<td><input type="file" name="myfile"></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="添加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>