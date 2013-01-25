package com.wordwise.server.resource;

import java.util.List;

import org.restlet.resource.Post;

import com.wordwise.server.model.Word;
import com.wordwise.server.model.parameter.ListWordParameters;

public interface WordResource {
	public static final String RESOURCE_NAME = "words";
	
	@Post
	public List<Word> list(ListWordParameters parameters);
}
