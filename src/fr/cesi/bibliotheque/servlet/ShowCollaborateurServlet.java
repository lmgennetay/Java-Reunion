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
import fr.cesi.bibliotheque.entity.Collaborateur;

/**
 * Servlet implementation class ShowCollaborateurServlet
 */
@WebServlet("/ShowCollaborateurServlet")
public class ShowCollaborateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCollaborateurServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			int idParam = Integer.parseInt(request.getParameter("id"));
			JpaCollaborateurDao jpaCollaborateurDao  =  (JpaCollaborateurDao) DaoFactory.CollaborateurDF();
			Collaborateur collaborateur = jpaCollaborateurDao.findCollaborateurById(idParam);
			System.out.println(collaborateur.getId());
			request.setAttribute("collaborateur", collaborateur);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/showCollaborateur.jsp");
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
		doGet(request, response);
	}
}
