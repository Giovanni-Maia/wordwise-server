package com.wordwise.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class model class is used by Hibernate framework to persist and query
 * data to/from Language table
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
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
	
	public Language() {};
	
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
