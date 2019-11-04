<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>传智书城首页</title>
	<link type="text/css" rel="stylesheet" href="css/main.css" />
	<link type="text/css" rel="stylesheet" href="css/autoplay.css" />
	<script type="text/javascript" src="js/autoplay.js"></script>
</head>
<body class="main">
<div style="width: 1500px;margin:0 auto;">
<!-- 传智书城顶部 -->
<%@ include file="head.jsp" %>
	<!-- 传智书城菜单栏 -->
<%@ include file="menu_search.jsp" %>
	<!-- 传智书城轮播图片 -->
	<div id="box_autoplay">
		<div class="list">
			<ul>
				<li><img src="ad/index_ad0.jpg" width="900" height="335" /></li>
				<li><img src="ad/index_ad1.jpg" width="900" height="335" /></li>
				<li><img src="ad/index_ad2.jpg" width="900" height="335" /></li>
				<li><img src="ad/index_ad3.jpg" width="900" height="335" /></li>
			</ul>
		</div>
	</div>
	<!-- 公告和本周热卖 -->
<jsp:include page="/GetAnnounce"></jsp:include>
	<!-- 传智书城底部 -->
<%@ include file="foot.jsp" %>
</div>
</body>
</html>