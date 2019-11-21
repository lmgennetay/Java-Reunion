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
import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.entity.Livre;

/**
 * Servlet implementation class showLivreServlet
 */
@WebServlet("/showLivre")
public class ShowLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		if ( request.getParameter("id") != null  ) {
			System.out.println("in");
			// System.out.println(request.getParameter("id"));
			String idParam = request.getParameter("id");
			long id = Long.parseLong(idParam);
			JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
			Livre livre = jpaLivreDao.findLivreById(id) ;
			System.out.println(livre.getId());
			request.setAttribute("livre", livre);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/showLivre.jsp");
			rs.forward(request, response);
	    }
		
		else {
			System.out.println("out");
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/selectLivre.jsp");
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


