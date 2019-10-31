package cn.edu.sjzc.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.service.ProductService;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService ps = new ProductService();
		List<Product> products = ps.findProductAll();
		
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/product_list.jsp");
		rd.forward(request, response);

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
