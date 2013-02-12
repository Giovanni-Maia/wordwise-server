package com.wordwise.server.resource;

import org.restlet.resource.Post;

import com.wordwise.server.dto.parameter.ListDTOWord;
import com.wordwise.server.dto.parameter.ListWordParameters;

/**
 * This class defines the interface for web services related to Words
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public interface WordResource {
	public static final String RESOURCE_NAME = "words";
	
	/**
	 * 
	 * @param parameters
	 *            parameters that specifies which kind of and how many
	 *            words needed
	 * @return a list of DTOWord
	 */
	@Post
	public ListDTOWord list(ListWordParameters parameters);
}
