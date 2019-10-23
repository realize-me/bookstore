package cn.edu.sjzc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 将表单数据设置到RegisterFormBean中，检验表单数据是否正确填写
		RegisterFormBean rfb = new RegisterFormBean();
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		
		rfb.setUsername(username);
		rfb.setPassword1(password1);
		rfb.setPassword2(password2);
		rfb.setEmail(email);
		
		// 不正确
		if (!rfb.validate()){
			request.setAttribute("formBean", rfb);
			request.setAttribute("errorMap", rfb.errors);
			// 转回注册页面，重新填写表单
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
		}
		
		// 正确
		// 将用户信息封装到UserBean中
		UserBean userBean = new UserBean();
		userBean.setUsername(username);
		userBean.setPassword(password1);
		userBean.setEmail(email);
		
		// 将用户 信息存入数据库中
		Dao dao = new Dao();
		dao.insertUserBean(userBean);
		

		// 转到注册成功页面
		request.setAttribute("userBean", userBean);
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);
		
	}

}
