package cn.edu.sjzc.domin;

public class Product {
	private String id;
	private String name;
	private double price;
	private String categroy;
	private int pnum;
	private String imgurl;
	private String description;
	
	
	
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this==obj){
			return true;
		}
		if (obj==null){
			return false;
		}

		if (obj instanceof Product){
			
			Product p = (Product)obj;
			
			return this.id.equals(p.getId());
		}
		return false;
	}
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategroy() {
		return categroy;
	}
	public void setCategroy(String categroy) {
		this.categroy = categroy;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
