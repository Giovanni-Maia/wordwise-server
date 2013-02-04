package com.wordwise.server.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wordwise.server.application.HibernateUtil;
import com.wordwise.server.application.TranslationServerResource;
import com.wordwise.server.dto.DTOLanguage;
import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.dto.parameter.ListTranslationParameters;
import com.wordwise.server.model.Language;
import com.wordwise.server.resource.TranslationResource;


public class TranslationResourceTestCase
{
	private static DTOLanguage pt = new DTOLanguage("Portuguese", "pt");
	private static DTOLanguage de = new DTOLanguage("German", "de");
	
	@Before
	public void prepareDB()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(new Language("Portuguese", "pt"));
			session.save(new Language("German", "de"));
			
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}		
	}
	
	@After
	public void cleanDB()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			Query deleteQuery = session.createSQLQuery("delete from quality;");
			deleteQuery.executeUpdate();
			deleteQuery = session.createSQLQuery("delete from rate;");
			deleteQuery.executeUpdate();
			deleteQuery = session.createSQLQuery("delete from difficulty;");
			deleteQuery.executeUpdate();
			deleteQuery = session.createSQLQuery("delete from translation;");
			deleteQuery.executeUpdate();
			deleteQuery = session.createSQLQuery("delete from language;");
			deleteQuery.executeUpdate();
			deleteQuery = session.createSQLQuery("delete from word;");
			deleteQuery.executeUpdate();
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
	}
	
	@Test
	public void testAddTranslationWithNewWord()
	{
		TranslationResource translationResource = new TranslationServerResource();
		
		DTOTranslation translation = new DTOTranslation();
		translation.setLanguage(pt);
		translation.setTranslation("mesa");
		
		DTOWord word = new DTOWord();
		word.setWord("table");
		
		translation.setWord(word);
		
		translationResource.add(translation);
		
		List<DTOTranslation> list = translationResource.list(null);
		
		assertEquals(1, list.size());
		
		DTOTranslation translationSaved = list.get(0);		
		assertEquals(translationSaved.getTranslation(), translation.getTranslation());
		assertEquals(translationSaved.getWord().getWord(), translation.getWord().getWord());
		assertEquals(translationSaved.getLanguage().getLanguage(), translation.getLanguage().getLanguage());
		assertEquals(translationSaved.getLanguage().getCode(), translation.getLanguage().getCode());
	}

	@Test
	public void testAddTranslationWithExistentWord()
	{
		TranslationResource translationResource = new TranslationServerResource();
		
		DTOTranslation translation = new DTOTranslation();
		translation.setLanguage(pt);
		translation.setTranslation("mesa");
		
		DTOWord word = new DTOWord();
		word.setWord("table");
		
		translation.setWord(word);
		
		translationResource.add(translation);
		
		List<DTOTranslation> list = translationResource.list(null);
		word = list.get(0).getWord();
		
		translation = new DTOTranslation();
		translation.setLanguage(de);
		translation.setWord(word);
		translation.setTranslation("Tisch");
		
		translationResource.add(translation);
		
		list = translationResource.list(new ListTranslationParameters(de, null, 5, null));
		
		assertEquals(1, list.size());
		
		DTOTranslation translationSaved = list.get(0);		
		assertEquals(translationSaved.getTranslation(), translation.getTranslation());
		assertEquals(translationSaved.getWord().getWord(), translation.getWord().getWord());
		assertEquals(translationSaved.getLanguage().getLanguage(), translation.getLanguage().getLanguage());
		assertEquals(translationSaved.getLanguage().getCode(), translation.getLanguage().getCode());
	}

	@Test
	public void testListTranslationsNotIn()
	{
		TranslationResource translationResource = new TranslationServerResource();
		
		DTOTranslation translation = new DTOTranslation();
		translation.setLanguage(pt);
		translation.setTranslation("mesa");
		
		DTOWord word = new DTOWord();
		word.setWord("table");
		
		translation.setWord(word);
		
		translationResource.add(translation);
		
		List<DTOTranslation> list = translationResource.list(null);
		word = list.get(0).getWord();
		
		translation = new DTOTranslation();
		translation.setLanguage(de);
		translation.setWord(word);
		translation.setTranslation("Tisch");
		
		translationResource.add(translation);
		
		list = translationResource.list(new ListTranslationParameters(de, null, 5, null));
		
		assertEquals(1, list.size());
		
		list = translationResource.list(new ListTranslationParameters(null, null, 5, list));
		
		assertEquals(1, list.size());
	}
}
