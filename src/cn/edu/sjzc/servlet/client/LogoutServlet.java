package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.sjzc.domin.User;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		hs.removeAttribute("user");
		
		// 取消cookie
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			if (cookie.getName().equals("password")){
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		response.sendRedirect("/bookstore/client/login.jsp");

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
