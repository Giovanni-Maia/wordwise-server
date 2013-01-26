package com.wordwise.server.dto;

import java.io.Serializable;


public class DTOLanguage implements Serializable
{
	private static final long serialVersionUID = 1L;
	public String code;
	public String language;
	
	public DTOLanguage(){}
	
	public DTOLanguage (String language, String code)
	{
		this.code = code;
		this.language = language;
	}

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
