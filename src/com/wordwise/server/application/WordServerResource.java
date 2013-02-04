package com.wordwise.server.application;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.wordwise.server.dto.parameter.ListDTOWord;
import com.wordwise.server.dto.parameter.ListWordParameters;
import com.wordwise.server.model.Word;
import com.wordwise.server.model.factory.DTOWordFactory;
import com.wordwise.server.resource.WordResource;

public class WordServerResource extends ServerResource implements WordResource {

	@SuppressWarnings("unchecked")
	@Override
	@Post
	public ListDTOWord list(ListWordParameters parameters) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		ListDTOWord result = new ListDTOWord();
		try {
			System.out.println("Beginning transactions");
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Word.class);
			//the criteria to return random rows
			criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
			if (parameters != null && parameters.getNumberOfWords() > 0) {
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
