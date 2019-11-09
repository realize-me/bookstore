package cn.edu.sjzc.domin;

import java.util.HashMap;
import java.util.Map;

import cn.edu.sjzc.dao.UserDao;

public class UpdateUserBean {
	private int id;
	private String email;
	private String username;
	private String gender;
	private String telephone;
	private String introduce;
	
	private Map<String,String> errors = new HashMap<String, String>();
	
	// 检验表单的正确性
	public boolean checkForm(String session_username){
		
		UserDao ud = new UserDao();
		boolean flag = true;
		
		if (id==0){
			flag = false;
		}
		
		String url = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
		if (email==null ||email.trim().equals("")){
			flag=false;
			errors.put("emailMsg", "请填写邮箱");
		}else if (!email.matches(url)){
			flag=false;
			errors.put("emailMsg", "邮箱格式错误");
		}
		
		if (username==null || username.trim().equals("")){
			flag=false;
			errors.put("usernameMsg", "请填写用户名");
		}else if (!session_username.equals(username) && ud.isExist(username)){
			// 如果用户名修改   且用户名存在于数据库
			flag = false;
			errors.put("usernameMsg", "用户名已存在");
		}
		
		if (gender==null || gender.trim().equals("")){
			flag=false;
			errors.put("GenderMsg", "请选择性别");
		}
		
		String tel = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		if (telephone==null || telephone.trim().equals("")){
			flag = false;
			errors.put("telephoneMsg", "请填写手机号");
		}else if (!telephone.matches(tel)){
			flag = false;
			errors.put("telephoneMsg", "手机号格式错误");
		}
		
		return flag;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Map<String, String> getErrors() {
		return errors;
	}



	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	
	
}
