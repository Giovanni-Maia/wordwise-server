package com.wordwise.server.resource;

import java.util.List;

import org.restlet.resource.Post;
import org.restlet.resource.Put;

import com.wordwise.server.model.Word;
import com.wordwise.server.model.parameter.ListWordParameters;

public interface WordResource
{
	public static final String RESOURCE_NAME = "words";
	
	@Put
    public void add(Word word);
	
	@Post
	public List<Word> list(ListWordParameters parameters);
}
