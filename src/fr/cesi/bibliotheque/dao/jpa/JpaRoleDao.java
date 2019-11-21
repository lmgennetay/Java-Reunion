package fr.cesi.bibliotheque.dao.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.bibliotheque.entity.Role;

public class JpaRoleDao {
	private EntityManagerFactory emf;
	
	private static List<Role> roles = new ArrayList<Role>();
	
	public JpaRoleDao( EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void addLivre(Role role) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
				em.persist(role);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
	}
	
	public void updateLivre(Role role) {
		int index = getRoleIndexById(role.getId());
		if(index > -1) {
			roles.set(index, role);
		} else {
			System.out.println(role.getId());
		}
	}	
	
	public Role findRoleById(int id) {
		EntityManager em = emf.createEntityManager();		
		Role role = em.find(Role.class, id);
		em.close();
		return role;
	}
	
	public Collection<Role> getAllRoles() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Livre l");
		System.out.println(query);
		Collection res = (Collection<Role>) query.getResultList();
		em.close();
	    return res;
	}
	
	public void removeRole(Role role) {
		removeRole(role.getId());
	}	
	
	public void removeRole(int id){
        System.out.println("Id removeLivre"+id);
        EntityManager em = emf.createEntityManager();
        Role role = em.find(Role.class, id);
        em.getTransaction().begin();;
        System.out.println("em"+em);
        em.remove(role);
        em.getTransaction().commit();
	}
	
	public int getRoleIndexById(int id) {
		for (int i = 0; i < roles.size(); i++) {
			Role role = roles.get(i);
			if(role.getId() == id) {
				return i;
			}
		}
		return -1;
	}	
	
}
