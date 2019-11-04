package cn.edu.sjzc.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sjzc.domin.Notice;
import cn.edu.sjzc.service.NoticeService;

public class FindNoticeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeService ns = new NoticeService();
		List<Notice> notices = ns.findAllNotice();
		
		request.setAttribute("notices", notices);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/notice_list.jsp");
		rd.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
