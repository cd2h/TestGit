package org.lrf.old_driver.enumeration;

public enum Sex {
	BOY(1, "男"), 
	GIRL(0, "女");
	private Integer value;
	private String text;

	private Sex(Integer value, String text) {
		this.value = value;
		this.text = text;

	}

	public Integer getValue(Sex sex) {
		return sex.value;
	}

	public String getText(Sex sex) {
		return sex.text;
	}

	public static Sex getSexByValue(String value) {
		Sex[] sexs = Sex.values();
		for (Sex sex : sexs) {
			if (sex.value.equals(value)) {
				return sex;
			}
		}
		return null;
	}

	public static Sex getSexByText(String text) {
		Sex[] sexs = Sex.values();
		for (Sex sex : sexs) {
			if (sex.text.equals(text)) {
				return sex;
			}
		}
		return null;
	}
}
