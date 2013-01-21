package com.wordwise.server.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
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
			
			StringBuilder hibernateSQL = new StringBuilder();
			hibernateSQL.append("from Translation t");
			hibernateSQL.append("    join t.word w");
			hibernateSQL.append("    join t.language l");
			hibernateSQL.append("    join t.rates r");
			hibernateSQL.append(" where");
			if (parameters.getLanguage() != null)
			{
				hibernateSQL.append("    l.code = '"+parameters.getLanguage().getCode()+"' and");
			}
			if (parameters.getDifficulty() != null)
			{
				hibernateSQL.append("    w.difficulty = "+parameters.getDifficulty().getDifficulty()+"and");
			}
			if (parameters.getTranslationsAlreadyUsed() != null && parameters.getTranslationsAlreadyUsed().size() > 0)
			{
				hibernateSQL.append("    t.id not in ("+parameters.getTranslationsAlreadyUsed().toString().substring(1, parameters.getTranslationsAlreadyUsed().toString().length()-2)+") and");
			}
			hibernateSQL.append("    avg(w.qualities) > 2");
			hibernateSQL.append(" order by avg(r.rate) desc");
			
			result = (List<Translation>) session.createQuery(hibernateSQL.toString()).list();
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
        return result;
	}
}
