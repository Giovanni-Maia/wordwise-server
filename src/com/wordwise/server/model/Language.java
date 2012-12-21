package com.wordwise.server.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Language
{	
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
