package com.wordwise.server.resource;

import org.restlet.resource.Post;
import org.restlet.resource.Put;

import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.parameter.ListDTOTranslation;
import com.wordwise.server.dto.parameter.ListTranslationParameters;

public interface TranslationResource
{
	public static final String RESOURCE_NAME = "translations";
	
	@Put
    public void add(DTOTranslation translation);
	
	@Post
	public ListDTOTranslation list(ListTranslationParameters parameters);
}
