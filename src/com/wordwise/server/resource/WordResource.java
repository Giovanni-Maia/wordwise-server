package com.wordwise.server.resource;

import java.util.ArrayList;

import org.restlet.resource.Post;

import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.model.parameter.ListWordParameters;

public interface WordResource {
	public static final String RESOURCE_NAME = "words";
	
	@Post
	public ArrayList<DTOWord> list(ListWordParameters parameters);
}
