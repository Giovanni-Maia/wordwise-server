package com.wordwise.server.resource;

import org.restlet.resource.Put;

import com.wordwise.server.model.Word;

public interface WordResource
{
	@Put
    public void addWord(Word word);
}
