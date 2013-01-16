package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Session;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Difficulty;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Word;
import com.wordwise.server.model.parameter.ListWordParameters;
import com.wordwise.server.resource.WordResource;

public class WordServerResource extends ServerResource implements WordResource
{
	public WordServerResource()
	{
		super();
	}
	
	@Override
	@Put
	public void add(Word word)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(word);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}	
	}

	@Override
	@Post
	public List<Word> list(ListWordParameters parameters)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Word> result = null;
		try
		{
			session.beginTransaction();
			result = session.createQuery("from Word").list();
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
        return result;
	}
}