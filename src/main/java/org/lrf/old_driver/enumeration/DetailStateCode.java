package org.lrf.old_driver.enumeration;

public enum DetailStateCode {
	WAITING_SCHEDULE(1, "等待行程"), 
	SCHEDULE_CHOOSEN(2, "已有行程确认"), 
	TRAVELING(3, " 正在旅行"), 
	WAITING_FOR_EVALUATION(4, "旅行结束等待评价"), 
	EVALUSTED(5, "评价结束");
	
	private Integer value;
	private String text;

	private DetailStateCode(Integer value, String text) {
		this.value = value;
		this.text = text;

	}

	public Integer getValue(DetailStateCode detailStateCode) {
		return detailStateCode.value;
	}

	public String getText(DetailStateCode detailStateCode) {
		return detailStateCode.text;
	}

	public static DetailStateCode getDetailStateCodeByValue(String value) {
		DetailStateCode[] detailStateCodes = DetailStateCode.values();
		for (DetailStateCode detailStateCode : detailStateCodes) {
			if (detailStateCode.value.equals(value)) {
				return detailStateCode;
			}
		}
		return null;
	}

	public static DetailStateCode getDetailStateCodeByText(String text) {
		DetailStateCode[] detailStateCodes = DetailStateCode.values();
		for (DetailStateCode detailStateCode : detailStateCodes) {
			if (detailStateCode.text.equals(text)) {
				return detailStateCode;
			}
		}
		return null;
	}
}
