package com.wordwise.server.model.parameter;

import java.io.Serializable;
import java.util.List;

import com.wordwise.server.model.Difficulty;
import com.wordwise.server.model.Word;

public class ListWordParameters implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Difficulty difficulty;
	private int numberOfWords;
	private List<Word> WordsAlreadyUsed;
	
	public ListWordParameters(Difficulty difficulty, int numberOfWords, List<Word> WordsAlreadyUsed)
	{
		super();
		this.difficulty = difficulty;
		this.numberOfWords = numberOfWords;
		this.WordsAlreadyUsed = WordsAlreadyUsed;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public int getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public List<Word> getWordsAlreadyUsed() {
		return WordsAlreadyUsed;
	}

	public void setWordsAlreadyUsed(List<Word> WordsAlreadyUsed) {
		this.WordsAlreadyUsed = WordsAlreadyUsed;
	}
}
