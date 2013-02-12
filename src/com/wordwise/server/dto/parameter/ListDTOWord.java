package com.wordwise.server.dto.parameter;

import java.util.ArrayList;
import java.util.List;

import com.wordwise.server.dto.DTOWord;

/**
 * This class defines a specific implementation sub-type of
 * ArrayList<Word> as part of a workaround for a Restlet problem
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class ListDTOWord extends ArrayList<DTOWord>
{
	private static final long serialVersionUID = 1L;
	
	public List<DTOWord> getDTOWordList()
	{
		List<DTOWord> returnList = new ArrayList<DTOWord>();
		for (DTOWord dtoWord : this) {
			returnList.add(dtoWord);
		}
		return returnList;
	}
}
