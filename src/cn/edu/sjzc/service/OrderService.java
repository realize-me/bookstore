package cn.edu.sjzc.service;

import cn.edu.sjzc.dao.OrderDao;
import cn.edu.sjzc.domin.Order;

public class OrderService {
	public void addOrder(Order order){
		OrderDao orderDao = new OrderDao();
		orderDao.insertOrder(order);
	}
}
