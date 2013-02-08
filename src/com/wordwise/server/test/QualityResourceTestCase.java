package com.wordwise.server.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wordwise.server.application.HibernateUtil;
import com.wordwise.server.application.QualityServerResource;
import com.wordwise.server.application.TranslationServerResource;
import com.wordwise.server.dto.DTOLanguage;
import com.wordwise.server.dto.DTOQuality;
import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.dto.parameter.ListTranslationParameters;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Translation;
import com.wordwise.server.model.Word;
import com.wordwise.server.resource.QualityResource;
import com.wordwise.server.resource.TranslationResource;


public class QualityResourceTestCase
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
			deleteQuery = session.createSQLQuery("delete from Quality;");
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
	public void testAddWordQuality()
	{
		TranslationResource translationResource = new TranslationServerResource();
		QualityResource qualityResource = new QualityServerResource();
		
		List<DTOTranslation> list = translationResource.list(null);
		DTOWord word = list.get(0).getWord();
		
		DTOQuality quality = new DTOQuality();
		quality.setQuality(1);
		quality.setWord(word);

		qualityResource.add(quality);
		
		list = translationResource.list(new ListTranslationParameters(pt, null, 5, null));
		assertEquals(1, list.size());
		
		quality = new DTOQuality();
		quality.setQuality(-1);
		quality.setWord(word);

		qualityResource.add(quality);
		
		quality = new DTOQuality();
		quality.setQuality(-1);
		quality.setWord(word);

		qualityResource.add(quality);
		
		list = translationResource.list(new ListTranslationParameters(pt, null, 5, null));
		assertEquals(0, list.size());
	}
}
