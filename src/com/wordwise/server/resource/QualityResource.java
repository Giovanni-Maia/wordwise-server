package com.wordwise.server.resource;

import org.restlet.resource.Put;

import com.wordwise.server.dto.DTOQuality;

/**
 * This class defines the interface for web services related to Quality
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public interface QualityResource
{
	public static final String RESOURCE_NAME = "qualities";
	
	/**
	 * adds a new quality related to a word to the database
	 * */
	@Put
    public void add(DTOQuality wordQuality);
}
