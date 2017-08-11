package org.lrf.old_driver.enumeration;

public enum ScheduleStataCode {
	NOT_SELECTED(1, "没有被选择"), 
	SELECTED(2, "被选了"), 
	WAITING_FOR_EVALUATION(3, "旅行结束等待评价"), 
	EVALUSTED(4,"已经评价");
	
	private Integer value;
	private String text;

	private ScheduleStataCode(Integer value, String text) {
		this.value = value;
		this.text = text;

	}

	public Integer getValue(ScheduleStataCode scheduleStataCode) {
		return scheduleStataCode.value;
	}

	public String getText(ScheduleStataCode scheduleStataCode) {
		return scheduleStataCode.text;
	}

	public static ScheduleStataCode getScheduleStataCodeByValue(String value) {
		ScheduleStataCode[] scheduleStataCodes = ScheduleStataCode.values();
		for (ScheduleStataCode scheduleStataCode : scheduleStataCodes) {
			if (scheduleStataCode.value.equals(value)) {
				return scheduleStataCode;
			}
		}
		return null;
	}

	public static ScheduleStataCode getScheduleStataCodeByText(String text) {
		ScheduleStataCode[] scheduleStataCodes = ScheduleStataCode.values();
		for (ScheduleStataCode scheduleStataCode : scheduleStataCodes) {
			if (scheduleStataCode.text.equals(text)) {
				return scheduleStataCode;
			}
		}
		return null;
	}
}
