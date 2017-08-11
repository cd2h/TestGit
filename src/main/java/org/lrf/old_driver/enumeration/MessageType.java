package org.lrf.old_driver.enumeration;

public enum MessageType {
	SYSTEM_MESSAGE(1, "系统消息"), 
	DETAIL_MESSAGE(2, "detail的消息"), 
	SCHEDULE_MESSAGE(3, "schedule的消息"), 
	COMMON_MESSAGE(4,"common的信息"), 
	OTHER(5, "其他");

	private Integer value;
	private String text;

	private MessageType(Integer value, String text) {
		this.value = value;
		this.text = text;

	}

	public Integer getValue(MessageType messageType) {
		return messageType.value;
	}

	public String getText(MessageType messageType) {
		return messageType.text;
	}

	public static MessageType getMessageTypeByValue(String value) {
		MessageType[] messageTypes = MessageType.values();
		for (MessageType messageType : messageTypes) {
			if (messageType.value.equals(value)) {
				return messageType;
			}
		}
		return null;
	}

	public static MessageType getMessageTypeByText(String text) {
		MessageType[] messageTypes = MessageType.values();
		for (MessageType messageType : messageTypes) {
			if (messageType.text.equals(text)) {
				return messageType;
			}
		}
		return null;
	}
}
