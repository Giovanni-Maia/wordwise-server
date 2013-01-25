package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Word;
import com.wordwise.server.model.parameter.ListWordParameters;
import com.wordwise.server.resource.WordResource;

public class WordServerResource extends ServerResource implements WordResource {

	@SuppressWarnings("unchecked")
	@Override
	@Post
	public List<Word> list(ListWordParameters parameters) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Word> result = null;
		try {
			System.out.println("Beginning transactions");
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Word.class);

			if (parameters.getNumberOfWords() > 0) {
				criteria.setMaxResults(parameters.getNumberOfWords());
			}
			result = criteria.list();
			session.getTransaction().commit();
			System.out.println("Ending transactions with" + result);
		} finally {
			session.close();
		}
		System.out.println("Final with" + result);
		return result;
	}

}
