package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.sjzc.domin.Order;
import cn.edu.sjzc.domin.User;
import cn.edu.sjzc.service.OrderService;


public class ShowMyOrderList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
		
		// 用户未登陆
		if (user==null){
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
		
		
		
		OrderService os = new OrderService();
		List<Order> orders = os.findOrderByUserId(user.getId());
		
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/client/myaccount_order_list.jsp").forward(request, response);	
		return;
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
