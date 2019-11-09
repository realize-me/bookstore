package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.sjzc.domin.User;
import cn.edu.sjzc.service.UserService;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 重复登陆
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
		if (user!=null){
			// 已经登陆
			request.setAttribute("error", "您已登录，请不要重复登陆");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			RequestDispatcher rd = request.getRequestDispatcher("/client/login.jsp");
			rd.forward(request, response);
			return;
			
		}
		

		
		// 检验密码
		UserService us = new UserService();
		user = us.login(username, password);
		
		if (user==null){
			
			request.setAttribute("error", "用户名或者密码错误");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			
			RequestDispatcher rd = request.getRequestDispatcher("/client/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		// 记住用户名和自动登陆
		String[] checkbox = request.getParameterValues("checkbox");
		Cookie cookie1 = new Cookie("username", username);
		Cookie cookie2 = new Cookie("password", password);
		if (checkbox!=null){
			for(String chek:checkbox){
				
				if (chek.equals("checkbox01")){
				//  记住用户名
					cookie1.setMaxAge(999999999);
					response.addCookie(cookie1);
					
				}else if(chek.equals("checkbox02")){
					// 自动登陆
					cookie1.setMaxAge(999999999);
					cookie2.setMaxAge(999999999);
					response.addCookie(cookie1);
					response.addCookie(cookie2);
				}
				
			}
		}else{
			// 清除cookie
			cookie1.setMaxAge(0);
			cookie2.setMaxAge(0);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}
		
		
		
		
		// 用户名和密码正确转到主页
		hs.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/client/index.jsp");
		rd.forward(request, response);
		return;
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
