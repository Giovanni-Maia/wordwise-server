package com.wordwise.server.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.wordwise.server.model.Difficulty;

public class DTODifficulty implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Integer id;
	public DTOWord word;
	public Integer difficulty;
	
	public static DTODifficulty build(Difficulty difficulty)
	{
		DTODifficulty dtoDifficulty = new DTODifficulty();
		
		dtoDifficulty.id = difficulty.getId();
		
		dtoDifficulty.difficulty = difficulty.getDifficulty();
		
		return dtoDifficulty;
	}
	
	public static ArrayList<DTODifficulty> build(List<Difficulty> difficultyList)
	{
		ArrayList<DTODifficulty> returnList = new ArrayList<DTODifficulty>();
		for (Difficulty difficulty : difficultyList)
		{
			returnList.add(build(difficulty));
		}
		return returnList;
	}
}
