package cn.edu.sjzc.service;

import java.util.List;

import cn.edu.sjzc.dao.ProductDao;
import cn.edu.sjzc.domin.PageBean;
import cn.edu.sjzc.domin.Product;

public class ProductService {
	public Product findProductById(int id){
		ProductDao pd = new ProductDao();
		
		return pd.findProductById(id);
	}
	
	public PageBean findProductByPage(int pageIndex,int pageSize,String category){
		
		ProductDao pd = new ProductDao();
		List<Product> products = pd.findProductsByPage(pageIndex, pageSize, category);
		
		PageBean pageBean = new PageBean();
		pageBean.setProducts(products);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setCategory(category);
		pageBean.setTotalNum(pd.findCountByCategory(category));
		
		return pageBean;
	}

}
