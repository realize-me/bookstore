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
import cn.edu.sjzc.service.OrderService;

public class FindOrderByCondition extends HttpServlet {
/*根据条件查询订单
 * (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			// 用户名 
			String username = request.getParameter("username");
			OrderService os = new OrderService();
			
			
			if (username !=null && !username.trim().equals("")){
				
				List<OrderBean> orders = os.findOrderByCondition(username);
				request.setAttribute("orders", orders);
				RequestDispatcher rd = request.getRequestDispatcher("/manager/order_list.jsp");
				rd.forward(request, response);
				return;
			}
			
			List<OrderBean> orders = os.findAllOrder();
			request.setAttribute("orders", orders);
			RequestDispatcher rd = request.getRequestDispatcher("/manager/order_list.jsp");
			rd.forward(request, response);
			return;
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
