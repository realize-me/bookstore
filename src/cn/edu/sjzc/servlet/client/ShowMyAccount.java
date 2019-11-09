package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.sjzc.domin.User;

public class ShowMyAccount extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户
		HttpSession hs = request.getSession();
		
		User user = (User) hs.getAttribute("user");
		
		// 未登陆
		if (user==null){
			RequestDispatcher rd = request.getRequestDispatcher("/client/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		// 是否为修改信息
		String type = request.getParameter("type");
		
		// 显示信息
		if(type==null){
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/client/myaccount.jsp");
			rd.forward(request, response);
			return;
		}
		
		// 修改信息
		if (type!=null){
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/client/myaccount_modify.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/client/login.jsp");
		rd.forward(request, response);
		return;
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
