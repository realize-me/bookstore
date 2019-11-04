package cn.edu.sjzc.service;

import java.util.List;

import cn.edu.sjzc.dao.OrderDao;
import cn.edu.sjzc.dao.OrderItemDao;
import cn.edu.sjzc.domin.Order;
import cn.edu.sjzc.domin.OrderBean;
import cn.edu.sjzc.domin.OrderItem;
import cn.edu.sjzc.domin.OrderItemBean;

public class OrderService {
	public void addOrder(Order order){
		
		OrderDao orderDao = new OrderDao();
		orderDao.insertOrder(order);
		
		OrderItemDao orderItemDao = new OrderItemDao();
		List<OrderItem> orderItems = order.getOrderItems();
		
		for(OrderItem item:orderItems){
			orderItemDao.insertOrderItem(item);
		}

	}
	
	public List<OrderBean> findAllOrder(){
		OrderDao od = new OrderDao();
		
		return od.findAllOrder();
	}
	/**
	 * 
	 * @param id the id of user
	 * @return a list contains OrderUserBeans
	 */
	public List<OrderBean> findOrderByCondition(int id){
		OrderDao od = new OrderDao();
		return od.findOrderByCondition(id);
	}
	
	public OrderBean findOrderBeanById(String id){
		
		
		
		OrderDao od = new OrderDao();
		OrderBean orderBean = od.findOrderById(id);
		
		
		
		OrderItemDao otdDao = new OrderItemDao();
		List<OrderItemBean> orderItemBeans = otdDao.findOrderItemByOrderId(id);
		
		orderBean.setOrderItemBeans(orderItemBeans);
		
		
		return orderBean;
	}
	public void deleteOrderById(String id) {
		OrderDao od = new OrderDao();
		od.deleteOrderById(id);
	}
	
}
