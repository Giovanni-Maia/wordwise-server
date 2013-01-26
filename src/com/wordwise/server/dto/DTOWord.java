package com.wordwise.server.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class DTOWord implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Integer id;
 	public String word;
 	public ArrayList<DTODifficulty> difficulties;
 	public ArrayList<DTOQuality> qualities;
}
