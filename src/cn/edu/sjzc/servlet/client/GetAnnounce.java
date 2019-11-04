package cn.edu.sjzc.servlet.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjzc.domin.Notice;
import cn.edu.sjzc.service.NoticeService;

public class GetAnnounce extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService ns = new NoticeService();
		Notice notice = ns.getNotice();
		
		request.setAttribute("notice", notice);
		
		String type = request.getParameter("type");
		
		if (type==null){
			RequestDispatcher rd = request.getRequestDispatcher("/client/announce_hot.jsp");
			rd.include(request, response);
			return;
		}
		
		// type为 不为null表示后台修改操作
		RequestDispatcher rd = request.getRequestDispatcher("/manager/notice_modify.jsp");
		rd.forward(request, response);
		return;
		
		
		
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
