package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Session;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Difficulty;
import com.wordwise.server.resource.DifficultyResource;

public class DifficultyServerResource extends ServerResource implements DifficultyResource
{
	@Override
	@Put
	public void add(List<Difficulty> wordDifficulties) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(wordDifficulties);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}	
	}

}
