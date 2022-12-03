package com.confety.mail.dto;

import java.util.List;

public class SendRequest {

	private String to;
	
	private String subject;
	
	private Integer template;
	
	private List<MetaData> metaData;

	public SendRequest() {
		super();
	}

	public SendRequest(String to, String subject, Integer template, List<MetaData> metaData) {
		super();
		this.to = to;
		this.subject = subject;
		this.template = template;
		this.metaData = metaData;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getTemplate() {
		return template;
	}

	public void setTemplate(Integer template) {
		this.template = template;
	}

	public List<MetaData> getMetaData() {
		return metaData;
	}

	public void setMetaData(List<MetaData> metaData) {
		this.metaData = metaData;
	}

}
