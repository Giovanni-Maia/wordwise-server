package com.wordwise.server.resource;

import org.restlet.resource.Put;

import com.wordwise.server.dto.DTODifficulty;

/**
 * This class defines the interface for web services related to Difficulty
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public interface DifficultyResource {
	public static final String RESOURCE_NAME = "difficulties";

	/**
	 *  adds a new difficulty related to a word to the database
	 */
	@Put
	public void add(DTODifficulty wordDifficulty);
}
