package com.wordwise.server.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wordwise.server.application.HibernateUtil;
import com.wordwise.server.application.TranslationServerResource;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Translation;
import com.wordwise.server.model.Word;
import com.wordwise.server.model.parameter.ListTranslationParameters;
import com.wordwise.server.resource.TranslationResource;

public class WordwiseTestCase {
	
	private static TranslationResource translationResource = new TranslationServerResource();
	private static Language pt = new Language("Portuguese", "pt");
	private static Language de = new Language("German", "de");
	
	@BeforeClass
	public static void prepareDB()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(pt);
			session.save(de);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}		
	}
	
	@AfterClass
	public static void cleanDB()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			
			List<Translation> list = translationResource.list(null);
			Word word = list.get(0).getWord();
			for (Translation translation : list) {
				session.delete(translation);
			}
			session.delete(word);
			session.delete(pt);
			session.delete(de);
			
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
		Translation translation = new Translation();
		translation.setLanguage(pt);
		Word word = new Word();
		word.setWord("table");
		translation.setWord(word);
		translation.setTranslation("mesa");
		
		translationResource.add(translation);
		
		List<Translation> list = translationResource.list(null);
		
		assertEquals(1, list.size());
		
		Translation translationSaved = list.get(0);		
		assertEquals(translationSaved.getTranslation(), translation.getTranslation());
		assertEquals(translationSaved.getWord().getWord(), translation.getWord().getWord());
		assertEquals(translationSaved.getLanguage().getLanguage(), translation.getLanguage().getLanguage());
		assertEquals(translationSaved.getLanguage().getCode(), translation.getLanguage().getCode());
	}

	@Test
	public void testAddTranslationWithExistentWord()
	{
		Translation translation = new Translation();
		translation.setLanguage(de);
		Word word = new Word();
		word.setWord("table");
		translation.setWord(word);
		translation.setTranslation("Tisch");
		
		translationResource.add(translation);
		
		List<Translation> list = translationResource.list(null);
		
		assertEquals(2, list.size());
		
		list = translationResource.list(new ListTranslationParameters(de, null, 5, null));
		
		assertEquals(1, list.size());
		
		Translation translationSaved = list.get(0);		
		assertEquals(translationSaved.getTranslation(), translation.getTranslation());
		assertEquals(translationSaved.getWord().getWord(), translation.getWord().getWord());
		assertEquals(translationSaved.getLanguage().getLanguage(), translation.getLanguage().getLanguage());
		assertEquals(translationSaved.getLanguage().getCode(), translation.getLanguage().getCode());
	}
}
