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

public class FindProductByCondition extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String minprice = request.getParameter("minprice");
		String maxprice = request.getParameter("maxprice");
		
		ProductService ps = new ProductService();
		List<Product> products = ps.findProductByCondition(id, name, category, minprice, maxprice);
		
		request.setAttribute("products", products);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/product_list.jsp");
		rd.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
