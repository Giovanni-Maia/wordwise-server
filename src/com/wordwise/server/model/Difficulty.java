package com.wordwise.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DIFFICULTY")
public class Difficulty implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public static final Difficulty EASY = new Difficulty(1);
	public static final Difficulty MEDIUM = new Difficulty(2);
	public static final Difficulty HARD = new Difficulty(3);
	
	private Difficulty (int difficulty)
	{
		this.difficulty = difficulty;  
	}
	
	public Difficulty()	{}
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne(targetEntity=Word.class)
	@JoinColumn(name="WORD_ID")
	private Word word;
	
	@Column(name="DIFFICULTY")
	private Integer difficulty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	
	public static Difficulty getByDifficulty(Integer difficulty)
	{
		switch(difficulty)
		{
			case 1: return EASY;
			case 2: return MEDIUM;
			case 3: return HARD;
		}
		return null;
	}
}
