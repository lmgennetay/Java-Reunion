package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.cesi.bibliotheque.dao.DaoFactory;
import fr.cesi.bibliotheque.dao.jpa.JpaReunionDao;
import fr.cesi.bibliotheque.entity.Reunion;


/**
 * Servlet implementation class RemoveReunionServlet
 */
@WebServlet("/removeReunion")
public class RemoveReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}	
	
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public RemoveReunionServlet() {
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
	
	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		super.service(request, response);
		
		JpaReunionDao jpaReunionDao  =  (JpaReunionDao) DaoFactory.ReunionDF();
		Collection<Reunion> reunions = jpaReunionDao.getAllReunions();
		System.out.println(reunions);
		request.setAttribute("reunions", reunions);
        
		if ( request.getParameter("id") != null ){
			int id = Integer.parseInt(request.getParameter("id"));
			jpaReunionDao.removeReunion(id);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/MenuAdmin.jsp");
			rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/removeReunion.jsp");
			rs.forward(request, response);
		}        
	}	
}
