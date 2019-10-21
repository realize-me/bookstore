package cn.edu.sjzc.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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
}
