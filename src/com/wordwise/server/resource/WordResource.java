package com.wordwise.server.resource;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Put;

import com.wordwise.server.model.Difficulty;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Word;

public interface WordResource
{
	@Put
    public void add(Word word);
	
	@Get
	public List<Word> list(Language language, Difficulty difficulty, int numberOfWords);
}
