package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Word;
import com.wordwise.server.resource.WordResource;

public class WordServerResource extends ServerResource implements WordResource {

	@SuppressWarnings("unchecked")
	@Override
	public List<Word> list(int number) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Word> result = null;
		try {
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Word.class);

			if (number > 0) {
				criteria.setMaxResults(number);
			}
			result = criteria.list();
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return result;
	}

}
