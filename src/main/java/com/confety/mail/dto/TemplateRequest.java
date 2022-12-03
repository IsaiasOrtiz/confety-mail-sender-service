package com.confety.mail.dto;

import java.util.List;

public class TemplateRequest {

	private String title;
	
	private String description;
	
	private List<String> vars;

	
	
	public TemplateRequest() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getVars() {
		return vars;
	}

	public void setVars(List<String> vars) {
		this.vars = vars;
	}
	
	
}
