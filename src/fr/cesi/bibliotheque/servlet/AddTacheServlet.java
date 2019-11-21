package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
		if ( request.getParameter("titre") != null ) {
			//Recuperation de la reunion
			int id_reunion = Integer.parseInt(request.getParameter("reunion"));   
			JpaReunionDao jpaReunionDao  =  (JpaReunionDao) DaoFactory.ReunionDF();
			Reunion reunion = jpaReunionDao.findReunionById(id_reunion);
			
			//Recuperation des collaborateurs
			ArrayList<Collaborateur> listeCollaborateurs = new ArrayList<Collaborateur>();
			Collaborateur collaborateur = new Collaborateur();
			JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
			for (int id_collaborateur : request.getParameter("listeCollaborateurs")) {
				collaborateur = jpaCollaborateurDao.findCollaborateurById(id_collaborateur);
				listeCollaborateurs.add(collaborateur);
			}
			
			//Creation de la tache
			Tache tache = new Tache();
			tache.setNom(request.getParameter("nom"));
			tache.setDescription(request.getParameter("prenom"));
			tache.setReunion(reunion);	
			tache.setCollaborateurs(listeCollaborateurs);
			jpaTacheDao.addTache(tache);

			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
        	rs.forward(request, response);
		} else {
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
