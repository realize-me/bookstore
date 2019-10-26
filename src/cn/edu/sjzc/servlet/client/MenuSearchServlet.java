package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjzc.domin.SearchPageBean;
import cn.edu.sjzc.service.ProductService;

public class MenuSearchServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String searchField = request.getParameter("textfield");
		
		
		int currentPage = 1;
		String _currentPage = request.getParameter("currentPage");
		if (_currentPage!=null){
			currentPage = Integer.parseInt(_currentPage);
		}
		
		int currentCount = 4;
		String _currentCount = request.getParameter("currentCount");
		if(_currentCount!=null){
			currentCount=Integer.parseInt(_currentCount);
		}
		ProductService ps = new ProductService();
		
		SearchPageBean spb = ps.findProductByName(currentPage, currentCount, searchField);
		
		request.setAttribute("searchPageBean", spb);
		RequestDispatcher rd = request.getRequestDispatcher("/client/product_list_search.jsp");
		rd.forward(request, response);
		
		
		
	}

}
