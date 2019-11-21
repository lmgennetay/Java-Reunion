package fr.cesi.bibliotheque.dao.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.cesi.bibliotheque.dao.LivreDao;
import fr.cesi.bibliotheque.entity.Livre;
import fr.cesi.bibliotheque.entity.User;

public class JpaLivreDao implements LivreDao {
	private EntityManagerFactory emf;
	
	private static List<Livre> livres = new ArrayList<Livre>();
	
	public JpaLivreDao( EntityManagerFactory emf) {
		this.emf = emf;
	}
		
	public void addLivre(Livre livre) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
				em.persist(livre);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
	}	
	
	public void updateLivre(Livre livre) {
		int index = getLivreIndexById(livre.getId());
		if(index > -1) {
			livres.set(index, livre);
		} else {
			System.out.println(livre.getId());
		}
	}	
	
	public Livre findLivreById(Long id) {
		EntityManager em = emf.createEntityManager();		
		Livre livre = em.find(Livre.class, id);
		em.close();
		return livre;
	}
		
	public Collection<Livre> getAllLivres() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Livre l");
		System.out.println(query);
		Collection res = (Collection<Livre>) query.getResultList();
		em.close();
	    return res;
	}
		
	public void removeLivre(Livre livre) {
		removeLivre(livre.getId());
	}	
	
	public void removeLivre(Long id){
        System.out.println("Id removeLivre"+id);
        EntityManager em = emf.createEntityManager();
        Livre livre = em.find(Livre.class, id);
        em.getTransaction().begin();;
        System.out.println("em"+em);
        em.remove(livre);
        em.getTransaction().commit();
	}
	
	public int getLivreIndexById(Long id) {
		for (int i = 0; i < livres.size(); i++) {
			Livre livre = livres.get(i);
			if(livre.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}	
}
