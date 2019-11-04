package cn.edu.sjzc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.edu.sjzc.domin.OrderItem;
import cn.edu.sjzc.domin.OrderItemBean;
import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.utils.C3P0Utils;

public class OrderItemDao {
	/**
	 * 
	 * @param id the id of order
	 * @return
	 */
	public List<OrderItemBean> findOrderItemByOrderId(String id){
		
		
		String sql = "select orderitem.*,products.* from orderitem,products where orderitem.product_id = products.id and orderitem.order_id=?";
		Object[] params = {
				id
		};
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		
		List<OrderItemBean> orderItemBeans = null;
		
		try {
			orderItemBeans = qr.query(sql, params, new ResultSetHandler<List<OrderItemBean>>() {

				@Override
				public List<OrderItemBean> handle(ResultSet rs)
						throws SQLException {
					
					List<OrderItemBean> orderItemBeans = new ArrayList<OrderItemBean>();
					
					while (rs.next()){
						
						OrderItemBean orderItemBean = new OrderItemBean();
						
						orderItemBean.setOrder_id(rs.getString("orderitem.order_id"));
						orderItemBean.setProduct_id(rs.getString("orderitem.product_id"));
						orderItemBean.setBuynum(rs.getInt("buynum"));
						
						Product p = new Product();
						p.setId(rs.getString("products.id"));
						p.setName(rs.getString("products.name"));
						p.setPrice(rs.getDouble("products.price"));
						p.setCategory(rs.getString("products.category"));
						p.setPnum(rs.getInt("products.pnum"));
						p.setImgurl(rs.getString("products.imgurl"));
						p.setDescription(rs.getString("products.description"));
						
						orderItemBean.setProduct(p);

						orderItemBeans.add(orderItemBean);
					}
					
					
					return orderItemBeans;
				}

			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderItemBeans;	
	}
	
	public void insertOrderItem(OrderItem orderItem){
		String sql = "insert into orderitem (order_id,product_id,buynum) values (?,?,?)";
		Object[] params={
				orderItem.getOrder_id(),
				orderItem.getProduct_id(),
				orderItem.getBuynum()
		};
		
		QueryRunner qRunner= new QueryRunner(C3P0Utils.dataSource);
		
		try {
			qRunner.execute(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
