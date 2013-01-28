package com.wordwise.server.model.factory;

import java.util.ArrayList;
import java.util.Set;

import com.wordwise.server.dto.DTODifficulty;
import com.wordwise.server.model.Difficulty;

public class DTODifficultyFactory
{
	public static DTODifficulty build(Difficulty difficulty)
	{
		DTODifficulty dtoDifficulty = new DTODifficulty();
		
		dtoDifficulty.id = difficulty.getId();
		
		dtoDifficulty.difficulty = difficulty.getDifficulty();
		
		return dtoDifficulty;
	}
	
	public static ArrayList<DTODifficulty> build(Set<Difficulty> difficultyList)
	{
		ArrayList<DTODifficulty> returnList = new ArrayList<DTODifficulty>();
		for (Difficulty difficulty : difficultyList)
		{
			returnList.add(build(difficulty));
		}
		return returnList;
	}

	public static Difficulty build(DTODifficulty dtoDifficulty)
	{
		Difficulty difficulty = new Difficulty();
		
		difficulty.setDifficulty(dtoDifficulty.difficulty);
		
		difficulty.setId(dtoDifficulty.id);
		
		difficulty.setWord(DTOWordFactory.build(dtoDifficulty.word));
		
		return difficulty;
	}
}
