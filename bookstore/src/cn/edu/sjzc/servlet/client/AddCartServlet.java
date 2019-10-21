package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.service.ProductService;

public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取商品id
		String id = request.getParameter("id");
		
		// 根据商品id查询商品
		ProductService ps = new ProductService();
		Product product = ps.findProductById(Integer.parseInt(id));
		
		// 获取session对象
		HttpSession hs = request.getSession();
		
		Map<Product, Integer> cart = (Map<Product, Integer>)hs.getAttribute("cart");
		
		if (cart == null){
			cart = new HashMap<Product, Integer>();
		}
		
		Integer count = cart.put(product, 1);
		
		if (count!=null){
			cart.put(product, count+1);
		}
		hs.setAttribute("cart", cart);
		
		RequestDispatcher rd = request.getRequestDispatcher("/client/cart.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
