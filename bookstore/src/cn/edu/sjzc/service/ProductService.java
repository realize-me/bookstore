package cn.edu.sjzc.service;

import cn.edu.sjzc.dao.ProductDao;
import cn.edu.sjzc.domin.Product;

public class ProductService {
	public Product findProductById(int id){
		ProductDao pd = new ProductDao();
		
		return pd.findProductById(id);
	}
}
