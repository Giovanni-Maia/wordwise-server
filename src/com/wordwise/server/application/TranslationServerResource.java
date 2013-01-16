package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Session;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Translation;
import com.wordwise.server.model.parameter.ListTranslationParameters;
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
	@Post
	public List<Translation> list(ListTranslationParameters parameters)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Translation> result = null;
		try
		{
			session.beginTransaction();
			result = (List<Translation>) session.createQuery("from Translation").list();
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
        return result;
	}
}
