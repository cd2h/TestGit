package org.lrf.old_driver.entity;

import java.util.Date;
import java.util.List;

import org.lrf.old_driver.util.Text;
import org.lrf.old_driver.util.Verify;

public class User {
	
	
	public User() {
		super();
	}
	
	public User(String id) {
		setId(id);
	}
	
	public User(String loginName,String password) {
		this.setLoginNameAndPassword(loginName,password);
	}

	private String id;
	private Integer sex;/***/
	private City city;
	private Date birthDay;
	private String introduce;
	/**身高*/
	private int height;
	private List<String> hobbies;
	
	/**外貌*/
	private Integer appearance;
	/**性格*/
	private Integer character;
	/**人品*/
	private Integer quality;
	
	private String cellPhone;
	private String userName;
	private String passWord;
	
	/**是否是可用用户*/
	private boolean isAvailable;
	
	/**wechat*/
	private String wechat;
	
	/**信息*/
	private List<Message> messages;
	/**新信息的条数*/
	private int newMessageNumber;
	
	
	
	

	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAppearance() {
		return appearance;
	}
	public void setAppearance(Integer appearance) {
		this.appearance = appearance;
	}
	public Integer getCharacter() {
		return character;
	}
	public void setCharacter(Integer character) {
		this.character = character;
	}
	public Integer getQuality() {
		return quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public int getNewMessageNumber() {
		return newMessageNumber;
	}
	public void setNewMessageNumber(int newMessageNumber) {
		this.newMessageNumber = newMessageNumber;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	/**
	 * 把手机号或者用户名放入user，并且把密码放入user
	 * @param loginName 登陆号
	 * @param password 密码
	 */
	private void setLoginNameAndPassword(String loginName,String password){
		this.judgeLoginNameIsUserNameOrCellPhone(loginName);
		this.setPassWord(password);
	}
	
	/**
	 * 判断loginName是手机号或者账号，然后放入user中
	 * @param loginName 传入的登陆名字
	 */
	private void judgeLoginNameIsUserNameOrCellPhone(String loginName){
		if(Verify.isMobileNO(loginName))
			this.setCellPhone(loginName);
		else
			this.setUserName(loginName);
	} 
	
	/**
	 * 设置默认自我介绍
	 */
	public void setDefaultIntroduce() {
		this.setIntroduce(Text.HELLO+this.getUserName());
	}

}
