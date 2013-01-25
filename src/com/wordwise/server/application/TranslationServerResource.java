package com.wordwise.server.application;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.model.Difficulty;
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
			@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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
			Criteria criteriaWord = null; 
			
			if (parameters != null && parameters.getLanguage() != null)
			{
				criteria.createCriteria("language").add(Restrictions.eq("code", parameters.getLanguage().getCode()));
			}
			if (parameters != null && parameters.getDifficulty() != null)
			{
				criteriaWord = criteria.createCriteria("word");
				criteriaWord.createCriteria("difficulties", JoinType.LEFT_OUTER_JOIN);
			}
			if (parameters != null && parameters.getTranslationsAlreadyUsed() != null && parameters.getTranslationsAlreadyUsed().size() > 0)
			{
				criteria.add(Restrictions.not(Restrictions.in("id", parameters.getTranslationsAlreadyUsed())));
			}
			if (parameters != null && parameters.getNumberOfTranslations() > 0)
			{
				criteria.setMaxResults(parameters.getNumberOfTranslations());
			}
			if (criteriaWord != null)
			{
				criteriaWord.createCriteria("qualities", JoinType.LEFT_OUTER_JOIN);
			}
			else
			{
				criteria.createCriteria("word").createCriteria("qualities", JoinType.LEFT_OUTER_JOIN);
			}
			criteria.createCriteria("rates", JoinType.LEFT_OUTER_JOIN).addOrder(Order.desc("rate"));
			
			result = processDuplicatedObjects(criteria.list());
			if (parameters != null && parameters.getDifficulty() != null)
			{
				result = processDifficulty(result, parameters.getDifficulty());
			}
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
        return result;
	}

	private List<Translation> processDuplicatedObjects(List<Translation> list)
	{
		List<Translation> returnList = new ArrayList<Translation>();
		for (Translation object : list)
		{
			if (!returnList.contains(object))
			{
				returnList.add(object);
			}
		}
		
		return returnList;
	}

	private static List<Translation> processDifficulty(List<Translation> result, Difficulty difficulty)
	{
		List<Translation> returnList = new ArrayList<Translation>();
		for (Translation translation : result)
		{
			double difficultyAVG = translation.getWord().getDifficultyAVG();
			if (difficultyAVG == 0)
			{
				returnList.add(translation);
			}
			else if (difficulty == Difficulty.EASY && difficultyAVG <= ((Difficulty.EASY.getDifficulty() + Difficulty.MEDIUM.getDifficulty())/2.0))
			{
				returnList.add(translation);
			}
			else if (difficulty == Difficulty.MEDIUM && difficultyAVG >= ((Difficulty.EASY.getDifficulty() + Difficulty.MEDIUM.getDifficulty())/2.0) && difficultyAVG <= ((Difficulty.MEDIUM.getDifficulty() + Difficulty.HARD.getDifficulty())/2.0))
			{
				returnList.add(translation);
			}
			else if (difficulty == Difficulty.HARD && difficultyAVG >= ((Difficulty.MEDIUM.getDifficulty() + Difficulty.HARD.getDifficulty())/2.0))
			{
				returnList.add(translation);
			}
		}
		return returnList;
	}
}
