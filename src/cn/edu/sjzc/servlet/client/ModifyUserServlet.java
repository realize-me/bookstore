package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.sjzc.dao.UserDao;
import cn.edu.sjzc.domin.UpdateUserBean;
import cn.edu.sjzc.domin.User;
import cn.edu.sjzc.service.UserService;

public class ModifyUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UpdateUserBean uub = new UpdateUserBean();
		HttpSession hs = request.getSession();
		User user = (User) hs.getAttribute("user");
		
		
		try {
			BeanUtils.populate(uub, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!uub.checkForm(user.getUsername())){
			
			Map<String, String> errors = uub.getErrors();
			
			request.setAttribute("errors", errors);
			request.setAttribute("user", uub);
			
			request.getRequestDispatcher("/client/myaccount_modify.jsp").forward(request, response);
			
			return;
		}
		

		
		
		
		
		
		
		
		UserService us = new UserService();
		us.updateUser(uub);
		
		// 更新session中的user对象
		user = us.findUserById(uub.getId());

		hs.setAttribute("user", user);
		
		request.getRequestDispatcher("/ShowMyAccount").forward(request, response);
		return;
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
