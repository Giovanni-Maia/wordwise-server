package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Session;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Difficulty;
import com.wordwise.server.model.Language;
import com.wordwise.server.model.Translation;
import com.wordwise.server.resource.TranslationResource;

public class TranslationServerResource extends ServerResource implements TranslationResource
{

	@Override
	@Put
	public void add(Translation translation)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(translation);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}		
	}

	@Override
	@Get
	public List<Translation> list(Language language, Difficulty difficulty,	int numberOfWords)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Translation> result = null;
		try
		{
			session.beginTransaction();
			result = session.createQuery("from Translation").list();
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
        return result;
	}

}
