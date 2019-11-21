package fr.cesi.bibliotheque.dao;

import fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao;
import fr.cesi.bibliotheque.dao.jpa.JpaRoleDao;
import fr.cesi.bibliotheque.dao.jpa.JpaReunionDao;
import fr.cesi.bibliotheque.dao.jpa.JpaTacheDao;
import fr.cesi.bibliotheque.util.PersistenceManager;

public class DaoFactory {

	private DaoFactory() {}
	
	public static JpaRoleDao RoleDF() {
		return new JpaRoleDao( PersistenceManager.getEntityManagerFactory() );
	}
	
	public static JpaCollaborateurDao CollaborateurDF() {
		return new JpaCollaborateurDao( PersistenceManager.getEntityManagerFactory() );
	}
	
	public static JpaReunionDao ReunionDF() {
		return new JpaReunionDao( PersistenceManager.getEntityManagerFactory() );
	}
	
	public static JpaTacheDao TacheDF() {
		return new JpaTacheDao( PersistenceManager.getEntityManagerFactory() );
	}
}
