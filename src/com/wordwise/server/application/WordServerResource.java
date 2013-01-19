package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Session;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

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
			
			StringBuilder hibernateSQL = new StringBuilder();
			hibernateSQL.append("from Word w");
			hibernateSQL.append("    join w.difficulties d");
			hibernateSQL.append("    join w.qualities q");
			hibernateSQL.append(" where");
			hibernateSQL.append("    q.quality >= 2");
			if (parameters.getDifficulty() != null || parameters.getWordsAlreadyUsed() != null)
			{
				if (parameters.getDifficulty() != null)
				{
					hibernateSQL.append("    and w.difficulty = "+parameters.getDifficulty().getDifficulty());
				}
				if (parameters.getWordsAlreadyUsed() != null && parameters.getWordsAlreadyUsed().size() > 0)
				{
					hibernateSQL.append("    and w.id not in ("+parameters.getWordsAlreadyUsed().toString().substring(1, parameters.getWordsAlreadyUsed().toString().length()-2)+")");
				}
			}
			
			result = (List<Word>) session.createQuery(hibernateSQL.toString()).list();
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
		return result;
	}
}