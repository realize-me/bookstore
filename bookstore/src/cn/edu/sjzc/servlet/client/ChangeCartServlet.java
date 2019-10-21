package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.service.ProductService;
/**
 *	修改购物车中某个商品的数量
 *	modify the number of items in cart.
 * @author Lenovo
 *
 */
public class ChangeCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取商品的id
		String id = request.getParameter("id");
		// 获取商品将被设置的数量
		int count = Integer.parseInt(request.getParameter("count"));
		// 获取session对象
		HttpSession hs = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>)hs.getAttribute("cart");
		
		// 根据id获取这个商品
		ProductService ps = new ProductService();
		Product product = ps.findProductById(Integer.parseInt(id));
		
		if (cart!=null){
			// count不为0       说明要重新设置商品的数量
			if (count!=0) {
				cart.put(product, count);
			}else{
				// count为0   说明要删除这个商品
				cart.remove(product);
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/client/cart.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
