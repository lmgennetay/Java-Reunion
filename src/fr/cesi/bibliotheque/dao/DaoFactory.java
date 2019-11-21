package fr.cesi.bibliotheque.dao;

import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.dao.jpa.JpaUserDao;
import fr.cesi.bibliotheque.util.PersistenceManager;

public class DaoFactory {

	private DaoFactory() {}
	
	public static JpaLivreDao LivreDF() {
		return new JpaLivreDao( PersistenceManager.getEntityManagerFactory() );
	}
	
	public static JpaUserDao UserDF() {
		return  new JpaUserDao( PersistenceManager.getEntityManagerFactory() );
	}	
}
