package com.wordwise.server.resource;

import org.restlet.resource.Put;

import com.wordwise.server.model.Difficulty;

public interface DifficultyResource {
	public static final String RESOURCE_NAME = "difficulties";
	
	@Put
    public void add(Difficulty wordDifficulties);
}
