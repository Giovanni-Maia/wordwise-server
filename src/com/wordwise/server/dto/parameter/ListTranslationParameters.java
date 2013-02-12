package com.wordwise.server.dto.parameter;

import java.io.Serializable;
import java.util.List;

import com.wordwise.server.dto.DTODifficulty;
import com.wordwise.server.dto.DTOLanguage;
import com.wordwise.server.dto.DTOTranslation;

/**
 * This class encapsulates all the parameters that might be needed when listing
 * translations. It is sent from client to server when listing translations.
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class ListTranslationParameters implements Serializable {
	private static final long serialVersionUID = 1L;

	private DTOLanguage language;
	private DTODifficulty difficulty;
	private int numberOfTranslations;
	private List<DTOTranslation> translationsAlreadyUsed;

	public ListTranslationParameters(DTOLanguage language,
			DTODifficulty difficulty, int numberOfTranslations,
			List<DTOTranslation> translationsAlreadyUsed) {
		super();
		this.language = language;
		this.difficulty = difficulty;
		this.numberOfTranslations = numberOfTranslations;
		this.translationsAlreadyUsed = translationsAlreadyUsed;
	}

	public DTOLanguage getLanguage() {
		return language;
	}

	public void setLanguage(DTOLanguage language) {
		this.language = language;
	}

	public DTODifficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(DTODifficulty difficulty) {
		this.difficulty = difficulty;
	}

	public int getNumberOfTranslations() {
		return numberOfTranslations;
	}

	public void setNumberOfTranslations(int numberOfTranslations) {
		this.numberOfTranslations = numberOfTranslations;
	}

	public List<DTOTranslation> getTranslationsAlreadyUsed() {
		return translationsAlreadyUsed;
	}

	public void setTranslationsAlreadyUsed(
			List<DTOTranslation> translationsAlreadyUsed) {
		this.translationsAlreadyUsed = translationsAlreadyUsed;
	}
}
