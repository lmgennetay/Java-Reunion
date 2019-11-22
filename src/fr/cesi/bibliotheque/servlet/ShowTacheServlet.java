package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaTacheDao;
import fr.cesi.bibliotheque.entity.Tache;

/**
 * Servlet implementation class showTacheServlet
 */
@WebServlet("/showTache")
public class ShowTacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTacheServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if ( request.getParameter("id") != null  ) {
			int id = Integer.parseInt(request.getParameter("id"));
			JpaTacheDao jpaTacheDao  =  (JpaTacheDao) DaoFactory.TacheDF();
			Tache tache = jpaTacheDao.findTacheById(id) ;
			System.out.println(tache.getId());
			request.setAttribute("tache", tache);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/showTache.jsp");
			rs.forward(request, response);
	    }
		
		else {
			System.out.println("out");
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/selectTache.jsp");
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


