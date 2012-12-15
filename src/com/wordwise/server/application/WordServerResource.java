package com.wordwise.server.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Word;
import com.wordwise.server.resource.WordResource;

public class WordServerResource extends ServerResource implements WordResource
{
	@Override
	@Put
	public void addWord(Word word)
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(word);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}	
	}
}