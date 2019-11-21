package fr.cesi.bibliotheque.dao;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.cesi.bibliotheque.entity.User;

public interface UserDao {
	public void addUser(User user);	
	public void updateUser(User user);
	public User findUserById(Long id);
	public Collection<User> getAllUsers();
	public void removeUser(User user);
	public void removeUser(Long id);
	public int getUserIndexById(Long id);
	
	public String getResultat();
	public Map<String, String> getErreurs();
	public User connecterUtilisateur( HttpServletRequest request );
	public void validationIdentification( String identification );
	public void validationPassword( String password );
	public void setErreur( String champ, String message );
	public String getValeurChamp( HttpServletRequest request, String nomChamp );
}
