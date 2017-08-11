package org.lrf.old_driver.entity;

import java.util.List;

public class Message {
	
	private String id;
	private String title;
	private String content;
	private String userId;
	private boolean isRead;
	
	/**
	 * 消息类型
	 * 1 系统消息
	 * 2 detail的消息
	 * 3 schedule的消息
	 * 4 common的信息
	 * 5 其他
	 */
	private int messageType;/***/
	
	/**
	 * 消息所对应的detail id
	 */
	private String detailId;
	/**
	 * 消息所对应的schedule id
	 */
	private String scheduleId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
}
