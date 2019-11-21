package fr.cesi.supbibliotheque.rest;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaUserDao;
import fr.cesi.bibliotheque.entity.User;

@Path("/users")
public class UserResource {
	
	@POST
	@Path("/allusers/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Collection<User> getAllUsersInXml() {
		JpaUserDao jpaUserDao  =  (JpaUserDao) DaoFactory.UserDF();
		Collection<User> users = jpaUserDao.getAllUsers();		
		return users;
	}
	
	@POST
	@Path("/allusers/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getAllUsersInJson(){
		JpaUserDao jpaUserDao  =  (JpaUserDao) DaoFactory.UserDF();
		Collection<User> users = jpaUserDao.getAllUsers();		
		return users;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/getuser/{id}/xml")
	public User getUserInXml(@PathParam("id") Long userId){
		JpaUserDao jpaUserDao  =  (JpaUserDao) DaoFactory.UserDF();
		User user = jpaUserDao.findUserById(userId);
		return user;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getuser/{id}/json")
	public User getUsertInJson(@PathParam("id") Long userId){
		JpaUserDao jpaUserDao  =  (JpaUserDao) DaoFactory.UserDF();
		User user = jpaUserDao.findUserById(userId);
		return user;
	}
	
	@POST
	@Path("/adduser/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUserIn(User user){
		String UserUri = "/"+user.getId();
		return Response.created(URI.create(UserUri)).build();
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/removeuser/{id}/json")
	public void removeUser(@PathParam("id") Long userId){
		JpaUserDao jpaUserDao  =  (JpaUserDao) DaoFactory.UserDF();
		jpaUserDao.removeUser(userId);
	}
}
