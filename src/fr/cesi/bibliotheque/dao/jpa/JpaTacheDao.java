package fr.cesi.bibliotheque.dao.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.bibliotheque.entity.Tache;

/**
 * CRUD des t�ches d'une r�union
 * @author Louis-Marie Gennetay
 *
 */
public class JpaTacheDao {
	private EntityManagerFactory emf;
	
	private static List<Tache> taches = new ArrayList<Tache>();
	
	public JpaTacheDao( EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	/**
	 * Ajoute une t�che
	 * @param tache : T�che � ajouter
	 */
	public void addTache(Tache tache) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
				em.persist(tache);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
	}
	
	/**
	 * Met � jour la t�che
	 * @param tache : T�che � mettre � jour
	 */
	public void updateTache(Tache tache) {
		int index = getTacheIndexById(tache.getId());
		if(index > -1) {
			taches.set(index, tache);
		} else {
			System.out.println(tache.getId());
		}
	}
	
	/**
	 * Recherche une t�che selon son id
	 * @param id : id de la t�che recherch�e
	 * @return tache : La t�che recherch�e
	 */
	public Tache findTacheById(int id) {
		EntityManager em = emf.createEntityManager();		
		Tache tache = em.find(Tache.class, id);
		em.close();
		return tache;
	}
	
	/**
	 * Recherche l'ensemble des t�ches existantes
	 * @return res : Tableau contenant toute les t�ches
	 */
	public Collection<Tache> getAllTaches() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Tache t");
		System.out.println(query);
		Collection res = (Collection<Tache>) query.getResultList();
		em.close();
	    return res;
	}
	
	/**
	 * Supprime une t�che
	 * @param tache : T�che � supprimer
	 */
	public void removeTache(Tache tache) {
		removeTache(tache.getId());
	}
	
	/**
	 * Supprime une t�che selon son id
	 * @param id : Id de la t�che � supprimer
	 */
	public void removeTache(int id) {
        System.out.println("Id removeTache " + id);
        EntityManager em = emf.createEntityManager();
        Tache tache = em.find(Tache.class, id);
        em.getTransaction().begin();;
        System.out.println("em"+em);
        em.remove(tache);
        em.getTransaction().commit();
	}
	
	/**
	 * Recherche une t�che par son id
	 * @param id : id de la t�che
	 * @return i : id de la t�che
	 */
	public int getTacheIndexById(int id) {
		for (int i = 0; i < taches.size(); i++) {
			Tache tache = taches.get(i);
			if(tache.getId() == id) {
				return i;
			}
		}
		return -1;
	}
}
