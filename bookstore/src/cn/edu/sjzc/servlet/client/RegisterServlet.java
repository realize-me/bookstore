package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.sjzc.domin.User;
import cn.edu.sjzc.domin.UserFormBean;
import cn.edu.sjzc.service.UserService;
import cn.edu.sjzc.utils.ActiveCodeUtils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserFormBean ufb = new UserFormBean();
		
		Map<String, String[]> properties = request.getParameterMap();
		try {
			BeanUtils.populate(ufb, properties);
			
			// 表单不合法
			if (!ufb.isCorrect()){
				Map<String, String> errors = ufb.getErrorsMap();
				request.setAttribute("errors", errors);
				request.setAttribute("formBean", ufb);
				
				RequestDispatcher rd = request.getRequestDispatcher("/client/register.jsp");
				rd.forward(request, response);
				
				return;
			}
			// 表单合法
			
			User user = new User();
			BeanUtils.populate(user, properties);

			// 设置激活码
			user.setActiveCode(ActiveCodeUtils.createActiveCode());
			
			// 使用service将user对象存入到数据库中
			UserService us = new UserService();
			us.register(user);
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 转到注册成功页面
		RequestDispatcher rd = request.getRequestDispatcher("/client/register_success.jsp");
		rd.forward(request, response);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
