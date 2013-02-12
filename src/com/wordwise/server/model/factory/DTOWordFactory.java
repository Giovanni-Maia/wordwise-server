package com.wordwise.server.model.factory;

import java.util.List;

import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.dto.parameter.ListDTOWord;
import com.wordwise.server.model.Word;

/**
 * This class defines the methods to make conversion to/from DTOWordy and
 * Word. It is needed as a workaround for a problem because of Restlet
 * framework
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class DTOWordFactory
{
 	public static DTOWord build(Word word)
	{
		DTOWord dtoWord = new DTOWord();
		
		dtoWord.id = word.getId();
		
		dtoWord.word = word.getWord();
		
		dtoWord.difficulties = DTODifficultyFactory.build(word.getDifficulties());
		
		dtoWord.qualities = DTOQualityFactory.build(word.getQualities());
		
		return dtoWord;
	}
 	
	public static ListDTOWord build(List<Word> wordList)
	{
		ListDTOWord returnList = new ListDTOWord();
		for (Word word : wordList)
		{
			returnList.add(build(word));
		}
		return returnList;
	}

	public static Word build(DTOWord dtoWord)
	{
		Word word = new Word();
		word.setId(dtoWord.id);
		word.setWord(dtoWord.getWord().trim());
		return word;
	}
}
