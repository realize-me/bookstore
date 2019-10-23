package cn.edu.sjzc;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class Dao {
	public void insertUserBean(UserBean userBean){
		QueryRunner qr = new QueryRunner(DBUtils.dataSource);
		String sql = "insert into users (username,password,email) values (?,?,?)";
		Object[] param = {userBean.getUsername(),userBean.getPassword(),userBean.getEmail()};
		
		try {
			qr.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
