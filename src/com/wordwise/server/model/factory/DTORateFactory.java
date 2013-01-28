package com.wordwise.server.model.factory;

import java.util.ArrayList;
import java.util.Set;

import com.wordwise.server.dto.DTORate;
import com.wordwise.server.model.Rate;

public class DTORateFactory
{
	public static DTORate build(Rate rate)
	{
		DTORate dtoRate = new DTORate();
		
		dtoRate.id = rate.getId();
		
		dtoRate.rate = rate.getRate();
		
		return dtoRate;
	}
	
	public static ArrayList<DTORate> build(Set<Rate> rateList)
	{
		ArrayList<DTORate> returnList = new ArrayList<DTORate>();
		for (Rate rate : rateList)
		{
			returnList.add(build(rate));
		}
		return returnList;
	}

	public static Rate build(DTORate dtoRate)
	{
		Rate rate = new Rate();
		rate.setId(dtoRate.id);
		rate.setRate(dtoRate.rate);
		rate.setTranslation(DTOTranslationFactory.build(dtoRate.translation));
		return rate;
	}
}
