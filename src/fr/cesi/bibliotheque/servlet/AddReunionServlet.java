package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class setReunion
 */
@WebServlet("/setReunion")
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
		
		//Recuperation de la liste des collaborateurs
		JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
		Collection<Collaborateur> collaborateurs = jpaCollaborateurDao.getAllCollaborateurs();
		System.out.println(collaborateurs);
        
        if ( collaborateurs != null  ) {
	        request.setAttribute("Collaborateurs", collaborateurs);   
	        RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/addReunion.jsp");
			rs.forward(request, response);
	    }
		else {
	    	RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
	    	rs.forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaReunionDao jpaReunionDao  =  (JpaReunionDao) DaoFactory.ReunionDF();
		if ( request.getParameter("date_reunion") != null) {
			System.out.println("Test !!!");
			//Conversion date_reunion
			String date = request.getParameter("date_reunion");			
			Date date_reunion = new Date();
			try {
				date_reunion = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//Recuperation du referent
			int id_referent = Integer.parseInt(request.getParameter("referent"));   
			JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
			Collaborateur referent = jpaCollaborateurDao.findCollaborateurById(id_referent);	
			
			//Recuperation liste collaborateurs	
			ArrayList<Collaborateur> listeCollaborateurs = new ArrayList<Collaborateur>();
			Collaborateur collaborateur = new Collaborateur();
			String[] outerArray = request.getParameterValues("participants");
			List<String> innerArray = Arrays.asList(outerArray);
			System.out.println(innerArray);
			for (String collab : innerArray) {
				System.out.println("Collab " + collab);
				Collaborateur c = jpaCollaborateurDao.findCollaborateurById(Integer.parseInt(collab));
				listeCollaborateurs.add(c);
			}
			
			//Recuperation liste tâches
			//JpaTacheDao jpaTacheDao  =  (JpaTacheDao) DaoFactory.TacheDF();
			//ArrayList<Tache> listeTaches = new ArrayList<Tache>(); 
			//Tache tache = new Tache();
			//for (int id_tache : request.getParameter("listeTaches")) {
			//	tache = jpaTacheDao.findTacheById(id_tache);
			//	listeTaches.add(tache);
			//}
			
			//Creation du reunion
			Reunion reunion = new Reunion();
			reunion.setLieu(request.getParameter("lieu"));
			reunion.setObjectif(request.getParameter("objectif"));
			reunion.setCompterendu(request.getParameter("compterendu"));
			reunion.setDate_reunion(date_reunion);
			reunion.setCollaborateurReferent(referent);
			reunion.setCollaborateursParticipants(listeCollaborateurs);
			//reunion.setTaches(listeTaches);
			jpaReunionDao.addReunion(reunion);
			
			RequestDispatcher rs = request.getRequestDispatcher("/listeReunions");
        	rs.forward(request, response);
		}
		else
		{
			JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
			Collection<Collaborateur> collaborateurs = jpaCollaborateurDao.getAllCollaborateurs();
			request.setAttribute("Collaborateurs", collaborateurs); 
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/setReunion.jsp");
        	rs.forward(request, response);
		}
	}

}
