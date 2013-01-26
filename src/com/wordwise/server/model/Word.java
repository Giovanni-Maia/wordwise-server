package com.wordwise.server.model;

import java.io.Serializable;
import java.util.List;

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
	
	@OneToMany(targetEntity=Difficulty.class, mappedBy="word")//, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Difficulty> difficulties;
	
	@OneToMany(targetEntity=Quality.class, mappedBy="word")//, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Quality> qualities;

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

	public List<Difficulty> getDifficulties() {
		return difficulties;
	}

	public void setDifficulties(List<Difficulty> difficulties) {
		this.difficulties = difficulties;
	}

	public List<Quality> getQualities() {
		return qualities;
	}

	public void setQualities(List<Quality> qualities) {
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

	public double getQualityAVG()
	{
		double qualityAVG = 0.0;
		if (qualities.size() > 0)
		{
			for (Quality quality : qualities)
			{
				qualityAVG += quality.getQuality();
			}
			qualityAVG /=  (double) qualities.size();
		}
		return qualityAVG;
	}
}
