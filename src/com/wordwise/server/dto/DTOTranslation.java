package com.wordwise.server.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a part of the model that server and clients use
 * commonly. It represents a concrete translation for a word
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class DTOTranslation implements Serializable {
	private static final long serialVersionUID = 1L;
	public Integer id;
	public String translation;
	public DTOWord word;
	public DTOLanguage language;
	public ArrayList<DTORate> rates;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public DTOWord getWord() {
		return word;
	}

	public void setWord(DTOWord word) {
		this.word = word;
	}

	public DTOLanguage getLanguage() {
		return language;
	}

	public void setLanguage(DTOLanguage language) {
		this.language = language;
	}

	public ArrayList<DTORate> getRates() {
		return rates;
	}

	public void setRates(ArrayList<DTORate> rates) {
		this.rates = rates;
	}
}
