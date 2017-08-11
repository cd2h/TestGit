package org.lrf.old_driver.entity;

import java.util.Date;
import java.util.List;

public class Detail {
	private String id;
	private String title;
	private City city;
	private Date startDate;
	private Date endDate;
	private Date createDate;
	private String contact;
	private String require;
	private String userId;
	private List<String> schedulesId;
	private List<Comment> comments;
	private long goodNumber;
	private long pv;
	private String personalImageName;
	
	/***
	 *选择schedule的id
	 */
	private String choosenScheduleId;
	
	/**状态码
	 * 1 等待行程 
	 * 2 已有行程确认
	 * 3 正在旅行
	 * 4 旅行结束，等待评价
	 * 5 评价结束
	 * */
	private Integer stateCode;/***/
	
	/**外貌*/
	private Integer appearance;
	
	/**性格*/
	private Integer character;
	
	/**人品*/
	private Integer quality;
	
	/**结束评语*/
	private String  closingComments;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRequire() {
		return require;
	}
	public void setRequire(String require) {
		this.require = require;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getStateCode() {
		return stateCode;
	}
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
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
	public String getClosingComments() {
		return closingComments;
	}
	public void setClosingComments(String closingComments) {
		this.closingComments = closingComments;
	}
	public List<String> getSchedulesId() {
		return schedulesId;
	}
	public void setSchedulesId(List<String> schedulesId) {
		this.schedulesId = schedulesId;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public long getGoodNumber() {
		return goodNumber;
	}
	public void setGoodNumber(long goodNumber) {
		this.goodNumber = goodNumber;
	}
	public long getPv() {
		return pv;
	}
	public void setPv(long pv) {
		this.pv = pv;
	}
	public String getChoosenScheduleId() {
		return choosenScheduleId;
	}
	public void setChoosenScheduleId(String choosenScheduleId) {
		this.choosenScheduleId = choosenScheduleId;
	}
	public String getPersonalImageName() {
		return personalImageName;
	}
	public void setPersonalImageName(String personalImageName) {
		this.personalImageName = personalImageName;
	}
}
