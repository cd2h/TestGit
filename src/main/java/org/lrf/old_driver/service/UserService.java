package org.lrf.old_driver.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.lrf.old_driver.entity.User;

public interface UserService {
	public User getUserById();
	
	public User findUserByCellPhone(String cellPhone);
	
	public User findUserByUserName(String userName);
	
	public User updateUser(User user);
	
	public Map<String, Object> registerUser(User user,String vertifyCode);
	
	public Map<String, Object> login(String userNameOrCellPhone, String passWord, String verifyCode,HttpSession session);
	
	public User forgetUser(String userName);
	
	public void logout(HttpSession session);
}
