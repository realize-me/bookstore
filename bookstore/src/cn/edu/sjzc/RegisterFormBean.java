package cn.edu.sjzc;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于检验表单信息是否正确填写
 * @author Lenovo
 *
 */
public class RegisterFormBean {
	
	// 用于存放错误
	Map<String, String> errors = new HashMap<String, String>();
	
	String username;
	String password1;
	String password2;
	String email;

	/**
	 * 验证表单数据
	 * @return 正确返回 true 错误返回false
	 */
	public boolean validate(){
	
		boolean flag = true;
		// 用户名
		if (username==null || username.equals("")){
			flag = false;
			errors.put("username", "用户名不能为空");
		}
		if (password1==null||password1.equals("")){
			flag = false;
			errors.put("password1", "密码不能为空");
		}
		if (password2==null||password2.equals("")){
			flag = false;
			errors.put("password2", "请再次输入密码");
		}
		if (!password1.equals(password2)){
			flag = false;
			errors.put("password2", "两次输入的密码不相同");
		}
		if (email==null||email.equals("")){
			flag = false;
			errors.put("email", "请输入邮箱地址");
		}
		String emailAddr = "[a-zA-Z0-9_=]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";
		if (!email.matches(emailAddr)){
			flag = false;
			errors.put("email","邮箱地址格式错误");
		}
		return flag;
	}
	/**
	 * 
	 * @return 返回错误的Map集合
	 */
	public Map<String, String> getErrorMap(){	
		return errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
