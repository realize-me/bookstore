package cn.edu.sjzc.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjzc.domin.Order;
import cn.edu.sjzc.domin.OrderBean;
import cn.edu.sjzc.service.OrderService;

public class OrderListServlet extends HttpServlet {

	/**
	 * 查询所有的订单
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService os = new OrderService();
		List<OrderBean> orders = os.findAllOrder();
		
		request.setAttribute("orders", orders);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/order_list.jsp");
		
		rd.forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
