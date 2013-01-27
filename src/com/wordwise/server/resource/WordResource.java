package com.wordwise.server.resource;

import org.restlet.resource.Post;

import com.wordwise.server.dto.parameter.ListDTOWord;
import com.wordwise.server.dto.parameter.ListWordParameters;

public interface WordResource {
	public static final String RESOURCE_NAME = "words";
	
	@Post
	public ListDTOWord list(ListWordParameters parameters);
}
