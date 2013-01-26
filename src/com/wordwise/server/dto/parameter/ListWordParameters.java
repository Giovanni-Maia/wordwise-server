package com.wordwise.server.dto.parameter;

import java.io.Serializable;

public class ListWordParameters implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer numberOfWords;
	
	public ListWordParameters(int numberOfWords )
	{
		super();
		this.setNumberOfWords(numberOfWords);
	}

	public int getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

}

