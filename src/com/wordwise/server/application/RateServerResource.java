package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Session;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Rate;
import com.wordwise.server.resource.RateResource;

public class RateServerResource extends ServerResource implements RateResource
{

	@Override
	@Put
	public void add(List<Rate> wordRatings)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(wordRatings);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}	
	}

}
