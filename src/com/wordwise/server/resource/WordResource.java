package com.wordwise.server.resource;

import java.util.List;

import com.wordwise.server.model.Word;

public interface WordResource {
	public static final String RESOURCE_NAME = "words";
	
	public List<Word> list(int number);
}
