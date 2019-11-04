package cn.edu.sjzc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.sjzc.domin.Notice;
import cn.edu.sjzc.utils.C3P0Utils;

public class NoticeDao {
	/**
	 * 
	 * @return 最新的公告
	 */
	public Notice getNotice(){
		// 最新的一条公告
		String sql = "select * from notice order by n_time desc limit 0,1";
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		Notice notice = null;
		try {
			notice = qr.query(sql,new BeanHandler(Notice.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notice;
		
	}
	
	/**
	 * 
	 * @return 所有的公告
	 */
	public List<Notice> findAllNotice(){
		String sql = "select * from notice order by n_id desc";
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		
		List<Notice> notices = null;
		try {
			notices = qr.query(sql, new BeanListHandler(Notice.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notices;
		
	}
	/**
	 * 添加新的公告 
	 */
	public void insertNotice(Notice notice){
		String sql = "insert into notice(title,details,n_time) values (?,?,?)";
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		Object [] params = {
				notice.getTitle(),
				notice.getDetails(),
				notice.getN_time()
		};
		
		try {
			qr.execute(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据id修改notice
	 */
	public void updateNotice(Notice notice){
		String sql = "update notice set title=?,details=?,n_time=? where n_id=?";
		Object[] params = {
				notice.getTitle(),
				notice.getDetails(),
				notice.getN_time(),
				notice.getN_id()
		};
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
