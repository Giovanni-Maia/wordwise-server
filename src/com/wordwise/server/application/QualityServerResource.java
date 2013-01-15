package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Session;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Quality;
import com.wordwise.server.resource.QualityResource;

public class QualityServerResource extends ServerResource implements QualityResource
{

	@Override
	@Put
	public void add(List<Quality> translationQualities)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(translationQualities);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}		
	}

}
