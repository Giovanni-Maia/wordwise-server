package com.wordwise.server.application;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.wordwise.server.dto.DTOWord;
import com.wordwise.server.model.Word;
import com.wordwise.server.model.factory.DTOWordFactory;
import com.wordwise.server.model.parameter.ListWordParameters;
import com.wordwise.server.resource.WordResource;

public class WordServerResource extends ServerResource implements WordResource {

	@SuppressWarnings("unchecked")
	@Override
	@Post
	public ArrayList<DTOWord> list(ListWordParameters parameters) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<DTOWord> result = new ArrayList<DTOWord>();
		try {
			System.out.println("Beginning transactions");
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Word.class);

			if (parameters.getNumberOfWords() > 0) {
				criteria.setMaxResults(parameters.getNumberOfWords());
			}
			result = DTOWordFactory.build(criteria.list());
			session.getTransaction().commit();
			System.out.println("Ending transactions with" + result);
		} finally {
			session.close();
		}
		System.out.println("Final with" + result);
		return result;
	}

}
