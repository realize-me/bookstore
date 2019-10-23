package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjzc.domin.PageBean;
import cn.edu.sjzc.service.ProductService;

public class ShowProductByPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// 定义当前页码，默认页码为1
		int currentPage = 1;
		String _currentPage = request.getParameter("curentPage");
		
		if (_currentPage != null){
			currentPage = Integer.parseInt(_currentPage);
		}
		
		// 定义当前的显示的数量,默认为4
		int currentCount=4;
		String _currentCount = request.getParameter("currentCount");
		if (_currentCount != null){
			currentCount = Integer.parseInt(_currentCount);
		}
		
		// 当前要查找的分类,默认为全部商品
		String category = "全部商品";
		String _category = request.getParameter("category");
		if (_category!=null){
			category=_category;
		}
		
		// 调用service获取，查询当前页面所需要的书籍
		ProductService ps = new ProductService();
		PageBean pageBean = ps.findProductByPage(currentPage, currentCount, category);
		
		// 设置request的attribute
		request.setAttribute("pageBean", pageBean);
		
		// 转到分页后的商品列表页面
		RequestDispatcher rd = request.getRequestDispatcher("/client/product_list.jsp");
		rd.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
