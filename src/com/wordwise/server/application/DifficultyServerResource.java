package com.wordwise.server.application;

import org.hibernate.Session;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.dto.DTODifficulty;
import com.wordwise.server.model.factory.DTODifficultyFactory;
import com.wordwise.server.resource.DifficultyResource;

public class DifficultyServerResource extends ServerResource implements DifficultyResource
{
	@Override
	@Put
	public void add(DTODifficulty wordDifficulty) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(DTODifficultyFactory.build(wordDifficulty));
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}	
	}

}
