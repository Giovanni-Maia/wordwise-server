package com.wordwise.server.resource;

import org.restlet.resource.Put;

import com.wordwise.server.model.Quality;

public interface QualityResource
{
	public static final String RESOURCE_NAME = "qualities";
	
	@Put
    public void add(Quality wordQualities);
}
