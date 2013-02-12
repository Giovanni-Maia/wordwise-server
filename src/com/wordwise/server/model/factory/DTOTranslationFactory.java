package com.wordwise.server.model.factory;

import java.util.List;

import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.parameter.ListDTOTranslation;
import com.wordwise.server.model.Translation;

/**
 * This class defines the methods to make conversion to/from DTOTranslation and
 * Translation. It is needed as a workaround for a problem because of Restlet
 * framework
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class DTOTranslationFactory
{
	public static DTOTranslation build(Translation translation)
	{
		DTOTranslation dtoTranslation = new DTOTranslation();
		
		dtoTranslation.id = translation.getId();
		
		dtoTranslation.translation = translation.getTranslation();
		
		dtoTranslation.language = DTOLanguageFactory.build(translation.getLanguage());
		
		dtoTranslation.rates = DTORateFactory.build(translation.getRates());
		
		dtoTranslation.word = DTOWordFactory.build(translation.getWord());
		
		return dtoTranslation;
	}
	
	public static ListDTOTranslation build(List<Translation> translationList)
	{
		ListDTOTranslation returnList = new ListDTOTranslation();
		for (Translation translation : translationList)
		{
			returnList.add(build(translation));
		}
		return returnList;
	}

	public static Translation build(DTOTranslation dtoTranslation)
	{
		Translation translation = new Translation();
		translation.setId(dtoTranslation.id);
		translation.setTranslation(dtoTranslation.translation.trim());
		translation.setWord(DTOWordFactory.build(dtoTranslation.getWord()));
		translation.setLanguage(DTOLanguageFactory.build(dtoTranslation.getLanguage()));
		return translation;
	}
}
