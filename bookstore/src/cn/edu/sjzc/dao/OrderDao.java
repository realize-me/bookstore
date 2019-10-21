package cn.edu.sjzc.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.edu.sjzc.domin.Order;
import cn.edu.sjzc.utils.C3P0Utils;

public class OrderDao {
	public void insertOrder(Order order){
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		String sql = "insert into orders(id,money,receiverAddress,receiverName,receiverPhone,user_id) values (?,?,?,?,?,?)";
		Object[] params = {
				order.getId(),
				order.getMoney(),
				order.getReceiverAddress(),
				order.getReceiverName(),
				order.getReceiverPhone(),
				order.getUser_id()
		};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
