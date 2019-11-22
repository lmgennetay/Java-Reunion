package fr.cesi.bibliotheque.dao.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.bibliotheque.entity.Reunion;

/**
 * CRUD des réunions
 * @author Louis-Marie Gennetay
 */
public class JpaReunionDao {
	private EntityManagerFactory emf;
	
	private static List<Reunion> reunions = new ArrayList<Reunion>();
	
	public JpaReunionDao( EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	/**
	 * Ajoute une réunion
	 * @param reunion : Réunion à ajouter
	 */
	public void addReunion(Reunion reunion) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
				em.persist(reunion);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
	}
	
	/**
	 * Met à jour la réunion
	 * @param reunion : Réunion à mettre à jour
	 */
	public void updateReunion(Reunion reunion) {
		int index = getReunionIndexById(reunion.getId());
		if(index > -1) {
			reunions.set(index, reunion);
		} else {
			System.out.println(reunion.getId());
		}
	}
	
	/**
	 * Recherche une réunion selon son id
	 * @param id : id de la réunion recherchée
	 * @return reunion : La réunion recherchée
	 */
	public Reunion findReunionById(int id) {
		EntityManager em = emf.createEntityManager();
		Reunion reunion = em.find(Reunion.class, id);
		em.close();
		return reunion;
	}
	
	/**
	 * Recherche l'ensemble des réunions existantes
	 * @return res : Tableau contenant toute les réunions
	 */
	public Collection<Reunion> getAllReunions() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Reunion r");
		System.out.println(query);
		Collection res = (Collection<Reunion>) query.getResultList();
		em.close();
	    return res;
	}
	
	/**
	 * Supprime une réunion
	 * @param reunion : Réunion à supprimer
	 */
	public void removeReunion(Reunion reunion) {
		removeReunion(reunion.getId());
	}
	
	/**
	 * Supprime une réunion selon son id
	 * @param id : Id de la réunion à supprimer
	 */
	public void removeReunion(int id) {
        System.out.println("Id removeReunion " + id);
        EntityManager em = emf.createEntityManager();
        Reunion reunion = em.find(Reunion.class, id);
        em.getTransaction().begin();;
        System.out.println("em"+em);
        em.remove(reunion);
        em.getTransaction().commit();
	}
	
	/**
	 * Recherche une réunion par son id
	 * @param id : id de la réunion
	 * @return i : id de la réunion
	 */
	public int getReunionIndexById(int id) {
		for (int i = 0; i < reunions.size(); i++) {
			Reunion reunion = reunions.get(i);
			if(reunion.getId() == id) {
				return i;
			}
		}
		return -1;
	}
}
