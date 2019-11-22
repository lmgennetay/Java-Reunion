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
 * CRUD des r�unions
 * @author Louis-Marie Gennetay
 */
public class JpaReunionDao {
	private EntityManagerFactory emf;
	
	private static List<Reunion> reunions = new ArrayList<Reunion>();
	
	public JpaReunionDao( EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	/**
	 * Ajoute une r�union
	 * @param reunion : R�union � ajouter
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
	 * Met � jour la r�union
	 * @param reunion : R�union � mettre � jour
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
	 * Recherche une r�union selon son id
	 * @param id : id de la r�union recherch�e
	 * @return reunion : La r�union recherch�e
	 */
	public Reunion findReunionById(int id) {
		EntityManager em = emf.createEntityManager();
		Reunion reunion = em.find(Reunion.class, id);
		em.close();
		return reunion;
	}
	
	/**
	 * Recherche l'ensemble des r�unions existantes
	 * @return res : Tableau contenant toute les r�unions
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
	 * Supprime une r�union
	 * @param reunion : R�union � supprimer
	 */
	public void removeReunion(Reunion reunion) {
		removeReunion(reunion.getId());
	}
	
	/**
	 * Supprime une r�union selon son id
	 * @param id : Id de la r�union � supprimer
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
	 * Recherche une r�union par son id
	 * @param id : id de la r�union
	 * @return i : id de la r�union
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
