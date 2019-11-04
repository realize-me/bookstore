package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.sjzc.domin.Order;
import cn.edu.sjzc.domin.OrderItem;
import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.domin.User;
import cn.edu.sjzc.service.OrderService;
import cn.edu.sjzc.utils.IdUtils;

public class CreateOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 获取订单的钱数、收货地址、收货人电话、收货人姓名
//		String money = request.getParameter("money");
//		String receiverAddress = request.getParameter("receiveAddress");
//		String receiverPhone = request.getParameter("receiverPhone");
//		String receiverName = request.getParameter("receiverName");
//		
		Order order = new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession hs = request.getSession();
		
		// 获取当前用户身份
		Map<Product, Integer> cart = (Map<Product, Integer>) hs.getAttribute("cart");
		User user = (User) hs.getAttribute("user");

		// 设置订单编号和下单的用户的id
		order.setId(IdUtils.getUUID());
		order.setUser_id(user.getId());
		
		
		// 设置订单中的商品信息（商品的编号，商品的数量）
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(Product p:cart.keySet()){
			
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder_id(order.getId());
			orderItem.setProduct_id(p.getId());
			orderItem.setBuynum(cart.get(p));
			
			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		
		
		// 将订单添加到数据库
		OrderService os = new OrderService();
		os.addOrder(order);
		
		// 定向到创建订单成功页面
		RequestDispatcher rd = request.getRequestDispatcher("/client/createOrderSuccess.jsp");
		rd.forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
