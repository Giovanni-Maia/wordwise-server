package com.wordwise.server.resource;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Put;

import com.wordwise.server.model.Difficulty;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Translation;

public interface TranslationResource
{
	public static final String RESOURCE_NAME = "translations";
	
	@Put
    public void add(Translation translation);
	
	@Get
	public List<Translation> list(Language language, Difficulty difficulty, int numberOfWords);
}
