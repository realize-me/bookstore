package cn.edu.sjzc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.sjzc.dao.ProductDao;
import cn.edu.sjzc.domin.PageBean;
import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.domin.SearchPageBean;

public class ProductService {
	public Product findProductById(String id){
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
	
	public SearchPageBean findProductByName(int pageIndex,int pageSize,String name){
		
		ProductDao pd = new ProductDao();
		List<Product> products = pd.findProductByName(pageIndex, pageSize, name);
		
		SearchPageBean spb = new SearchPageBean();
		spb.setProducts(products);
		spb.setPageIndex(pageIndex);
		spb.setPageSize(pageSize);
		spb.setName(name);
		spb.setTotalNum(pd.findProductNumberByName(name));
		
		return spb;
	}
	
	public List<Product> findProductAll(){
		ProductDao pd = new ProductDao();
		
		return pd.findProductAll();
	}
	
	public List<Product> findProductByCondition(String id,String name,String category,String minprice,String maxprice){
		ProductDao pd = new ProductDao();
		return pd.findProductByCondition(id, name, category, minprice, maxprice);
	}
	
	public void addProduct(Product p){
		ProductDao pd = new ProductDao();
		pd.insertProduct(p);
	}
	// 根据id值更新product
	public void editProduct(Product p){
		ProductDao pd = new ProductDao();
		pd.updateProduct(p);
	}
	// 根据id删除product
	public void deleteProduct(String id){
		ProductDao pd = new ProductDao();
		pd.deleteProductById(id);
	}
}
