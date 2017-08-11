package org.lrf.old_driver.dao;

import org.lrf.old_driver.entity.User;

public interface UserDao{
	
	public boolean insertUser(User user);
	
	public User findUser(User condition);
	
	public User updateUser(User user);
	
	
}
