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
import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.entity.Livre;

/**
 * Servlet implementation class listLivreServlet
 */
@WebServlet("/listLivre")
public class listLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		super.service(request, response);
		
		JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
		Collection<Livre> livres = jpaLivreDao.getAllLivres();
		System.out.println(livres);
        
        if ( livres != null  ) {
	        request.setAttribute("livres", livres);   
	        RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/listLivre.jsp");
			rs.forward(request, response);
	    }
		else {
	    	RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
	    	rs.forward(request, response);
	    }
	 }
}
