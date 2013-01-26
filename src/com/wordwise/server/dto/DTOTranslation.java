package com.wordwise.server.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class DTOTranslation implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Integer id;
	public String translation;
	public DTOWord word;
	public DTOLanguage language;
	public ArrayList<DTORate> rates;
}
