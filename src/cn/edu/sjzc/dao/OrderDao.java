package cn.edu.sjzc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.sjzc.domin.Order;
import cn.edu.sjzc.domin.OrderBean;
import cn.edu.sjzc.domin.User;
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
	
	public List<OrderBean> findAllOrder(){
		String sql = "select orders.*,user.* from orders,user where orders.user_id = user.id";
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		
		List<OrderBean> orders = null;
		try {

			orders = qr.query(sql, new ResultSetHandler<List<OrderBean>>() {

				@Override
				public List<OrderBean> handle(ResultSet rs) throws SQLException {
					
					List<OrderBean> orders = new ArrayList<OrderBean>();
					
					while (rs.next()){
						OrderBean orderUserBean = new OrderBean();
						
						orderUserBean.setId(rs.getString("orders.id"));
						orderUserBean.setMoney(rs.getDouble("orders.money"));
						orderUserBean.setOrderTime(rs.getDate("orders.orderTime"));
						orderUserBean.setPayState(rs.getInt("orders.payState"));
						orderUserBean.setReceiverAddress(rs.getString("orders.receiverAddress"));
						orderUserBean.setReceiverName(rs.getString("orders.receiverName"));
						orderUserBean.setReceiverPhone(rs.getString("orders.receiverPhone"));
						orderUserBean.setUser_id(rs.getInt("orders.user_id"));
						
						User user = new User();
						user.setId(rs.getInt("user.id"));
						user.setUsername(rs.getString("user.username"));
						user.setPassword(rs.getString("user.password"));
						user.setGender(rs.getString("user.gender"));
						user.setEmail(rs.getString("user.email"));
						user.setTelephone(rs.getString("user.telephone"));
						user.setIntroduce(rs.getString("user.introduce"));
						user.setActiveCode(rs.getString("user.activeCode"));
						user.setState(rs.getInt("user.state"));
						user.setRole(rs.getString("user.role"));
						user.setRegisterTime(rs.getDate("user.registTime"));
						
						orderUserBean.setUser(user);
						
						orders.add(orderUserBean);
					}
					
					
					return orders;
				}
				
				
			});
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
	
	
	public List<OrderBean> findOrderByCondition(int id){
		String sql = "select orders.*,user.* from orders,user where orders.user_id = user.id and user.id=?";
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		
		List<OrderBean> orders = null;
		Object[] params = {
				id
		};
		
		try {
			orders = qr.query(sql,params, new ResultSetHandler<List<OrderBean>>() {

				@Override
				public List<OrderBean> handle(ResultSet rs) throws SQLException {
					
					List<OrderBean> orders = new ArrayList<OrderBean>();
					
					while (rs.next()){
						OrderBean orderUserBean = new OrderBean();
						
						orderUserBean.setId(rs.getString("orders.id"));
						orderUserBean.setMoney(rs.getDouble("orders.money"));
						orderUserBean.setOrderTime(rs.getDate("orders.orderTime"));
						orderUserBean.setPayState(rs.getInt("orders.payState"));
						orderUserBean.setReceiverAddress(rs.getString("orders.receiverAddress"));
						orderUserBean.setReceiverName(rs.getString("orders.receiverName"));
						orderUserBean.setReceiverPhone(rs.getString("orders.receiverPhone"));
						orderUserBean.setUser_id(rs.getInt("orders.user_id"));
						
						User user = new User();
						user.setId(rs.getInt("user.id"));
						user.setUsername(rs.getString("user.username"));
						user.setPassword(rs.getString("user.password"));
						user.setGender(rs.getString("user.gender"));
						user.setEmail(rs.getString("user.email"));
						user.setTelephone(rs.getString("user.telephone"));
						user.setIntroduce(rs.getString("user.introduce"));
						user.setActiveCode(rs.getString("user.activeCode"));
						user.setState(rs.getInt("user.state"));
						user.setRole(rs.getString("user.role"));
						user.setRegisterTime(rs.getDate("user.registTime"));
						
						orderUserBean.setUser(user);
						
						orders.add(orderUserBean);
					}
					
					
					return orders;
				}
				
				
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}
	/**
	 * 
	 * @param id the id of order
	 * @return a OrderUserBean that id is parameter id
	 */
	public OrderBean findOrderById(String id) {
		String sql = "select orders.*,user.* from orders,user where orders.user_id = user.id and orders.id=?";
		Object[] params={
				id
		};
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		
		OrderBean orderUserBean = null;
		
		
		// 在这里面，user被封装进orderUserBean了
		try {
			orderUserBean = qr.query(sql, params, new ResultSetHandler<OrderBean>() {

				@Override
				public OrderBean handle(ResultSet rs)
						throws SQLException {
					
					
					
					OrderBean orderUserBean = new OrderBean();
					
					while (rs.next()){

						orderUserBean.setId(rs.getString("orders.id"));
						orderUserBean.setMoney(rs.getDouble("orders.money"));
						orderUserBean.setOrderTime(rs.getDate("orders.orderTime"));
						orderUserBean.setPayState(rs.getInt("orders.payState"));
						orderUserBean.setReceiverAddress(rs.getString("orders.receiverAddress"));
						orderUserBean.setReceiverName(rs.getString("orders.receiverName"));
						orderUserBean.setReceiverPhone(rs.getString("orders.receiverPhone"));
						orderUserBean.setUser_id(rs.getInt("orders.user_id"));
						
						User user = new User();
						user.setId(rs.getInt("user.id"));
						user.setUsername(rs.getString("user.username"));
						user.setPassword(rs.getString("user.password"));
						user.setGender(rs.getString("user.gender"));
						user.setEmail(rs.getString("user.email"));
						user.setTelephone(rs.getString("user.telephone"));
						user.setIntroduce(rs.getString("user.introduce"));
						user.setActiveCode(rs.getString("user.activeCode"));
						user.setState(rs.getInt("user.state"));
						user.setRole(rs.getString("user.role"));
						user.setRegisterTime(rs.getDate("user.registTime"));
						
						orderUserBean.setUser(user);
						
					}
					return orderUserBean;
				}
			});	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return orderUserBean;
	}
	/**
	 * 
	 * 该方法将会级联删除orderitem表中 order_id=id 的记录
	 * 
	 * @param id the id of orders which will be deleted
	 */
	public void deleteOrderById(String id){
		String sql = "delete from orders where id = ?";
		Object [] params = {
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
