package com.wordwise.server.model.factory;

import java.util.ArrayList;
import java.util.List;

import com.wordwise.server.dto.DTOLanguage;
import com.wordwise.server.model.Language;

/**
 * This class defines the methods to make conversion to/from DTOLanguage and
 * Language. It is needed as a workaround for a problem because of Restlet
 * framework
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
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
	
	public static Language build(DTOLanguage dtoLanguage)
	{
		Language language = new Language();
		language.setCode(dtoLanguage.getCode());
		language.setLanguage(dtoLanguage.getLanguage());
		return language;
	}
}
