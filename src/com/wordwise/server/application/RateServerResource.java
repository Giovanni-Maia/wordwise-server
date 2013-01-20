package com.wordwise.server.application;

import org.hibernate.Session;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Rate;
import com.wordwise.server.resource.RateResource;

public class RateServerResource extends ServerResource implements RateResource
{

	@Override
	@Put
	public void add(Rate translationRatings)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(translationRatings);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}	
	}

}
