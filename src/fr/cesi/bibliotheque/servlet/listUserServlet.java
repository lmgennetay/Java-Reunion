package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.dao.jpa.JpaUserDao;
import fr.cesi.bibliotheque.entity.Livre;
import fr.cesi.bibliotheque.entity.User;

/**
 * Servlet implementation class listUserServlet
 */
@WebServlet("/listUser")
public class listUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listUserServlet() {
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
		
		JpaUserDao jpaUserDao  =  (JpaUserDao) DaoFactory.UserDF();
		Collection<User> users = jpaUserDao.getAllUsers();
		System.out.println(users);
        
        if ( users != null  ) {
	        request.setAttribute("users", users);   
	        RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/listUser.jsp");
			rs.forward(request, response);
	    }
		else {
	    	RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
	    	rs.forward(request, response);
	    }
	 }
}
