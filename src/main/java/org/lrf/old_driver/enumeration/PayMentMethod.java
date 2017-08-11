package org.lrf.old_driver.enumeration;

public enum PayMentMethod {
	AA(1, "AA"), 
	BOYS_PAY(2, "男生买单"), 
	GIRLS_PAY(3, "女生买单");
	
	private Integer value;
	private String text;

	private PayMentMethod(Integer value, String text) {
		this.value = value;
		this.text = text;

	}

	public Integer getValue(PayMentMethod payMentMethod) {
		return payMentMethod.value;
	}

	public String getText(PayMentMethod payMentMethod) {
		return payMentMethod.text;
	}

	public static PayMentMethod getPayMentMethodByValue(String value) {
		PayMentMethod[] payMentMethods = PayMentMethod.values();
		for (PayMentMethod payMentMethod : payMentMethods) {
			if (payMentMethod.value.equals(value)) {
				return payMentMethod;
			}
		}
		return null;
	}

	public static PayMentMethod getPayMentMethodByText(String text) {
		PayMentMethod[] payMentMethods = PayMentMethod.values();
		for (PayMentMethod payMentMethod : payMentMethods) {
			if (payMentMethod.text.equals(text)) {
				return payMentMethod;
			}
		}
		return null;
	}
}
