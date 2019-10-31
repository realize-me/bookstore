<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td>
				<img src="${product.imgurl }" id="show_img" width="500" />

			</td>
			<td valign="top">
				<div>
					<table width="500">
						<tr>
							<td>商品id:</td>
							<td>${product.id}</td>
						</tr>
						<tr>
							<td>商品名称:</td>
							<td>${product.name }</td>
						</tr>
						<tr>
							<td>商品类别:</td>
							<td>${product.category }</td>
						</tr>
						<tr>
							<td>商品价格:</td>
							<td>${product.price }</td>
						</tr>
						<tr>
							<td>商品库存:</td>
							<td>${product.pnum }</td>
						</tr>
						<tr>
							<td>商品介绍:</td>
							<td>${product.description }</td>
						</tr>
					</table>
				</div>

			</td>
		</tr>
	</table>
</body>
</html>