package org.lrf.old_driver.enumeration;

public enum Type {
	LOGIN(1, "login"), 
	REGISTER(2, "register");
	
	private Integer value;
	private String text;

	private Type(Integer value, String text) {
		this.value = value;
		this.text = text;

	}

	public Integer getValue() {
		return this.value;
	}

	public String getText() {
		return this.text;
	}

	public static Type getDetailStateCodeByValue(String value) {
		Type[] detailStateCodes = Type.values();
		for (Type detailStateCode : detailStateCodes) {
			if (detailStateCode.value.equals(value)) {
				return detailStateCode;
			}
		}
		return null;
	}

	public static Type getDetailStateCodeByText(String text) {
		Type[] detailStateCodes = Type.values();
		for (Type detailStateCode : detailStateCodes) {
			if (detailStateCode.text.equals(text)) {
				return detailStateCode;
			}
		}
		return null;
	}
}
