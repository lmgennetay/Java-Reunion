package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaTacheDao;
import fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao;
import fr.cesi.bibliotheque.dao.jpa.JpaReunionDao;
import fr.cesi.bibliotheque.entity.Tache;
import fr.cesi.bibliotheque.entity.Collaborateur;
import fr.cesi.bibliotheque.entity.Reunion;

/**
 * Servlet implementation class addTache
 */
@WebServlet("/addTache")
public class AddTacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTacheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaTacheDao jpaTacheDao = (JpaTacheDao) DaoFactory.TacheDF();
		JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
		JpaReunionDao jpaReunionDao  =  (JpaReunionDao) DaoFactory.ReunionDF();
		
		Collection<Collaborateur> listeCollaborateurs = new ArrayList<Collaborateur>();
		if ( request.getParameter("reunion") != null ) {
			//Recuperation de la reunion
			int id_reunion = Integer.parseInt(request.getParameter("reunion"));  
			Reunion reunion = jpaReunionDao.findReunionById(id_reunion);
			
			//Recuperation des collaborateurs			
			String[] outerArray = request.getParameterValues("listeCollaborateurs");
			List<String> innerArray = Arrays.asList(outerArray);
			System.out.println(innerArray);
			for (String collab : innerArray) {
				System.out.println("Collab " + collab);
				Collaborateur c = jpaCollaborateurDao.findCollaborateurById(Integer.parseInt(collab));
				listeCollaborateurs.add(c);
			}
			
			//Creation de la tache
			Tache tache = new Tache();
			tache.setNom(request.getParameter("nom"));
			tache.setDescription(request.getParameter("prenom"));
			tache.setReunion(reunion);	
			tache.setCollaborateurs(listeCollaborateurs);
			jpaTacheDao.addTache(tache);

			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/acceuil.jsp");
        	rs.forward(request, response);
		} else {
			listeCollaborateurs  =  jpaCollaborateurDao.getAllCollaborateurs();
			request.setAttribute("listeCollaborateurs", listeCollaborateurs);
			Reunion reunion = jpaReunionDao.findReunionById(Integer.parseInt(request.getParameter("id_reunion")));
			request.setAttribute("reunion", reunion);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/addTache.jsp");
        	rs.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
