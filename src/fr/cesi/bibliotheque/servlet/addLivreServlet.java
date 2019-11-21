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
import fr.cesi.bibliotheque.entity.Livre;

/**
 * Servlet implementation class addLivre
 */
@WebServlet("/addLivre")
public class addLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
		if ( request.getParameter("titre") != null ){
			String titre = request.getParameter("titre");    	
		    String auteur = request.getParameter("auteur");    	
		    String categorie = request.getParameter("categorie"); 
		    boolean reserv = false;
		    
			Livre livre = new Livre();
			
			livre.setTitre(titre);
			livre.setAuteur(auteur);
			livre.setCategorie(categorie);
			livre.setReserv(reserv);
			
			jpaLivreDao.addLivre(livre);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
        	rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/addLivre.jsp");
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
