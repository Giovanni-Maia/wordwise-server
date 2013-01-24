package com.wordwise.server.resource;

import java.util.List;

import org.restlet.resource.Post;

import com.wordwise.server.model.Word;

public interface WordResource {
	public static final String RESOURCE_NAME = "words";
	
	@Post
	public List<Word> list(int number);
}
