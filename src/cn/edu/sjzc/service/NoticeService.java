package cn.edu.sjzc.service;

import java.util.List;

import cn.edu.sjzc.dao.NoticeDao;
import cn.edu.sjzc.domin.Notice;

public class NoticeService {
	public Notice getNotice(){
		NoticeDao noticeDao = new NoticeDao();
		
		return noticeDao.getNotice();
	}
	
	public List<Notice> findAllNotice(){
		NoticeDao nd = new NoticeDao();
		
		return nd.findAllNotice();
	}
	public void addNotice(Notice notice){
		NoticeDao nd = new NoticeDao();
		nd.insertNotice(notice);
	}
	public void modifyNotice(Notice notice){
		NoticeDao nd = new NoticeDao();
		nd.updateNotice(notice);
	}
}
