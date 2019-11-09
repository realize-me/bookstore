<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<!--账户使用的菜单栏-->
		<div id="divsearch">
			<table style="padding-left: 320px;">
				<tr>
					<td style="padding-right:30px; font-size: 16px;"><a href="/bookstore/ShowMyAccount"
						class="menu_a" id="my_info">我的信息
							<div id="menu_child_parent">
								<div class="menu_child">
									<table align="center">
										<tr>
											<td style="font-size: 16px;"><a href="/bookstore/ShowMyAccount?type=modify" class="menu_a">修改信息</a>
											</td>
										</tr>
										<tr>
											<td style="font-size: 16px;"><a href="/bookstore/client/myaccount_modify_password.jsp" class="menu_a">修改密码</a>
											</td>
										</tr>
									</table>
								</div>
							</div> </a></td>

					<td style="padding-right:30px; font-size: 16px;"><a href="/bookstore/ShowMyOrderList"
						class="menu_a">我的订单</a>
					</td>
					<td style="padding-right:30px; font-size: 16px;"><a href="/bookstore/LogoutServlet"
						class="menu_a">退出登陆</a>
					</td>
				</tr>
			</table>
		</div>
