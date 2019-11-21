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
		if (request.getParameter("id") != null) {
			int idParam = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String mail = request.getParameter("mail");
			//Recuperation du role
			int id_role = Integer.parseInt(request.getParameter("role"));   
			JpaRoleDao jpaRoleDao  =  (JpaRoleDao) DaoFactory.RoleDF();
			Role role = jpaRoleDao.findRoleById(id_role);
			//Traitement de la mise à jour
			JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
			Collaborateur collaborateur = jpaCollaborateurDao.findCollaborateurById(idParam);
			System.out.println(collaborateur.getId());
			collaborateur.setNom(nom);
			collaborateur.setPrenom(prenom);
			collaborateur.setMail(mail);
			collaborateur.setRole(role);

			jpaCollaborateurDao.updateCollaborateur(collaborateur);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
        	rs.forward(request, response);
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/selectCollaborateur.jsp");
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
