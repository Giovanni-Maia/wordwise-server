package com.wordwise.server.dto.parameter;

import java.io.Serializable;

/**
 * This class encapsulates all the parameters that might be needed when listing
 * words. It is sent from client to server when listing words.
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
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

