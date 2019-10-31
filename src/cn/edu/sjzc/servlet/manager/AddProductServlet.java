package cn.edu.sjzc.servlet.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.sjzc.domin.Product;
import cn.edu.sjzc.service.ProductService;
import cn.edu.sjzc.utils.IdUtils;

public class AddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product =  new Product();
		Map<String , String> map = new HashMap<String, String>();
		
		// 商品id
		map.put("id", IdUtils.getUUID());
		
		// 工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 临时文件存储位置
		factory.setRepository(new File("/TempFolder"));
		
		// 临界值  10M
		factory.setSizeThreshold(10*1024*1024);
		
		// 上传组件
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 得到所有的items
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			// 遍历items
			for (FileItem item:items){
				
				// 非文件
				if (item.isFormField()){
					
					String fieldName = item.getFieldName();
					String value = item.getString("UTF-8");
					
					map.put(fieldName, value);
					
					
				}else{
					// 文件
					// 获取文件名
					String fileName = item.getName();
					
					if (fileName!=null && !fileName.equals("")){
						// 截取文件名
						fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
						
						// 获取随机名
						String randomName = UUID.randomUUID().toString()+"_"+fileName;
					
						// 图片父目录  ：/bookstore/productImg
						String imgurl_parent = "/TempFolder/productImg/";
						File parentDir = new File(imgurl_parent);
						
						if (!parentDir.exists()){
							parentDir.mkdirs();
						}
						
						// 图片存放地址
						String imgurl = imgurl_parent+randomName;
						map.put("imgurl", imgurl);
						
						// 在图片夫目录下创建图片文件
						File imgFile = new File(parentDir, randomName);
						
						
						// 上传文件
						InputStream in = item.getInputStream();
						FileOutputStream fileout = new FileOutputStream(imgFile);
						
						byte[] buffer = new byte[1024];
						int len;
						while ((len = in.read(buffer))>0){
							fileout.write(buffer, 0, len);
						}
						in.close();
						fileout.close();
						item.delete();						
					}

				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BeanUtils.populate(product, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ProductService ps = new ProductService();
		ps.addProduct(product);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/ProductListServlet");
		rd.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
