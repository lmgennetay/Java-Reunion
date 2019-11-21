package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao;
import fr.cesi.bibliotheque.entity.Collaborateur;

/**
 * Servlet implementation class listCollaborateurServlet
 */
@WebServlet("/listCollaborateurServlet")
public class listCollaborateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listCollaborateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JpaCollaborateurDao jpaCollabotareurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
		Collection<Collaborateur> collaborateurs = jpaCollabotareurDao.getAllCollaborateurs();
		System.out.println(collaborateurs);
        
        if ( collaborateurs != null  ) {
	        request.setAttribute("collaborateurs", collaborateurs);   
	        RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/listeCollaborateurs.jsp");
			rs.forward(request, response);
	    }
		else {
	    	RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
	    	rs.forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
