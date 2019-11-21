package fr.cesi.bibliotheque.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;
	
	// Lazy initialization
	public static EntityManagerFactory getEntityManagerFactory(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("biblio");
		}
		return emf;	
	}
	
	//Private constructor empêche l’instantiation
	public static void closeEntityManagerFactory() {
		if(emf != null && emf.isOpen()) emf.close();
	}	
}