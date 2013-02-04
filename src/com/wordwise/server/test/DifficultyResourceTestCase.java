package com.wordwise.server.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wordwise.server.application.DifficultyServerResource;
import com.wordwise.server.application.HibernateUtil;
import com.wordwise.server.application.TranslationServerResource;
import com.wordwise.server.dto.DTODifficulty;
import com.wordwise.server.dto.DTOLanguage;
import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.dto.parameter.ListTranslationParameters;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Translation;
import com.wordwise.server.model.Word;
import com.wordwise.server.resource.DifficultyResource;
import com.wordwise.server.resource.TranslationResource;


public class DifficultyResourceTestCase
{
	private static DTOLanguage pt = new DTOLanguage("Portuguese", "pt");
	
	@BeforeClass
	public static void prepareDB()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(new Language("Portuguese", "pt"));
			
			Word word = new Word();
			word.setWord("table");
			session.save(word);
			Translation translation = new Translation();
			translation.setLanguage(new Language("Portuguese", "pt"));
			translation.setWord(word);
			translation.setTranslation("mesa");
			
			session.save(translation);
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
	public void testAddWordDifficulty()
	{
		TranslationResource translationResource = new TranslationServerResource();
		DifficultyResource difficultyResource = new DifficultyServerResource();
		
		List<DTOTranslation> list = translationResource.list(null);
		DTOWord word = list.get(0).getWord();
		
		DTODifficulty difficulty = DTODifficulty.EASY;
		difficulty.setWord(word);

		difficultyResource.add(difficulty);
		
		list = translationResource.list(new ListTranslationParameters(pt, DTODifficulty.EASY, 5, null));
		assertEquals(1, list.size());
		
		list = translationResource.list(new ListTranslationParameters(pt, DTODifficulty.MEDIUM, 5, null));
		assertEquals(0, list.size());
		
		difficulty = DTODifficulty.MEDIUM;
		difficulty.setWord(word);

		difficultyResource.add(difficulty);
		
		difficulty = DTODifficulty.MEDIUM;
		difficulty.setWord(word);

		difficultyResource.add(difficulty);
		
		list = translationResource.list(new ListTranslationParameters(pt, DTODifficulty.EASY, 5, null));
		assertEquals(0, list.size());
		
		list = translationResource.list(new ListTranslationParameters(pt, DTODifficulty.MEDIUM, 5, null));
		assertEquals(1, list.size());
	}
}
