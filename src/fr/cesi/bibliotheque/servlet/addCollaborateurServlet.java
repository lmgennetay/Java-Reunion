package fr.cesi.bibliotheque.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao;
import fr.cesi.bibliotheque.dao.jpa.JpaRoleDao;
import fr.cesi.bibliotheque.entity.Collaborateur;
import fr.cesi.bibliotheque.entity.Role;

/**
 * Servlet implementation class addCollaborateur
 */
@WebServlet("/addCollaborateurServlet")
public class addCollaborateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCollaborateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaCollaborateurDao jpaCollaborateurDao = (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
		if ( request.getParameter("titre") != null ) {
			//Recuperation du role
			int id_role = Integer.parseInt(request.getParameter("role"));   
			JpaRoleDao jpaRoleDao  =  (JpaRoleDao) DaoFactory.RoleDF();
			Role role = jpaRoleDao.findRoleById(id_role);	
			//Creation du collaborateur
			Collaborateur collaborateur = new Collaborateur();
			collaborateur.setNom(request.getParameter("nom"));
			collaborateur.setPrenom(request.getParameter("prenom"));
			collaborateur.setMail(request.getParameter("mail"));
			collaborateur.setRole(role);
			
			jpaCollaborateurDao.addCollaborateur(collaborateur);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
        	rs.forward(request, response);
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/addCollaborateur.jsp");
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
