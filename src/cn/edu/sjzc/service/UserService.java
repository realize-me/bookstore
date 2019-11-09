package cn.edu.sjzc.service;

import cn.edu.sjzc.dao.UserDao;
import cn.edu.sjzc.domin.UpdateUserBean;
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
	// 用户修改信息
	public void updateUser(UpdateUserBean uub){
		UserDao ud = new UserDao();
		ud.updateUserByUpdateUserBean(uub);
	}
	// 根据id查询用户信息
	public User findUserById(int id){
		UserDao ud = new UserDao();
		return ud.findUserById(id);
	}
	// 根据id更新用户密码
	public void updateUserPasswordById(int id,String password){
		UserDao ud = new UserDao();
		ud.updateUserPasswordById(id, password);
	}
	
}
