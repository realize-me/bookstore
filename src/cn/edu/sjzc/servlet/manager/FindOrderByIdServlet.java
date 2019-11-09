package cn.edu.sjzc.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjzc.domin.OrderBean;
import cn.edu.sjzc.domin.OrderItemBean;
import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.service.OrderService;

public class FindOrderByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		
		OrderService os = new OrderService();
		OrderBean orderBean = os.findOrderBeanById(id);
		
		request.setAttribute("orderBean", orderBean);

		// 客户查看自己的订单
		if (type!=null){
			RequestDispatcher rd = request.getRequestDispatcher("/client/myaccount_order.jsp");
			rd.forward(request, response);
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/manager/order_view.jsp");
		rd.forward(request, response);
		return;
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		this.doGet(request, response);
	}

}
