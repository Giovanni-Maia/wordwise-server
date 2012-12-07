package com.wordwise.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="WORD")
public class Word {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="WORD")
	private String word;
	
	@OneToMany(targetEntity=Difficulty.class, mappedBy="word")
	private Set<Difficulty> difficulties;
	
	@OneToMany(targetEntity=Quality.class, mappedBy="word")
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
}
