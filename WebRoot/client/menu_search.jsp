<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- 传智书城菜单栏 -->
	<div id="divmenu">
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=文学">文学</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=生活">生活</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=计算机">计算机</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=外语">外语</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=经营">经管</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=励志">励志</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=社科">社科</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=学术">学术</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=少儿">少儿</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=艺术">艺术</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=原版">原版</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=科技">科技</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=考试">考试</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage?category=生活百科">生活百科</a>
		<a href="${pageContext.request.contextPath}/ShowProductByPage" style="color: #FFFF00">全部商品目录</a>
	</div>
	<!-- 传智书城搜索栏 -->
	<div id="divsearch">
		<form id="searchfrom" action="#">
			<table width="100%">
				<tr>
					<td style="text-align: right; padding-right: 220px;">
						Search
						<input type="text" name="textfield" class="inputtable" id="textfield" value="请输入书名" />
						<a href="#"><img src="/bookstore/client/images/serchbutton.gif" style="border: 0px;margin-top: -4px;" /></a>
					</td>
				</tr>
			</table>
		</form>
	</div>