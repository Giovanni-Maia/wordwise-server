package com.wordwise.server.application;

import org.hibernate.Session;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.dto.DTOQuality;
import com.wordwise.server.model.factory.DTOQualityFactory;
import com.wordwise.server.resource.QualityResource;

public class QualityServerResource extends ServerResource implements QualityResource
{

	@Override
	@Put
	public void add(DTOQuality wordQuality)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(DTOQualityFactory.build(wordQuality));
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}		
	}

}
