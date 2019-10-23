package cn.edu.sjzc.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import cn.edu.sjzc.filter.MyRequest;
/**
 * 过滤器，实现全站统一编码
 * @author Lenovo
 *
 */
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {


	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		
		// 对request中的getParameterMap方法进行重写
		MyRequest myRequest = new MyRequest(request);
		
		// 设置响应消息头
		arg1.setContentType("text/html");
		arg2.doFilter(myRequest, arg1);
		
	}

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
// 自定义request对象
class MyRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request = null;
	private boolean flag=false;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	public Map<String,String[]> getParameterMap(){
		
			if (!flag){
				try {
					request.setCharacterEncoding("utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String method = request.getMethod();
					
					if (method.equalsIgnoreCase("get")){
				// 如果请求方式为get
					 Map<String, String[]> params = request.getParameterMap();
					
					 for (String paramName:params.keySet()){
						 String[] values = params.get(paramName);
						 
						 for (int i=0;i<values.length;i++){
							 try {
								values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						 }

						  
					 }
					 return params;
			}
		}
		flag=true;
		return super.getParameterMap();
	}
	@Override
	/*
	 * 根据参数名获取参数值（第一个）
	 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	 */
	public String getParameter(String name){
		Map<String, String[]> params = this.getParameterMap();
		
		String[] values = params.get(name);
		if (values==null){
			return null;
		}
		
		return values[0];
	}
	@Override
	/*
	 * 根据参数名获取参数值（所有的参数值）
	 * @see javax.servlet.ServletRequestWrapper#getParameterValues(java.lang.String)
	 */
	public String[] getParameterValues(String name){
		Map <String,String[]> params = this.getParameterMap();
		
		String[] values = params.get(name);
		if (values==null){
			return null;
		}
		
		return values;
	}
	
}
