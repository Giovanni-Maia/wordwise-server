package com.wordwise.server.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a part of the model that server and clients use
 * commonly. It represents a concrete English word
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class DTOWord implements Serializable {
	private static final long serialVersionUID = 1L;
	public Integer id;
	public String word;
	public ArrayList<DTODifficulty> difficulties;
	public ArrayList<DTOQuality> qualities;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public ArrayList<DTODifficulty> getDifficulties() {
		return difficulties;
	}

	public void setDifficulties(ArrayList<DTODifficulty> difficulties) {
		this.difficulties = difficulties;
	}

	public ArrayList<DTOQuality> getQualities() {
		return qualities;
	}

	public void setQualities(ArrayList<DTOQuality> qualities) {
		this.qualities = qualities;
	}
}
