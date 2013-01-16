package com.wordwise.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LANGUAGE")
public class Language implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public Language (String language, String code)
	{
		this.code = code;
		this.language = language;
	}
	
	@Id
	@Column(name="CODE")
	private String code;
	
	@Column(name="LANGUAGE")
	private String language;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
