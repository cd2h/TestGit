package org.lrf.old_driver.enumeration;

public enum TripMode {
	PUBLIC_TRANSPORTATION(1, "公共交通"), 
	PRIVATE_CAR(2, "私家车"), 
	BICYCLE(3, "自行车"),
	WALKING(4, "步行");
	
	private Integer value;
	private String text;

	private TripMode(Integer value, String text) {
		this.value = value;
		this.text = text;

	}

	public Integer getValue(TripMode tripMode) {
		return tripMode.value;
	}

	public String getText(TripMode tripMode) {
		return tripMode.text;
	}

	public static TripMode getTripModeByValue(String value) {
		TripMode[] tripModes = TripMode.values();
		for (TripMode tripMode : tripModes) {
			if (tripMode.value.equals(value)) {
				return tripMode;
			}
		}
		return null;
	}

	public static TripMode getTripModeByText(String text) {
		TripMode[] tripModes = TripMode.values();
		for (TripMode tripMode : tripModes) {
			if (tripMode.text.equals(text)) {
				return tripMode;
			}
		}
		return null;
	}
}
