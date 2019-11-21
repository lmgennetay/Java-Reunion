package fr.cesi.bibliotheque.dao;

import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.dao.jpa.JpaRoleDao;
import fr.cesi.bibliotheque.dao.jpa.JpaUserDao;
import fr.cesi.bibliotheque.util.PersistenceManager;

public class DaoFactory {

	private DaoFactory() {}
	
	public static JpaRoleDao RoleDF() {
		return new JpaRoleDao( PersistenceManager.getEntityManagerFactory() );
	}
	
	public static JpaCollaborateurDao CollaborateurDF() {
		return new JpaCollaborateurDao( PersistenceManager.getEntityManagerFactory() );
	}
}
