<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function () {
	    $("#upload_img").change(function () {
	        var $file = $(this);
	        var fileObj = $file[0];
	        var windowURL = window.URL || window.webkitURL;
	        var dataURL;
	        var $img = $("#show_img");

	        if (fileObj && fileObj.files && fileObj.files[0]) {
	            dataURL = windowURL.createObjectURL(fileObj.files[0]);
	            $img.attr('src', dataURL);
	        } else {
	            dataURL = $file.val();
	            var imgObj = document.getElementById("show_img");
	            // 两个坑:
	            // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
	            // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
	            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

	        }
	    });
	});
</script>
</head>
<body>
<form action="/bookstore/EditProductServlet" method="post" enctype="multipart/form-data">

	<table>
		<tr>
			<td>
				<img src="${product.imgurl }" id="show_img" width="500" />
				<!--没更新图片时用这个值更新数据库-->
				<input type="hidden" name="imgurl" value="${product.imgurl }">
			</td>
			<td valign="top">
				<div>
					<table width="500">
						<tr>
							<td>商品id:</td>
							<td><input type="hidden" name="id" value="${product.id}">${product.id}</td>
						</tr>
						<tr>
							<td>商品名称:</td>
							<td><input type="text" name="name" value="${product.name }"></td>
						</tr>
						<tr>
							<td>商品类别:</td>
							<td><input type="text" name="category" value="${product.category }"></td>
						</tr>
						<tr>
							<td>商品价格:</td>
							<td><input type="text" name="price" value="${product.price }"></td>
						</tr>
						<tr>
							<td>商品库存:</td>
							<td><input type="text" name="pnum" value="${product.pnum }"></td>
						</tr>
						<tr>
							<td>商品介绍:</td>
							<td><input type="text" name="description" value="${product.description }"></td>
						</tr>
						<tr>
							<td>更换图片:</td>
							<td><input type="file" name="myfile" id="upload_img"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="保存" />
							</td>
						</tr>
					</table>
				</div>

			</td>
		</tr>
	</table>
</form>
</body>
</html>