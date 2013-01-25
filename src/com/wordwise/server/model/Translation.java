package com.wordwise.server.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wordwise.server.model.Word;


@Entity
@Table(name="TRANSLATION")
public class Translation implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="TRANSLATION")
	private String translation;
	
	@ManyToOne(targetEntity=Word.class)
	@JoinColumn(name="WORD_ID")
	private Word word;
	
	@ManyToOne(targetEntity=Language.class)
	@JoinColumn(name="LANGUAGE_CODE")
	private Language language;
	
	@OneToMany(targetEntity=Rate.class, mappedBy="translation")
	private Set<Rate> rates;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Set<Rate> getRates() {
		return rates;
	}

	public void setRates(Set<Rate> rates) {
		this.rates = rates;
	}
	
	public double getRateAVG()
	{
		double rateAVG = 0.0;
		if (rates.size() > 0)
		{
			for (Rate rate : rates)
			{
				rateAVG += rate.getRate();
			}
			rateAVG /=  (double) rates.size();
		}
		return rateAVG;
	}
}
