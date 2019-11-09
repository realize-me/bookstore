package cn.edu.sjzc.domin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.edu.sjzc.dao.UserDao;

public class UserFormBean {
	
	private int id;
	private String username;
	private String password;
	private String password2;
	private String gender;
	private String email;
	private String telephone;
	private String introduce;
	private String activeCode; // 激活码  在RegisterServlet中设置
	private int state; // 用户状态  数据库默认值未0
	private String role; // 用户类型  数据库设置默认值为普通用户
	private Date registerTime; // 注册时间   数据库的默认设置是插入数据的时间
	
	// 错误信息
	Map<String,String> errors = new HashMap<String, String>();
	
	/**
	 * 
	 * @return correct form return true, wrong form return false.
	 */
	public boolean isCorrect(){
		boolean flag = true;
		UserDao ud = new UserDao();
		
		if (username==null || username.equals("")){
			flag=false;
			errors.put("usernameMsg", "用户名不能为空");
		}
		
		boolean isExist = ud.isExist(username);
		if (!(username==null || username.equals("")) && isExist){
			flag=false;
			errors.put("usernameMsg", "用户名已经存在");
		}
		
		if (password==null || password.equals("")){
			flag=false;
			errors.put("passwordMsg", "密码不能为空");
		}
		
		if (password2==null || password2.equals("") || !password2.equals(password)){
			flag=false;
			errors.put("password2Msg", "两次密码不相同");
		}
		
		if (gender==null || gender.equals("")){
			flag=false;
			errors.put("genderMsg", "必须选择性别");
		}
		
		String url = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
		if (email==null || email.equals("")){
			flag=false;
			errors.put("emailMsg", "必须填写邮箱地址");
		}else if (!email.matches(url)){
			flag=false;
			errors.put("emailMsg", "邮箱格式错误");
		}
		
		if (telephone==null || telephone.equals("")){
			flag=false;
			errors.put("telephoneMsg", "必须填写手机号");
		}
		
		String tel = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		if (!(telephone==null || telephone.equals("")) && !telephone.matches(tel)){
			flag=false;
			errors.put("telephoneMsg","请正确填写手机号");
		}
		
		return flag;
	}
	
	public Map<String,String> getErrorsMap(){
		return this.errors;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
