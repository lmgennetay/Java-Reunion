package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.Collection;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.dao.jpa.JpaUserDao;
import fr.cesi.bibliotheque.entity.Livre;
import fr.cesi.bibliotheque.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* HttpSession session = request.getSession();
		String identification = request.getParameter("identifiant");
		String password = request.getParameter("password");
		if ( identification != null && password != null ) {
			session.setAttribute("identifiant", identification);
			session.setAttribute("password", password);
		}
		String sId = (String) session.getAttribute("identifiant");
		String sPw = (String) session.getAttribute("password");
		System.out.println("identification : "+identification);
		System.out.println("password :" +password);
		System.out.println("session id :" +sId );
		System.out.println("session pw :" +sPw);
		
		
		if ( sId.equals("admin") && sPw.equals("admin") ){
			System.out.println("session Admin");
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
			rs.forward(request, response);
		}
		else if ( sId.equals("user")  && sPw.equals("user") ){
			System.out.println("session User");
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuUser.jsp");
			rs.forward(request, response);
		}
		
		else if ( sId != null && sPw != null  ) {
			// System.out.println( request.getAttribute("identifiant") + " add session" );				
			// System.out.println( request.getAttribute("actif") + " add session" );			
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuUser.jsp");
			rs.forward(request, response);
		}		
		else {
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			rs.forward(request, response);
		} */
	        
    	// Affiche la page de connexion
        RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rs.forward(request, response);
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
		// Préparation de la connexion
		JpaUserDao jpaUserDao  =  (JpaUserDao) DaoFactory.UserDF();
		User connexion = new User();
		
        // Traitement de la requête et récupération du bean en résultant	
		User utilisateur = jpaUserDao.connecterUtilisateur( request );
		
		if ( utilisateur == null ) {
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			rs.forward(request, response);
		}
		else {
			// Récupération de la session depuis la requête
	        HttpSession session = request.getSession();
	        
	        /**
	         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
	         * Utilisateur à la session, sinon suppression du bean de la session.
	         */
	        if ( jpaUserDao.getErreurs().isEmpty() ) {
	            session.setAttribute( "sessionUtilisateur", connexion );
	        } else {
	            session.setAttribute( "sessionUtilisateur", null );
	        }
	
	        /* Stockage du formulaire et du bean dans l'objet request */
	        request.setAttribute( "form", jpaUserDao );
	        request.setAttribute( "utilisateur", connexion );
	        if ( utilisateur.getRole().equals("administrateur")) {
	        	RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
				rs.forward(request, response);
	        }
	        else {
		        RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuUser.jsp");
				rs.forward(request, response);
	        }
		}
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
