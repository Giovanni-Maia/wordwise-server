package com.wordwise.server.resource;

import org.restlet.resource.Put;

import com.wordwise.server.dto.DTOQuality;

public interface QualityResource
{
	public static final String RESOURCE_NAME = "qualities";
	
	@Put
    public void add(DTOQuality wordQuality);
}
