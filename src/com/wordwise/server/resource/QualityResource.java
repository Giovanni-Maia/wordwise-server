package com.wordwise.server.resource;

import java.util.List;

import org.restlet.resource.Put;

import com.wordwise.server.model.Quality;

public interface QualityResource
{
	public static final String RESOURCE_NAME = "qualities";
	
	@Put
    public void add(List<Quality> wordQualities);
}
