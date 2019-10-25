package cn.edu.sjzc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.utils.C3P0Utils;

public class ProductDao {
	public Product findProductById(int id){
		
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
					System.out.println("1111111111");
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
}
