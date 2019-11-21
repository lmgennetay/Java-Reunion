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
import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.entity.Livre;

@Path("/livres")
public class LivreResource {	
	@POST
	@Path("/alllivres/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Collection<Livre> getAllUsersInXml() {
		JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
		Collection<Livre> livres = jpaLivreDao.getAllLivres();		
		return livres;
	}
	
	@POST
	@Path("/alllivres/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Livre> getAllUsersInJson(){
		JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
		Collection<Livre> livres = jpaLivreDao.getAllLivres();		
		return livres;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/getlivre/{id}/xml")
	public Livre getLivreInXml(@PathParam("id") Long livreId){
		JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
		Livre livre = jpaLivreDao.findLivreById(livreId);
		return livre;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getlivre/{id}/json")
	public Livre getLivreInJson(@PathParam("id") Long livreId){
		JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
		Livre livre = jpaLivreDao.findLivreById(livreId);
		return livre;
	}
	
	@POST
	@Path("/addlivre/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addLivreIn(Livre livre){
		String LivreUri = "/"+livre.getId();
		return Response.created(URI.create(LivreUri)).build();
	}	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/removelivre/{id}/json")
	public void removeLivre(@PathParam("id") Long livreId){
		JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
		jpaLivreDao.removeLivre(livreId);
	}
}