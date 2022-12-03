package com.confety.mail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "templates")
public class Templates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String description;
	@Column(length = 1000000)
	private String content;
	
	private String vars;

	public Templates() {
		super();
	}

	public Templates(Integer id, String name, String description, String content, String vars) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.content = content;
		this.vars = vars;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVars() {
		return vars;
	}

	public void setVars(String vars) {
		this.vars = vars;
	}
	
	
	
}
