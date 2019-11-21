package fr.cesi.bibliotheque.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaUserDao;
import fr.cesi.bibliotheque.entity.User;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*	try {
			String idParam = request.getParameter("id");
			long id = Long.parseLong(idParam);
			String nom = request.getParameter("nom");    	
		    String prenom = request.getParameter("prenom");    	
		    String type = request.getParameter("type"); 
		  
		    User user = new User(id, nom, prenom, type);
		    UserDao.addUser(user);
		    RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
        	rs.forward(request, response);
        } catch (Exception e) { */
            /* Gérer les erreurs de validation ici. */
      /* 	RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/addUser.jsp");
        	rs.forward(request, response);	
        } */
		
		JpaUserDao jpaUserDao  =  (JpaUserDao) DaoFactory.UserDF();
		if ( request.getParameter("nom") != null ){
			String nom = request.getParameter("nom");    	
		    String prenom = request.getParameter("prenom");    	
		    String role = request.getParameter("role"); 
		    
			User user = new User();
			
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setRole(role);
			
			jpaUserDao.addUser(user);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
        	rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/addUser.jsp");
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
