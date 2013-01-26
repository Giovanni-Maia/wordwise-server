package com.wordwise.server.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import com.wordwise.server.application.WordServerResource;
import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.model.parameter.ListWordParameters;
import com.wordwise.server.resource.WordResource;

public class WordResourceTestCase
{
	@Test
	public void testListWord()
	{
		WordResource wordResource = new WordServerResource();
		List<DTOWord> list = wordResource.list(new ListWordParameters(2));
		assertFalse(list == null);
		assertEquals(list.size(), 2);
	}
}
