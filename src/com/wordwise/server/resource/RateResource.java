package com.wordwise.server.resource;

import org.restlet.resource.Put;

import com.wordwise.server.dto.DTORate;

public interface RateResource
{
	public static final String RESOURCE_NAME = "rates";
	
	@Put
    public void add(DTORate translationRating);
}
