package com.wordwise.server.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wordwise.server.application.DifficultyServerResource;
import com.wordwise.server.application.HibernateUtil;
import com.wordwise.server.application.TranslationServerResource;
import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.model.Difficulty;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Translation;
import com.wordwise.server.model.Word;
import com.wordwise.server.model.factory.DTODifficultyFactory;
import com.wordwise.server.model.factory.DTOTranslationFactory;
import com.wordwise.server.model.factory.DTOWordFactory;
import com.wordwise.server.model.parameter.ListTranslationParameters;
import com.wordwise.server.resource.DifficultyResource;
import com.wordwise.server.resource.TranslationResource;

public class DifficultyResourceTestCase
{
	/*private static DifficultyResource difficultyResource = new DifficultyServerResource();
	private static TranslationResource translationResource = new TranslationServerResource();
	private static Language pt = new Language("Portuguese", "pt");
	private static Word word = new Word();
	
	@BeforeClass
	public static void prepareDB()
	{
		word.setWord("table");
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(pt);
			session.save(word);
			Translation translation = new Translation();
			translation.setLanguage(pt);
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
			
			List<DTOTranslation> list = translationResource.list(null);
			DTOWord word = list.get(0).word;
			for (DTOTranslation translation : list) {
				session.delete(DTOTranslationFactory.build(translation));
			}
			session.delete(DTOWordFactory.build(word));
			session.delete(pt);
			
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
		Difficulty difficulty = Difficulty.EASY;
		difficulty.setWord(word);

		difficultyResource.add(DTODifficultyFactory.build(difficulty));
		
		List<DTOTranslation> list = translationResource.list(new ListTranslationParameters(pt, Difficulty.EASY, 5, null));
		assertEquals(1, list.size());
		
		list = translationResource.list(new ListTranslationParameters(pt, Difficulty.MEDIUM, 5, null));
		assertEquals(0, list.size());
		
		difficulty = Difficulty.MEDIUM;
		difficulty.setWord(word);

		difficultyResource.add(difficulty);
		
		difficulty = Difficulty.MEDIUM;
		difficulty.setWord(word);

		difficultyResource.add(difficulty);
		
		list = translationResource.list(new ListTranslationParameters(pt, Difficulty.EASY, 5, null));
		assertEquals(0, list.size());
		
		list = translationResource.list(new ListTranslationParameters(pt, Difficulty.MEDIUM, 5, null));
		assertEquals(1, list.size());
	}*/
}
