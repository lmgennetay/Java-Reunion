package fr.cesi.bibliotheque.dao.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.bibliotheque.entity.Collaborateur;

/**
 * CRUD de Collaborateur
 * @author Quentin
 *
 */
public class JpaCollaborateurDao {
private EntityManagerFactory emf;
	
	private static List<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
	
	public JpaCollaborateurDao( EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	/**
	 * Ajoute un collaborateur
	 * @param collaborateur
	 */
	public void addCollaborateur(Collaborateur collaborateur) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
				em.persist(collaborateur);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
	}
	
	/**
	 * Met à jour un collaborateur
	 * @param collaborateur
	 */
	public void updateCollaborateur(Collaborateur collaborateur) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
				em.merge(collaborateur);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
	}	
	
	/**
	 * Trouve un collaborateur via son id
	 * @param id
	 * @return
	 */
	public Collaborateur findCollaborateurById(int id) {
		EntityManager em = emf.createEntityManager();		
		Collaborateur collaborateur = em.find(Collaborateur.class, id);
		System.out.println(collaborateur);
		em.close();
		return collaborateur;
	}
	
	/**
	 * Liste tous les collaborateurs
	 * @return
	 */
	public Collection<Collaborateur> getAllCollaborateurs() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Collaborateur l");
		System.out.println(query);
		Collection res = (Collection<Collaborateur>) query.getResultList();
		em.close();
	    return res;
	}
	
	/**
	 * Supprime un collaborateur
	 * @param collaborateur
	 */
	public void removeCollaborateur(Collaborateur collaborateur) {
		removeCollaborateur(collaborateur.getId());
	}	
	
	public void removeCollaborateur(int id){
        System.out.println("Id removeCollaborateur"+id);
        EntityManager em = emf.createEntityManager();
        Collaborateur collaborateur = em.find(Collaborateur.class, id);
        em.getTransaction().begin();;
        System.out.println("em"+em);
        em.remove(collaborateur);
        em.getTransaction().commit();
	}
	
	/**
	 * Trouve un collaborateur via son id
	 * @param id
	 * @return
	 */
	public int getCollaborateurIndexById(int id) {
		System.out.println(collaborateurs.size());
		for (int i = 0; i < collaborateurs.size(); i++) {
			Collaborateur collaborateur = collaborateurs.get(i);
			System.out.println(collaborateur.getId()+" - "+ id+" - "+ i);
			if(collaborateur.getId() == id) {				
				return i;
			}
		}
		return -1;
	}	
}
