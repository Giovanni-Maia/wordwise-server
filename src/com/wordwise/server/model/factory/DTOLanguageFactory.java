package com.wordwise.server.model.factory;

import java.util.ArrayList;
import java.util.List;

import com.wordwise.server.dto.DTOLanguage;
import com.wordwise.server.model.Language;

public class DTOLanguageFactory
{
	public static DTOLanguage build(Language language)
	{
		DTOLanguage dtoLanguage = new DTOLanguage();
		
		dtoLanguage.code = language.getCode();
		
		dtoLanguage.language = language.getLanguage();
		
		return dtoLanguage;
	}
	
	public static ArrayList<DTOLanguage> build(List<Language> languageList)
	{
		ArrayList<DTOLanguage> returnList = new ArrayList<DTOLanguage>();
		for (Language language : languageList)
		{
			returnList.add(build(language));
		}
		return returnList;
	}
}
