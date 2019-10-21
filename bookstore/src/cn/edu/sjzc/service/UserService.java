package cn.edu.sjzc.service;

import cn.edu.sjzc.dao.UserDao;
import cn.edu.sjzc.domin.User;

public class UserService {
	
	// 由注册页面封装好的bean添加到数据库中
	public void register(User user){
		UserDao ud = new UserDao();
		ud.addUser(user);
	}
	// 用户登陆
	public User login(String username,String password){
		UserDao ud = new UserDao();
		return ud.findUserByNameAndPass(username, password);
	}
}
