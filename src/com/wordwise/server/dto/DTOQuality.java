package com.wordwise.server.dto;

import java.io.Serializable;

/**
 * This class represents a part of the model that server and clients use
 * commonly. It represents a quality evaluation for a specific word
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class DTOQuality implements Serializable {
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
