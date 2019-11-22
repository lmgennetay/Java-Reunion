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
 * Servlet implementation class updateCollaborateurServlet
 */
@WebServlet("/updateCollaborateurServlet")
public class updateCollaborateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCollaborateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null ) {
			System.out.println("true");
			int idParam = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			//Recuperation du role
			int id_role = Integer.parseInt(request.getParameter("role"));
			
			JpaRoleDao jpaRoleDao  =  (JpaRoleDao) DaoFactory.RoleDF();
			Role role = jpaRoleDao.findRoleById(id_role);
			//Traitement de la mise à jour
			JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
			Collaborateur collaborateur = jpaCollaborateurDao.findCollaborateurById(idParam);
			
			collaborateur.setNom(nom);
			collaborateur.setPrenom(prenom);
			collaborateur.setMail(email);
			collaborateur.setRole(role);
			System.out.println("mon role est "+collaborateur.getNom());
			jpaCollaborateurDao.updateCollaborateur(collaborateur);
			
			RequestDispatcher rs = request.getRequestDispatcher("/listCollaborateurServlet");
        	rs.forward(request, response);
		} else {
			System.out.println("else");
			int idParam = Integer.parseInt(request.getParameter("id"));
			JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
			Collaborateur collaborateur = jpaCollaborateurDao.findCollaborateurById(idParam);
			request.setAttribute("collaborateur", collaborateur);
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
