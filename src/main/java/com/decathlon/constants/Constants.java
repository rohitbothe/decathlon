package com.decathlon.constants;

public enum Constants {

	CSV_SEPERATOR(";");

	Constants(String seperator) {
		this.seperator=seperator;
	}
	
	private String seperator;

	public String getSeperator() {
		return seperator;
	}

	public void setSeperator(String seperator) {
		this.seperator = seperator;
	}
}
