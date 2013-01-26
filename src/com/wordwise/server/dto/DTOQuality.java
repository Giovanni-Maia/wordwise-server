package com.wordwise.server.dto;

import java.io.Serializable;


public class DTOQuality implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Integer id;
	public DTOWord word;
	public Integer quality;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public DTOWord getWord() {
		return word;
	}
	public void setWord(DTOWord word) {
		this.word = word;
	}
	public Integer getQuality() {
		return quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
}
