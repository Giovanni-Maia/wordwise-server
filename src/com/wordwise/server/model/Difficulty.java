package com.wordwise.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wordwise.server.model.Word;

@Entity
@Table(name="DIFFICULTY")
public class Difficulty {
	
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
}
