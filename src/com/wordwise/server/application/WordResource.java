package com.wordwise.server.application;

import org.restlet.resource.Put;

import com.wordwise.server.model.Word;

public interface WordResource
{
	@Put
    public void addWord(Word word);
}
