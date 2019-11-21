package fr.cesi.bibliotheque.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.cesi.bibliotheque.util.PersistenceManager;

public class PersistenceAppListener implements ServletContextListener {
	
	// Appel � l'initialisation de l�application
	public void contextInitialized(ServletContextEvent evt){
	// rien faire
	}
	
	// Appel � la destruction de l�application
	public void contextDestroyed(ServletContextEvent evt) {
		PersistenceManager.closeEntityManagerFactory();
	}
}

