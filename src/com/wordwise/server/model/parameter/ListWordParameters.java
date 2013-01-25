package com.wordwise.server.model.parameter;

import java.io.Serializable;

public class ListWordParameters implements Serializable {

	private static final long serialVersionUID = 1L;

	private int numberOfWords;
	
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

