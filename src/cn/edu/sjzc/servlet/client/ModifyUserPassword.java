package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.sjzc.domin.User;
import cn.edu.sjzc.service.UserService;

public class ModifyUserPassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String new_password2 = request.getParameter("new_password2");
		
		if (!new_password.equals(new_password2)){
			request.setAttribute("new_password2Msg", "两次输入密码不一样");
			request.setAttribute("current_password", current_password);
			request.setAttribute("new_password", new_password);
			request.setAttribute("new_password2", new_password2);
			

			request.getRequestDispatcher("/client/myaccount_modify_password.jsp").forward(request, response);
			return;
		}
		

		
		// 检验密码是否正确
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
		
		if (!user.getPassword().equals(current_password)){
			request.setAttribute("current_passwordMsg", "当前密码有误");
			request.setAttribute("current_password", current_password);
			request.setAttribute("new_password", new_password);
			request.setAttribute("new_password2", new_password2);
			

			request.getRequestDispatcher("/client/myaccount_modify_password.jsp").forward(request, response);
			return;
		}
		
		
		// 更新数据库中的用户密码
		UserService us = new UserService();
		us.updateUserPasswordById(user.getId(), new_password);
		
		// 更新httpsession中的user的密码 
		user = (User) hs.getAttribute("user");
		user.setPassword(new_password);
		
		request.getRequestDispatcher("/ShowMyAccount").forward(request, response);
		return;
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
