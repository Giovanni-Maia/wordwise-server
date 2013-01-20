package com.wordwise.server.resource;

import java.util.List;

import org.restlet.resource.Put;

import com.wordwise.server.model.Rate;

public interface RateResource
{
	public static final String RESOURCE_NAME = "rates";
	
	@Put
    public void add(Rate translationRatings);
}
