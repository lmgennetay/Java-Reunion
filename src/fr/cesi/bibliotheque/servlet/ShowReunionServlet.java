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
import fr.cesi.bibliotheque.dao.jpa.JpaReunionDao;
import fr.cesi.bibliotheque.entity.Reunion;

/**
 * Servlet implementation class showReunionServlet
 */
@WebServlet("/showReunion")
public class ShowReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReunionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		if ( request.getParameter("id") != null  ) {
			int id = Integer.parseInt(request.getParameter("id"));
			JpaReunionDao jpaReunionDao  =  (JpaReunionDao) DaoFactory.ReunionDF();
			Reunion reunion = jpaReunionDao.findReunionById(id);
			System.out.println(reunion.getId());
			request.setAttribute("reunion", reunion);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/showReunion.jsp");
			rs.forward(request, response);
	    }
		
		else {
			System.out.println("out");
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/listeReunions.jsp");
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


