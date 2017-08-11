package org.lrf.old_driver.service;

import java.util.List;

import org.lrf.old_driver.entity.Message;

public interface MessageService {
	public Message createMessage(int messageType,String userId,String detailId);
	
	public List<Message> findMessagesByUserId(String userId);
	
	public List<Message> findUnreadMessagesByUserId(String userId);
}
