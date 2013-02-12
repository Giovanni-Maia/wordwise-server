package com.wordwise.server.dto;

import java.io.Serializable;

/**
 * This class represents a part of the model that server and clients use
 * commonly. It represents a difficulty instance of a word
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class DTODifficulty implements Serializable {
	private static final long serialVersionUID = 1L;
	public Integer id;
	public DTOWord word;
	public Integer difficulty;

	public static final DTODifficulty EASY = new DTODifficulty(1);
	public static final DTODifficulty MEDIUM = new DTODifficulty(2);
	public static final DTODifficulty HARD = new DTODifficulty(3);

	private DTODifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public DTODifficulty() {
	}

	public static DTODifficulty getByDifficulty(Integer difficulty) {
		switch (difficulty) {
		case 1:
			return EASY;
		case 2:
			return MEDIUM;
		case 3:
			return HARD;
		}
		return null;
	}

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

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
}
