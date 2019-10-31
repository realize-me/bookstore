package cn.edu.sjzc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.utils.C3P0Utils;

public class ProductDao {
	public Product findProductById(String id){
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		String sql = "select * from products where id = ?";
		Object[] param={
			id
		};
		Object obj=null;
		try {
			obj = qr.query(sql, param, new BeanHandler(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product product = (Product)obj;
		return product;
	}
	/**
	 * 
	 * @param pageIndex the index of page, start from 1 to n.
	 * @param pageSize  the size of page, start from 0 to n.
	 * @param category the category of the product
	 * @return a list of items that represent all the items on a page. 
	 */
	public List<Product> findProductsByPage(int pageIndex,int pageSize,String category){
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		String sql = "select * from products  where category = ? limit ?,?";
		String sql2 = "select * from products limit ?,?";
		List<Product> products=null;
		
		if (!category.equals("全部商品")){
			Object[] params = {
					category,
					(pageIndex-1)*pageSize,
					pageSize,
				};

				
				try {
					products = (List<Product>)qr.query(sql, params, new BeanListHandler(Product.class));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else{
			Object[] params = {
					(pageIndex-1)*pageSize,
					pageSize,
				};

				
				try {
					products = (List<Product>)qr.query(sql2, params, new BeanListHandler(Product.class));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		
		return products;
	}
	/**
	 * 查询一个商品类下面，有多少种商品
	 * @param category
	 * @return 
	 */
	public long findCountByCategory(String category){
		
		long count=0;
		if (category.equals("全部商品")){
			String sql = "select count(*) from products";
			Connection conn = C3P0Utils.getConnection();
			try {
				PreparedStatement preStat = conn.prepareStatement(sql);
				ResultSet rs = preStat.executeQuery();
				
				while (rs.next()){
					count = rs.getLong(1);
				};
			
				C3P0Utils.close(conn, preStat);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			String sql = "select count(*) from products where category=?";
			Connection conn = C3P0Utils.getConnection();
			try {
				PreparedStatement preStat = conn.prepareStatement(sql);
				preStat.setString(1, category);
				ResultSet rs = preStat.executeQuery();
				
				while (rs.next()){
					count = rs.getLong(1);
				};
				C3P0Utils.close(conn, preStat);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return count;
	}
	/**
	 * 根据商品名称迷糊查询，加分页查询
	 * @return product的list列表
	 */
	public List<Product> findProductByName(int pageIndex,int pageSize,String name){
		String sql = "select * from products where name like ? limit ?,?";
		Object[] params = {
				"%"+name+"%",
				(pageIndex-1)*pageSize,
				pageSize,
		};
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		List<Product> products= null;
		try {
			products = qr.query(sql, params, new BeanListHandler(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public long findProductNumberByName(String name){
		String sql = "select count(*) from products where name like ?";
		Connection conn = C3P0Utils.getConnection();
		
		long count = 0;
		try {
			PreparedStatement preStat = conn.prepareStatement(sql);
			preStat.setString(1, "%"+name+"%");
			ResultSet rs = preStat.executeQuery();
			
			while (rs.next()){
				count = rs.getLong(1);
			}
			
			C3P0Utils.close(conn, preStat);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return count;
		
	}
	public List<Product> findProductAll(){
		String sql = "select * from products";
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		
		List<Product> products=null;
		try {
			products = qr.query(sql, new BeanListHandler(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public List<Product> findProductByCondition(String id,String name,String category,String minprice,String maxprice){
		
String sql = "select * from products where 1=1";
		
		List<Object> paramsList = new ArrayList<Object>();
		
		if (id!=null && id.trim().length()>0){
			sql += " and id = ?";
			paramsList.add(id);	
		}
		
		if (name!=null && name.trim().length()>0){
			sql += " and name = ?";
			paramsList.add(name);
		}
		
		if (category!=null && category.trim().length()>0){
			sql += " and category = ?";
			paramsList.add(category);
		}
		
		if (minprice!= null && maxprice!=null && minprice.trim().length()>0 && maxprice.trim().length()>0){
			sql += " and price between ? and ?";
			paramsList.add(minprice);
			paramsList.add(maxprice);
		}
		
		Object[] params = paramsList.toArray();
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		List<Product> products=null;
		try {
			products = qr.query(sql, params, new BeanListHandler(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public void insertProduct(Product p){
		String sql = "insert into products (id,name,price,category,pnum,imgurl,description) values (?,?,?,?,?,?,?)";
		Object[] params = {
				p.getId(),
				p.getName(),
				p.getPrice(),
				p.getCategory(),
				p.getPnum(),
				p.getImgurl(),
				p.getDescription()
		};
		
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		
		
		try {
			qr.execute(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	// 根据id值更新product表中某一个记录的数据
	public void updateProduct(Product p){
		String sql = "update products set name=?,price=?,category=?,pnum=?,imgurl=?,description=? where id=?";
		Object[] params = {
				p.getName(),
				p.getPrice(),
				p.getCategory(),
				p.getPnum(),
				p.getImgurl(),
				p.getDescription(),
				p.getId()
		};
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProductById(String id){
		String sql = "delete from products where id = ?";
		QueryRunner qr = new QueryRunner(C3P0Utils.dataSource);
		try {
			qr.execute(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
