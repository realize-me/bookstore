package cn.edu.sjzc.domin;

import java.util.Date;
import java.util.List;

public class OrderBean {
	private String id;
	private Double money;
	private String receiverName;
	private String receiverAddress;
	private String receiverPhone;
	private int payState;
	private Date orderTime;
	private int user_id;
	
	User user; // 用户
	List<OrderItemBean> orderItemBeans; // 订单中的商品
	
	



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public int getPayState() {
		return payState;
	}

	public void setPayState(int payState) {
		this.payState = payState;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItemBean> getOrderItemBeans() {
		return orderItemBeans;
	}

	public void setOrderItemBeans(List<OrderItemBean> orderItemBeans) {
		this.orderItemBeans = orderItemBeans;
	}
	
	
	
}
