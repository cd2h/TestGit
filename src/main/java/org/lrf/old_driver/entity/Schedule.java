package org.lrf.old_driver.entity;

import java.util.Date;
import java.util.List;

public class Schedule {
	private String id;
	private String title;
	private String paymentMethod;/***/
	private String tripMode;/***/
	private String personalImageName;
	private String introduce;
	private String scheduleInfo;
	private Date createDate;
	private String userId;
	private List<Comment> comments;
	private int detailId;
	
	/**
	 * 状态吗
	 * 1 没有被选择
	 * 2 被选了
	 * 3 旅行结束，等待评价
	 * 4 已经评价
	 */
	private int stateCode;/***/

	/**外貌*/
	private Integer appearance;
	
	/**性格*/
	private Integer character;
	
	/**人品*/
	private Integer quality;
	
	/**结束评语*/
	private String  closingComments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTripMode() {
		return tripMode;
	}

	public void setTripMode(String tripMode) {
		this.tripMode = tripMode;
	}

	public String getPersonalImageName() {
		return personalImageName;
	}

	public void setPersonalImageName(String personalImageName) {
		this.personalImageName = personalImageName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getScheduleInfo() {
		return scheduleInfo;
	}

	public void setScheduleInfo(String scheduleInfo) {
		this.scheduleInfo = scheduleInfo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
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
}
