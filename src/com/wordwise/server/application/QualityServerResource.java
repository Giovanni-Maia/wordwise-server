package com.wordwise.server.application;

import org.hibernate.Session;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.dto.DTOQuality;
import com.wordwise.server.model.factory.DTOQualityFactory;
import com.wordwise.server.resource.QualityResource;

/**
 * This class exposes web services for doing operations on Quality table.
 * 
 * @author Ugur Adiguzel, Dragan Mileski, Giovanni Maia
 * */
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
			// persist to db
			session.save(DTOQualityFactory.build(wordQuality));
			session.getTransaction().commit();
		}
		finally
		{
			//close the session in the end
			session.close();
		}		
	}

}
