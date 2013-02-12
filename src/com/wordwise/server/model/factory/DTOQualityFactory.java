package com.wordwise.server.model.factory;

import java.util.ArrayList;
import java.util.Set;

import com.wordwise.server.dto.DTOQuality;
import com.wordwise.server.model.Quality;

/**
 * This class defines the methods to make conversion to/from DTOQuality and
 * Quality. It is needed as a workaround for a problem because of Restlet
 * framework
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
public class DTOQualityFactory
{
	public static DTOQuality build(Quality quality)
	{
		DTOQuality dtoQuality = new DTOQuality();
		
		dtoQuality.id = quality.getId();
		
		dtoQuality.quality = quality.getQuality();
		
		return dtoQuality;
	}
	
	public static ArrayList<DTOQuality> build(Set<Quality> qualityList)
	{
		ArrayList<DTOQuality> returnList = new ArrayList<DTOQuality>();
		for (Quality quality : qualityList)
		{
			returnList.add(build(quality));
		}
		return returnList;
	}

	public static Quality build(DTOQuality dtoQuality)
	{
		Quality quality = new Quality();
		
		quality.setQuality(dtoQuality.quality);
		
		quality.setId(dtoQuality.id);
		
		quality.setWord(DTOWordFactory.build(dtoQuality.word));
		
		return quality;
	}
}
