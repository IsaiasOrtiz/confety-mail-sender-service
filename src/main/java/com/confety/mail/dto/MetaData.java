package com.confety.mail.dto;

public class MetaData {

	private String key;
	
	private String value;

	public MetaData() {
		super();
	}

	public MetaData(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
