package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao;
import fr.cesi.bibliotheque.dao.jpa.JpaReunionDao;
import fr.cesi.bibliotheque.dao.jpa.JpaRoleDao;
import fr.cesi.bibliotheque.dao.jpa.JpaTacheDao;
import fr.cesi.bibliotheque.entity.Collaborateur;
import fr.cesi.bibliotheque.entity.Reunion;
import fr.cesi.bibliotheque.entity.Role;
import fr.cesi.bibliotheque.entity.Tache;

/**
 * Servlet implementation class addReunion
 */
@WebServlet("/addReunion")
public class AddReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReunionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaReunionDao jpaReunionDao  =  (JpaReunionDao) DaoFactory.ReunionDF();
		if ( request.getParameter("titre") != null ){
			//Conversion date_reunion
			String date = request.getParameter("date_reunion");			
			Date date_reunion = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			
			//Recuperation du referent
			int id_referent = Integer.parseInt(request.getParameter("id_referent"));   
			JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
			Collaborateur referent = jpaCollaborateurDao.findCollaborateurById(id_referent);	
			
			//Recuperation liste collaborateurs	
			ArrayList<Collaborateur> listeCollaborateurs = new ArrayList<Collaborateur>();
			Collaborateur collaborateur = new Collaborateur();
			for (int id_collaborateur : request.getParameter("listeCollaborateurs")) {
				collaborateur = jpaCollaborateurDao.findCollaborateurById(id_collaborateur);
				listeCollaborateurs.add(collaborateur);
			}
			
			//Recuperation liste tâches
			JpaTacheDao jpaTacheDao  =  (JpaTacheDao) DaoFactory.TacheDF();
			ArrayList<Tache> listeTaches = new ArrayList<Tache>(); 
			Tache tache = new Tache();
			for (int id_tache : request.getParameter("listeTaches")) {
				tache = jpaTacheDao.findTacheById(id_tache);
				listeTaches.add(tache);
			}
			
			//Creation du reunion
			Reunion reunion = new Reunion();
			reunion.setLieu(request.getParameter("lieu"));
			reunion.setObjectif(request.getParameter("objectif"));
			reunion.setCompterendu(request.getParameter("compterendu"));
			reunion.setDate_reunion(date_reunion);
			reunion.setCollaborateurReferent(referent);
			reunion.setCollaborateursParticipants(listeCollaborateurs);
			reunion.setTaches(listeTaches);
			jpaReunionDao.addReunion(reunion);
			
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
        	rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/addReunion.jsp");
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
