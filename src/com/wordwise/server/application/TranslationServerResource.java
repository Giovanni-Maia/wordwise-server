package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Translation;
import com.wordwise.server.model.Word;
import com.wordwise.server.model.parameter.ListTranslationParameters;
import com.wordwise.server.resource.TranslationResource;

public class TranslationServerResource extends ServerResource implements TranslationResource
{		
	@Override
	@Put
	public void add(Translation translation)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			Criteria crit = session.createCriteria(Word.class);
			crit.add(Restrictions.ilike("word", translation.getWord().getWord()));
			List<Word> results = crit.list();
			if (results.size() > 0)
			{
				translation.setWord(results.get(0));
			}
			else
			{
				session.save(translation.getWord());
			}
			session.save(translation);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}		
	}

	@Override
	@Post
	public List<Translation> list(ListTranslationParameters parameters)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Translation> result = null;
		try
		{
			session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Translation.class);
			
			if (parameters != null && parameters.getLanguage() != null)
			{
				criteria.createCriteria("language").add(Restrictions.eq("code", parameters.getLanguage().getCode()));
			}
			if (parameters != null && parameters.getDifficulty() != null)
			{
				criteria.createCriteria("word").createCriteria("difficulties").add(Restrictions.idEq(parameters.getDifficulty()));
			}
			if (parameters != null && parameters.getTranslationsAlreadyUsed() != null && parameters.getTranslationsAlreadyUsed().size() > 0)
			{
				criteria.add(Restrictions.not(Restrictions.in("id", parameters.getTranslationsAlreadyUsed())));
			}
			if (parameters != null && parameters.getNumberOfTranslations() > 0)
			{
				criteria.setMaxResults(parameters.getNumberOfTranslations());
			}
			//criteria.createCriteria("word").createCriteria("qualities").add(Restrictions.);
			//criteria.createCriteria("rates").addOrder(Order.desc("rate"));
			
			result = criteria.list();
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
        return result;
	}
}
