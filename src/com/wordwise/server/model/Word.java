package com.wordwise.server.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="WORD")
public class Word implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="WORD")
	private String word;
	
	@OneToMany(targetEntity=Difficulty.class, mappedBy="word", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Difficulty> difficulties;
	
	@OneToMany(targetEntity=Quality.class, mappedBy="word", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Quality> qualities;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Set<Difficulty> getDifficulties() {
		return difficulties;
	}

	public void setDifficulties(Set<Difficulty> difficulties) {
		this.difficulties = difficulties;
	}

	public Set<Quality> getQualities() {
		return qualities;
	}

	public void setQualities(Set<Quality> qualities) {
		this.qualities = qualities;
	}
	
	@Override
	public String toString()
	{
		return id.toString();
	}

	public double getDifficultyAVG()
	{
		double difficultyAVG = 0.0;
		if (difficulties.size() > 0)
		{
			for (Difficulty difficulty : difficulties)
			{
				difficultyAVG += difficulty.getDifficulty();
			}
			difficultyAVG /=  (double) difficulties.size();
		}
		return difficultyAVG;
	}
}
