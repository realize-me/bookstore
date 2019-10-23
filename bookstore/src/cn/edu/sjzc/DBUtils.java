package cn.edu.sjzc;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
	public static DataSource dataSource = null;
	static {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/chapter11");
		cpds.setUser("root");
		cpds.setPassword("123456");
		cpds.setMaxPoolSize(20);
		cpds.setMaxIdleTime(2000);
		dataSource = cpds;
	}
}
