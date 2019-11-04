<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.parent.notice_list.location.reload();
</script>
</head>
<body>
<form action="/bookstore/ModifyNoticeServlet" method="post" target="notice_view">

	
<table>
		<tr>
			<td colspan="5"><input type="hidden" name="n_id" value="${notice.n_id }"></td>
		</tr>
		<tr>
			<td>标题</td>
			<td><input type="text" name="title" value="${notice.title }"></td>
			
			<td>时间</td>
			<td><input type="text" name="n_time" value="${notice.n_time}"></td>
			<td><input type="submit" value="保存"></td>
		</tr>
		<tr>
			<td>内容</td>
			<td colspan="4"><textarea name="details" style="width: 500px;height: 100px;">${notice.details}</textarea></td>
		</tr>

	</table>
	
	
</form>
</body>
</html>