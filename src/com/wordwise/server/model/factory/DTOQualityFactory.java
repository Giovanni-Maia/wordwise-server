package com.wordwise.server.model.factory;

import java.util.ArrayList;
import java.util.List;

import com.wordwise.server.dto.DTOQuality;
import com.wordwise.server.model.Quality;

public class DTOQualityFactory
{
	public static DTOQuality build(Quality quality)
	{
		DTOQuality dtoQuality = new DTOQuality();
		
		dtoQuality.id = quality.getId();
		
		dtoQuality.quality = quality.getQuality();
		
		return dtoQuality;
	}
	
	public static ArrayList<DTOQuality> build(List<Quality> qualityList)
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
