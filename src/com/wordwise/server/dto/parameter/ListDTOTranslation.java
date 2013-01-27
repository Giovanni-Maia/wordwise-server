package com.wordwise.server.dto.parameter;

import java.util.ArrayList;
import java.util.List;

import com.wordwise.server.dto.DTOTranslation;

public class ListDTOTranslation extends ArrayList<DTOTranslation>
{
	private static final long serialVersionUID = 1L;
	
	public List<DTOTranslation> getDTOWordList()
	{
		List<DTOTranslation> returnList = new ArrayList<DTOTranslation>();
		for (DTOTranslation dtoTranslation : this) {
			returnList.add(dtoTranslation);
		}
		return returnList;
	}
}
