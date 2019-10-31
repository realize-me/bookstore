package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.service.ProductService;

public class FindProductById extends HttpServlet {

	/**
	 * 用于显示和修改商品信息
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		ProductService ps = new ProductService();
		Product p = ps.findProductById(id);
		
		request.setAttribute("product", p);
		if (type==null){
			RequestDispatcher rd = request.getRequestDispatcher("/client/info.jsp");
			rd.forward(request, response);
			return ;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/manager/product_edit.jsp");
		rd.forward(request, response);
		return;
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
