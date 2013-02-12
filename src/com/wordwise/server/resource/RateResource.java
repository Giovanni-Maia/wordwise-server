package com.wordwise.server.resource;

import org.restlet.resource.Put;

import com.wordwise.server.dto.DTORate;

/**
 * This class defines the interface for web services related to rating
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public interface RateResource
{
	public static final String RESOURCE_NAME = "rates";
	
	/**
	 * Adds a new translation rating to database 
	 * @param translationRating rating to be persisted
	 */
	@Put
    public void add(DTORate translationRating);
}
