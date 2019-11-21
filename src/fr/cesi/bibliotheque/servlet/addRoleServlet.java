package fr.cesi.bibliotheque.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.dao.jpa.JpaRoleDao;
import fr.cesi.bibliotheque.entity.Role;

/**
 * Servlet implementation class addRoleServlet
 */
@WebServlet("/addRoleServlet")
public class addRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addRoleServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaRoleDao jpaRoleDao  =  (JpaRoleDao) DaoFactory.RoleDF();
		if ( request.getParameter("nom") != null ){
			String nom = request.getParameter("nom");
		    
			Role role = new Role();
			
			role.setNom(nom);
			
			jpaRoleDao.addRole(role);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/gestionCollaborateurs/listeRoles.jsp");
        	rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/gestionCollaborateurs/addRoles.jsp");
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
