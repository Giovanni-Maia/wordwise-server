package com.wordwise.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class model class is used by Hibernate framework to persist and query
 * data to/from Rate table
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
@Entity
@Table(name="RATE")
public class Rate implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne(targetEntity=Translation.class)
	@JoinColumn(name="TRANSLATION_ID")
	private Translation translation;
	
	@Column(name="RATE")
	private Integer rate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Translation getTranslation() {
		return translation;
	}

	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}
}
