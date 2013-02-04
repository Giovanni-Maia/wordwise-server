package com.wordwise.server.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wordwise.server.application.HibernateUtil;
import com.wordwise.server.application.WordServerResource;
import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.dto.parameter.ListWordParameters;
import com.wordwise.server.model.Word;
import com.wordwise.server.resource.WordResource;

public class WordResourceTestCase
{
	@BeforeClass
	public static void prepareDB()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			Word word = new Word();
			word.setWord("table");
			session.save(word);
			Word word2 = new Word();
			word2.setWord("door");
			session.save(word2);
			Word word3 = new Word();
			word3.setWord("chair");
			session.save(word3);
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
	public void testListWordNoLimit()
	{
		WordResource wordResource = new WordServerResource();
		List<DTOWord> list = wordResource.list(null);
		assertFalse(list == null);
		assertEquals(list.size(), 3);
	}
	
	@Test
	public void testListWordWithLimit()
	{
		WordResource wordResource = new WordServerResource();
		List<DTOWord> list = wordResource.list(new ListWordParameters(2));
		assertFalse(list == null);
		assertEquals(list.size(), 2);
	}
}
