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
import cn.edu.sjzc.service.UserService;

public class OrderLoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService us = new UserService();
		User user = us.login(username, password);
		
		if (user==null){
			
			request.setAttribute("error", "用户名或者密码错误");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			
			RequestDispatcher rd = request.getRequestDispatcher("/client/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		HttpSession hs = request.getSession();
		hs.setAttribute("user", user);


		RequestDispatcher rd = request.getRequestDispatcher("/client/order.jsp");
		rd.forward(request, response);
		return;
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
