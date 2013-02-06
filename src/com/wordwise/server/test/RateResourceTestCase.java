package com.wordwise.server.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wordwise.server.application.HibernateUtil;
import com.wordwise.server.application.RateServerResource;
import com.wordwise.server.application.TranslationServerResource;
import com.wordwise.server.dto.DTOLanguage;
import com.wordwise.server.dto.DTORate;
import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.parameter.ListTranslationParameters;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Translation;
import com.wordwise.server.model.Word;
import com.wordwise.server.resource.RateResource;
import com.wordwise.server.resource.TranslationResource;


public class RateResourceTestCase
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
			Query deleteQuery = session.createSQLQuery("delete from rate;");
			deleteQuery.executeUpdate();
			deleteQuery = session.createSQLQuery("delete from rate;");
			deleteQuery.executeUpdate();
			deleteQuery = session.createSQLQuery("delete from Rate;");
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
	public void testAddWordRate()
	{
		TranslationResource translationResource = new TranslationServerResource();
		RateResource rateResource = new RateServerResource();
		
		List<DTOTranslation> list = translationResource.list(null);
		DTOTranslation translation = list.get(0);
		
		DTORate rate = new DTORate();
		rate.setRate(3);
		rate.setTranslation(translation);

		rateResource.add(rate);
		
		list = translationResource.list(new ListTranslationParameters(pt, null, 5, null));
		assertEquals(1, list.size());
		
		rate = new DTORate();
		rate.setRate(0);
		rate.setTranslation(translation);

		rateResource.add(rate);
		
		rate = new DTORate();
		rate.setRate(0);
		rate.setTranslation(translation);

		rateResource.add(rate);
		
		list = translationResource.list(new ListTranslationParameters(pt, null, 5, null));
		assertEquals(0, list.size());
	}
}
