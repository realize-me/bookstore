<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>传智书城首页</title>
	<link type="text/css" rel="stylesheet" href="css/main.css" />
	<link type="text/css" rel="stylesheet" href="css/autoplay.css" />
	<script type="text/javascript" src="js/autoplay.js"></script>
</head>
<body class="main">
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
	<div id="divcontent">
		<table width="900px" border="0" cellspacing="0">
			<tr>
			<td width="497">
				<img src="images/billboard.gif" width="497" height="38" />
				<table cellspacing="0" class="ctl">
					<tr>
						<td width="485" height="29" style="margin-left: 20px;">
							尊敬的用户，<br />
							&nbsp;&nbsp;&nbsp;&nbsp;为了让您有更好的用户体验，3月25日起，当日业务关小黑屋回炉升级！<br />
							&nbsp;&nbsp;&nbsp;&nbsp;具体开放时间请留意公告，感谢大家的支持与理解，祝大家购物愉快！<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							3月23日<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
							传智播客书城系统管理部<br />
						</td>
					</tr>
				</table>
			</td>
			<td style="padding-right: 5px 15px 10px 40px" />
				<table width="100%" border="0" cellspacing="0">
					<tr>
						<td>
							<img src="images/hottitle.gif" width="126" height="29" />
						</td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0">
					<tr>
						<td style="width: 80; text-align: center;">
							<a href="#"><img src="bookcover/105.jpg" width="102" height="130" border="0"></a>
						</td>
						<td style="width: 80; text-align: center;">
							<a href="#"><img src="bookcover/106.jpg" width="102" height="130" border="0"></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>	
		</table>
	</div>
	<!-- 传智书城底部 -->
<%@ include file="foot.jsp" %>
</body>
</html>