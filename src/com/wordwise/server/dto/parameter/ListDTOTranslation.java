package com.wordwise.server.dto.parameter;

import java.util.ArrayList;
import java.util.List;

import com.wordwise.server.dto.DTOTranslation;

/**
 * This class defines a specific implementation sub-type of
 * ArrayList<Translation> as part of a workaround for a Restlet problem
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class ListDTOTranslation extends ArrayList<DTOTranslation> {
	private static final long serialVersionUID = 1L;

	public List<DTOTranslation> getDTOTranslationList() {
		List<DTOTranslation> returnList = new ArrayList<DTOTranslation>();
		for (DTOTranslation dtoTranslation : this) {
			returnList.add(dtoTranslation);
		}
		return returnList;
	}
}
