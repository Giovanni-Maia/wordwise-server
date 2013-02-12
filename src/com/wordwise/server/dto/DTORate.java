package com.wordwise.server.dto;

import java.io.Serializable;

/**
 * This class represents a part of the model that server and clients use
 * commonly. It represents a rating evaluation for a specific translation
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
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
