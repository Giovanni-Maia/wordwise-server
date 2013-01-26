package com.wordwise.server.test;


public class TranslationResourceTestCase
{
	/*private static TranslationResource translationResource = new TranslationServerResource();
	private static Language pt = new Language("Portuguese", "pt");
	private static Language de = new Language("German", "de");
	private static Word word = new Word();
	
	@BeforeClass
	public static void prepareDB()
	{
		word.setWord("table");
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(pt);
			session.save(de);
			session.save(word);
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}		
	}
	
	@AfterClass
	public static void cleanDB()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			
			List<DTOTranslation> list = translationResource.list(null);
			DTOWord word = list.get(0).word;
			for (DTOTranslation translation : list) {
				session.delete(translation);
			}
			session.delete(word);
			session.delete(pt);
			session.delete(de);
			
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
		}
	}

	@Test
	public void testAddTranslationWithNewWord()
	{
		DTOTranslation translation = new DTOTranslation();
		translation.language = DTOLanguageFactory.build(pt);
		translation.setWord(word);
		translation.setTranslation("mesa");
		
		translationResource.add(translation);
		
		List<DTOTranslation> list = translationResource.list(null);
		
		assertEquals(1, list.size());
		
		DTOTranslation translationSaved = list.get(0);		
		assertEquals(translationSaved.getTranslation(), translation.getTranslation());
		assertEquals(translationSaved.getWord().getWord(), translation.getWord().getWord());
		assertEquals(translationSaved.getLanguage().getLanguage(), translation.getLanguage().getLanguage());
		assertEquals(translationSaved.getLanguage().getCode(), translation.getLanguage().getCode());
	}

	@Test
	public void testAddTranslationWithExistentWord()
	{
		Translation translation = new Translation();
		translation.setLanguage(de);
		translation.setWord(word);
		translation.setTranslation("Tisch");
		
		translationResource.add(translation);
		
		List<Translation> list = translationResource.list(new ListTranslationParameters(de, null, 5, null));
		
		assertEquals(1, list.size());
		
		Translation translationSaved = list.get(0);		
		assertEquals(translationSaved.getTranslation(), translation.getTranslation());
		assertEquals(translationSaved.getWord().getWord(), translation.getWord().getWord());
		assertEquals(translationSaved.getLanguage().getLanguage(), translation.getLanguage().getLanguage());
		assertEquals(translationSaved.getLanguage().getCode(), translation.getLanguage().getCode());
	}

	@Test
	public void testListTranslationsNotIn()
	{
		List<Translation> list = translationResource.list(new ListTranslationParameters(de, null, 5, null));
		
		assertEquals(1, list.size());
		
		list = translationResource.list(new ListTranslationParameters(null, null, 5, list));
		
		assertEquals(1, list.size());
	}*/
}
