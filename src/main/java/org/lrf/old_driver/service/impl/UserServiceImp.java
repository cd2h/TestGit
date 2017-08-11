package org.lrf.old_driver.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.lrf.old_driver.dao.UserDao;
import org.lrf.old_driver.entity.User;
import org.lrf.old_driver.service.UserService;
import org.lrf.old_driver.util.Encryption;
import org.lrf.old_driver.util.Key;
import org.lrf.old_driver.util.Text;
import org.lrf.old_driver.util.Verify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.lrf.old_driver.enumeration.Type;

@Component("userService")
public class UserServiceImp implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById() {

		return null;
	}

	@Override
	public User findUserByCellPhone(String cellPhone) {
		User user = new User();
		user.setCellPhone(cellPhone);
		return userDao.findUser(user);
	}

	@Override
	public User findUserByUserName(String userName) {
		User user = new User();
		user.setUserName(userName);
		return userDao.findUser(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> registerUser(User user, String vertifyCode) {

		Map<String, Object> result = new HashMap<>();
		//返回登录或者注册的类型
		result.put(Key.TYPE,Type.REGISTER.getText());
		//设置用户的默认自我介绍
		user.setDefaultIntroduce();
		String errorMessage = registerVerifyUser(user);
		if (errorMessage != null) {
			result.put(Key.ERROR, errorMessage);
			return result;
		}
		

		// 给用添加欢迎信息
		// user.setMessages("");

		// 用户可用
		user.setAvailable(true);

		// 对密码进行加密
		try {
			user.setPassWord(Encryption.encoderByMd5(user.getPassWord()));
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}

		if (!userDao.insertUser(user)) {
			logger.error(Text.REGISTER_FAILED, user);
			result.put(Key.ERROR, Text.REGISTER_FAILED);
		}

		result.put(Key.USER, user);
		result.put(Key.MESSAGE, Text.REGISTER_SUCCESS);

		return result;
	}

	/**
	 * 登陆非空验证
	 * @param loginName 用户名 或者 手机号
	 * @param password  密码
	 * @return
	 */
	private String loginVerifyUser(String loginName,String password) {
		// 用户名不能为空
		if (loginName == null || loginName.isEmpty())
			return Text.USER_NAME_EMPTY;

		// 密码
		if (password == null || password.isEmpty())
			return Text.PASSWORD_EMPTY;

		// 密码长度
		if (password.length() < 6 || password.length() > 12)
			return Text.PASSWORD_ERROR_LENGTH;

		return null;
	}
	
	/**
	 * register验证
	 * 
	 * @return 如果有错误信息则返回，否则返回null
	 */
	private String registerVerifyUser(User user) {
		// 用户名不能为空
		if (user == null || user.getUserName() == null)
			return Text.USER_NAME_EMPTY;

		// 性别不为空
		if (user == null || user.getSex() == null  || !(user.getSex() == 0 || user.getSex() == 1))
			return Text.SEX_EMPTY;

		// 密码
		if (user == null || user.getPassWord() == null)
			return Text.PASSWORD_EMPTY;

		// 自我介绍不为空
		if (user == null || user.getIntroduce() == null)
			return Text.INTRODUCE_EMPTY;

		// 手机号不为空
		if (user == null || user.getCellPhone() == null)
			return Text.CELL_PHONE_EMPTY;

		// 用户名长度
		if (user.getUserName().length() < 2 || user.getUserName().length() > 12)
			return Text.USER_NAME_ERROR_LENGTH;

		// 密码长度
		if (user.getPassWord().length() < 6 || user.getPassWord().length() > 12)
			return Text.PASSWORD_ERROR_LENGTH;

		// 手机号格式
		if (!Verify.isMobileNO(user.getCellPhone()))
			return Text.ERROR_CELL_PHONE;
		// 用户是否存在
		if (findUserByUserName(user.getUserName()) != null)
			return Text.EXISTS_USER;

		// 手机是否存在
		if (findUserByCellPhone(user.getCellPhone()) != null)
			return Text.EXISTS_CELL_PHONE;
		
		//检查用户名是否为手机号
		if(Verify.isMobileNO(user.getUserName()))
			return Text.USER_NAME_IS_CELL_PHONE;
			
		return null;
	}

	@Override
	public Map<String, Object> login(String userNameOrCellPhone, String passWord, String verifyCode,HttpSession session) {
		Map<String, Object> result = new HashMap<>();
		//返回登录或者注册的类型
		result.put(Key.TYPE,Type.LOGIN.getText());
				
		//验证是否为空
		String errorMessage = loginVerifyUser(userNameOrCellPhone,passWord);
		if (errorMessage != null) {
			result.put(Key.ERROR, errorMessage);
			return result;
		}
		
		//查询条件user
		User condition = null;
		try {
			condition = new User(userNameOrCellPhone,Encryption.encoderByMd5(passWord));
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
			result.put(Key.ERROR, Text.LOGIN_FAILED);
			return result;
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			result.put(Key.ERROR, Text.LOGIN_FAILED);
			return result;
		}
		
		User user = userDao.findUser(condition);
		
		if(user!=null){
			result.put(Key.USER, user);
			result.put(Key.MESSAGE, Text.LOGIN_SUCCESS);
			
			//用户放入session
			session.setAttribute(Key.USER, user);
		}else{
			result.put(Key.ERROR, Text.LOGIN_FAILED);
		}
		
		return result;
	}

	@Override
	public User forgetUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout(HttpSession session) {
		session.removeAttribute(Key.USER);
	}

	
	
}
