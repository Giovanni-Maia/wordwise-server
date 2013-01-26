package com.wordwise.server.dto;

import java.io.Serializable;


public class DTORate implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Integer id;
	public DTOTranslation translation;
	public Integer rate;
}
