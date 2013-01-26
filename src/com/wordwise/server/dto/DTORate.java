package com.wordwise.server.dto;

import java.io.Serializable;


public class DTORate implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Integer id;
	public DTOTranslation translation;
	public Integer rate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public DTOTranslation getTranslation() {
		return translation;
	}
	public void setTranslation(DTOTranslation translation) {
		this.translation = translation;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
}
