package com.wordwise.server.resource;

import org.restlet.resource.Post;
import org.restlet.resource.Put;

import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.parameter.ListDTOTranslation;
import com.wordwise.server.dto.parameter.ListTranslationParameters;

/**
 * This class defines the interface for web services related to Translations
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public interface TranslationResource {
	public static final String RESOURCE_NAME = "translations";

	/**
	 * Adds a new translation to the database
	 * 
	 * @param translation
	 *            the translation to be added
	 */
	@Put
	public void add(DTOTranslation translation);

	/**
	 * Gets a list of translations from the database which matches to the given
	 * parameters
	 * 
	 * @param parameters
	 *            parameters that specifies which kind of and how many
	 *            translations needed
	 * @return a list of DTOTranslation
	 */
	@Post
	public ListDTOTranslation list(ListTranslationParameters parameters);
}
