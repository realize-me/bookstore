package cn.edu.sjzc.domin;
/**
 * 表单中的一条数据(商品编号,商品数量)
 * @author Lenovo
 *
 */
public class OrderItem {
	private String product_id;
	private int buynum;
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	
	
}
