package com.wordwise.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wordwise.server.model.Word;

@Entity
@Table(name="QUALITY")
public class Quality implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne(targetEntity=Word.class)
	@JoinColumn(name="WORD_ID")
	private Word word;
	
	@Column(name="QUALITY")
	private Integer quality;

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

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}
}
