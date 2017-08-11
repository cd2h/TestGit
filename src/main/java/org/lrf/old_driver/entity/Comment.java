package org.lrf.old_driver.entity;

import java.util.Date;

public class Comment {
	private String id;
	private User user;
	private User contacts;
	private Date createDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getContacts() {
		return contacts;
	}
	public void setContacts(User contacts) {
		this.contacts = contacts;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
