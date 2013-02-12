package com.wordwise.server.dto;

import java.io.Serializable;

/**
 * This class represents a part of the model that server and clients use
 * commonly. It represents a specific language
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class DTOLanguage implements Serializable {
	private static final long serialVersionUID = 1L;
	// code of the language, i.e. en
	public String code;
	// Name of the language, i.e. English
	public String language;

	public DTOLanguage() {
	}

	public DTOLanguage(String language, String code) {
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
