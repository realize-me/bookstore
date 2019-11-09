package cn.edu.sjzc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.sjzc.domin.UpdateUserBean;
import cn.edu.sjzc.domin.User;
import cn.edu.sjzc.utils.C3P0Utils;

public class UserDao {
	

	public void addUser(User user){
		DataSource ds = C3P0Utils.dataSource;
		
		QueryRunner qr = new QueryRunner(ds);
		
		String sql = "insert into user (username,password,gender,email,telephone,introduce,activeCode) values(?,?,?,?,?,?,?)";
		Object[] params = {
				user.getUsername(),
				user.getPassword(),
				user.getGender(),
				user.getEmail(),
				user.getTelephone(),
				user.getIntroduce(),
				user.getActiveCode(),
		};
		
		try {
			qr.execute(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param username
	 * @return username is existed return true,username is not exist return false.
	 */
	public boolean isExist(String username){
		Connection conn = C3P0Utils.getConnection();
		String sql = "select count(*) num from user where username=?";
		PreparedStatement prestat;
		
		try {
			
			prestat = conn.prepareStatement(sql);
			prestat.setString(1, username);
			ResultSet rs = prestat.executeQuery();

			rs.next();
			int num = rs.getInt(1);
			
			// 关闭连接
			C3P0Utils.close(conn, prestat);
			
			if (num>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public User findUserByNameAndPass(String username,String password){
		User user=null;
		String sql = "select * from user where username=? and password=?";
		Object[] params = {
				username,
				password
		};
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		
		try {
			Object obj = qr.query(sql, params, new BeanHandler(User.class));
			user = (User)obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	// 更新用户信息
	public void updateUserByUpdateUserBean(UpdateUserBean uub){
		String sql = "update user set username=?,gender=?,email=?,telephone=?,introduce=? where id=?";
		Object[] params = {
				uub.getUsername(),
				uub.getGender(),
				uub.getEmail(),
				uub.getTelephone(),
				uub.getIntroduce(),
				uub.getId()
		};
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 根据id查询用户
	public User findUserById(int id){
		String sql = "select * from user where id =?";
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		User user = null;
		
		try {
			user = qr.query(sql, id, new BeanHandler(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	// 根据用户id更新用户密码
	public void updateUserPasswordById(int id,String password){
		String sql = "update user set password = ? where id = ?";
		
		Object[] params = {
				password,
				id
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
