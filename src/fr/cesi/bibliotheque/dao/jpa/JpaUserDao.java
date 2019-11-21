package fr.cesi.bibliotheque.dao.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlRootElement;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.UserDao;
import fr.cesi.bibliotheque.entity.User;

public class JpaUserDao implements UserDao {
	private EntityManagerFactory emf;
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
	
	private static List<User> users = new ArrayList<User>();
	
	public JpaUserDao( EntityManagerFactory emf) {
		this.emf = emf;
	}
		
	public void addUser(User user) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
				em.persist(user);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
	}	
	
	public void updateUser(User user) {
		int index = getUserIndexById(user.getId());
		if(index > -1) {
			users.set(index, user);
		} else {
			System.out.println(user.getId());
		}
	}	
	
	public User findUserById(Long id) {
		EntityManager em = emf.createEntityManager();		
		User user = em.find(User.class, id);
		em.close();
		return user;
	}
	
	public User findUserByNom(String nom) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.nom = :nom ");
		query.setParameter("nom", nom);
		User user = (User)query.getSingleResult();
		em.close();
		return user;
	}
	
		
	public Collection<User> getAllUsers() {
		Collection<User> userList = new ArrayList<User>();
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM User u");
		Collection res = (Collection<User>) query.getResultList();
		em.close();
	    return res;
	}
		
	public void removeUser(User user) {
		removeUser(user.getId());
	}	
	
	public void removeUser(Long id){	
		System.out.println(id);
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("DELETE FROM User WHERE User.id = :id");
		query.setParameter("id", id);		
		System.out.println("id : "+ id +" a été effacer!");		
	}
	
	public int getUserIndexById(Long id) {
		System.out.println(id);
		EntityManager em = emf.createEntityManager();
		
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if(user.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public User connecterUtilisateur( HttpServletRequest request ) {

        String identifiant = getValeurChamp( request, "identifiant" );
        String password = getValeurChamp( request, "password" );
        System.out.println(identifiant + " - " + password );
        
        User usersession = new User();
        User user = new User();
        /* Validation du champ nom. */
        try {
            //validationIdentification( identifiant );
    		user = findUserByNom( identifiant );
//    		System.out.println("find" + user.getNom() + " - " + user.getPassword() );
            
        } catch ( Exception e ) {
            setErreur( "identifiant", e.getMessage() );
        }
        usersession.setNom( user.getNom() );
        usersession.setPassword( user.getPassword() );
        usersession.setRole( user.getRole() );
        System.out.println(user.getRole() );
        return usersession;
    }

    public void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    public String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

	@Override
	public void validationIdentification(String identification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validationPassword(String password) {
		// TODO Auto-generated method stub
		
	}
}
