package com.wordwise.server.resource;

import java.util.List;

import org.restlet.resource.Post;
import org.restlet.resource.Put;

import com.wordwise.server.model.Translation;
import com.wordwise.server.model.parameter.ListTranslationParameters;

public interface TranslationResource
{
	public static final String RESOURCE_NAME = "translations";
	
	@Put
    public void add(Translation translation);
	
	@Post
	public List<Translation> list(ListTranslationParameters parameters);
}
