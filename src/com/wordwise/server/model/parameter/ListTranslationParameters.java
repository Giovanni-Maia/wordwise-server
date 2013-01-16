package com.wordwise.server.model.parameter;

import java.io.Serializable;
import java.util.List;

import com.wordwise.server.model.Difficulty;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Translation;

public class ListTranslationParameters implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Language language;
	private Difficulty difficulty;
	private int numberOfTranslations;
	private List<Translation> translationsAlreadyUsed;
	
	public ListTranslationParameters(Language language, Difficulty difficulty, int numberOfTranslations, List<Translation> translationsAlreadyUsed)
	{
		super();
		this.language = language;
		this.difficulty = difficulty;
		this.numberOfTranslations = numberOfTranslations;
		this.translationsAlreadyUsed = translationsAlreadyUsed;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public int getNumberOfTranslations() {
		return numberOfTranslations;
	}

	public void setNumberOfTranslations(int numberOfTranslations) {
		this.numberOfTranslations = numberOfTranslations;
	}

	public List<Translation> getTranslationsAlreadyUsed() {
		return translationsAlreadyUsed;
	}

	public void setTranslationsAlreadyUsed(List<Translation> translationsAlreadyUsed) {
		this.translationsAlreadyUsed = translationsAlreadyUsed;
	}
}
