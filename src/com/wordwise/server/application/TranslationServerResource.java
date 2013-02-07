package com.wordwise.server.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.wordwise.server.dto.DTOTranslation;
import com.wordwise.server.dto.parameter.ListDTOTranslation;
import com.wordwise.server.dto.parameter.ListTranslationParameters;
import com.wordwise.server.model.Difficulty;
import com.wordwise.server.model.Translation;
import com.wordwise.server.model.Word;
import com.wordwise.server.model.factory.DTOTranslationFactory;
import com.wordwise.server.resource.TranslationResource;

public class TranslationServerResource extends ServerResource implements
		TranslationResource {
	@Override
	@Put
	public void add(DTOTranslation dtoTranslation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Criteria crit = session.createCriteria(Word.class);
			crit.add(Restrictions.ilike("word", dtoTranslation.word.word));
			@SuppressWarnings("unchecked")
			List<Word> results = crit.list();
			Translation translation = DTOTranslationFactory.build(dtoTranslation);
			if (results.size() > 0) {
				translation.setWord(results.get(0));
			} else {
				session.save(translation.getWord());
			}
			session.save(translation);

			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Post
	public ListDTOTranslation list(ListTranslationParameters parameters) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Translation> result = null;
		ListDTOTranslation returnList = null;
		try {
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Translation.class);
			Criteria criteriaWord = null;

			if (parameters != null && parameters.getLanguage() != null) {
				criteria.createCriteria("language").add(
						Restrictions.eq("code", parameters.getLanguage().code));
			}
			if (parameters != null && parameters.getDifficulty() != null) {
				criteriaWord = criteria.createCriteria("word");
				criteriaWord.createCriteria("difficulties",
						JoinType.LEFT_OUTER_JOIN);
			}
			if (parameters != null
					&& parameters.getTranslationsAlreadyUsed() != null
					&& parameters.getTranslationsAlreadyUsed().size() > 0) {
				criteria.add(Restrictions.not(Restrictions.in("id",
						getIDs(parameters.getTranslationsAlreadyUsed()))));
			}
			if (criteriaWord != null) {
				criteriaWord.createCriteria("qualities",
						JoinType.LEFT_OUTER_JOIN);
			} else {
				criteria.createCriteria("word").createCriteria("qualities",
						JoinType.LEFT_OUTER_JOIN);
			}
			criteria.createCriteria("rates", JoinType.LEFT_OUTER_JOIN);// .addOrder(Order.desc("rate"));
			result = processDuplicatedObjects(criteria.list());
			result = processRate(result);
			result = processQuality(result);
			if (parameters != null && parameters.getDifficulty() != null) {
				result = processDifficulty(
						result,
						Difficulty.getByDifficulty(parameters.getDifficulty().difficulty));
			}
			if (parameters != null && parameters.getNumberOfTranslations() > 0) {
				result = processNumberOfTranslations(result,
						parameters.getNumberOfTranslations());
			}
			returnList = DTOTranslationFactory.build(result);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return returnList;
	}

	private static Integer[] getIDs(List<DTOTranslation> translationsAlreadyUsed) {
		Integer[] returnArray = new Integer[translationsAlreadyUsed.size()];
		for (int i = 0; i < translationsAlreadyUsed.size(); i++) {
			returnArray[i] = translationsAlreadyUsed.get(i).id;
		}
		return returnArray;
	}

	private static List<Translation> processDuplicatedObjects(
			List<Translation> list) {
		List<Translation> returnList = new ArrayList<Translation>();
		for (Translation object : list) {
			if (!returnList.contains(object)) {
				returnList.add(object);
			}
		}

		return returnList;
	}

	private static List<Translation> processRate(List<Translation> result) {
		List<Translation> returnList = new ArrayList<Translation>();
		for (Translation translation : result) {
			double rateAVG = translation.getRateAVG();
			if (rateAVG == 0 || rateAVG > 2.5) {
				returnList.add(translation);
			}
		}
		return returnList;
	}

	private static List<Translation> processQuality(List<Translation> result) {
		List<Translation> returnList = new ArrayList<Translation>();
		for (Translation translation : result) {
			double qualityAVG = translation.getWord().getQualityAVG();
			if (qualityAVG == 0 || qualityAVG > 0) {
				returnList.add(translation);
			}
		}
		return returnList;
	}

	private static List<Translation> processDifficulty(
			List<Translation> result, Difficulty difficulty) {
		List<Translation> returnList = new ArrayList<Translation>();
		for (Translation translation : result) {
			double difficultyAVG = translation.getWord().getDifficultyAVG();
			if (difficultyAVG == 0) {
				returnList.add(translation);
			} else if (difficulty == Difficulty.EASY
					&& difficultyAVG <= ((Difficulty.EASY.getDifficulty() + Difficulty.MEDIUM
							.getDifficulty()) / 2.0)) {
				returnList.add(translation);
			} else if (difficulty == Difficulty.MEDIUM
					&& difficultyAVG >= ((Difficulty.EASY.getDifficulty() + Difficulty.MEDIUM
							.getDifficulty()) / 2.0)
					&& difficultyAVG <= ((Difficulty.MEDIUM.getDifficulty() + Difficulty.HARD
							.getDifficulty()) / 2.0)) {
				returnList.add(translation);
			} else if (difficulty == Difficulty.HARD
					&& difficultyAVG >= ((Difficulty.MEDIUM.getDifficulty() + Difficulty.HARD
							.getDifficulty()) / 2.0)) {
				returnList.add(translation);
			}
		}
		return returnList;
	}

	private static List<Translation> processNumberOfTranslations(
			List<Translation> result, int numberOfTranslations) {
		if (result.size() > numberOfTranslations) {
			Random random = new Random();
			List<Translation> returnList = new ArrayList<Translation>();
			for (int i = 0; i < numberOfTranslations; i++) {
				Translation translation = result.get(random.nextInt(result
						.size()));
				returnList.add(translation);
				result.remove(translation);
			}

			return returnList;
		}
		return result;
	}
}
