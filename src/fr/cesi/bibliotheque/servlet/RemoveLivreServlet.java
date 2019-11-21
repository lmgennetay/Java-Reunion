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
import fr.cesi.bibliotheque.dao.jpa.JpaLivreDao;
import fr.cesi.bibliotheque.entity.Livre;


/**
 * Servlet implementation class RemoveLivreServlet
 */
@WebServlet("/removeLivre")
public class RemoveLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveLivreServlet() {
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
		
		JpaLivreDao jpaLivreDao  =  (JpaLivreDao) DaoFactory.LivreDF();
		Collection<Livre> livres = jpaLivreDao.getAllLivres();
		System.out.println(livres);
		request.setAttribute("livres", livres);
        
		if ( request.getParameter("id") != null ){
			String ids = request.getParameter("id");
			Long id = Long.parseLong(ids);
			jpaLivreDao.removeLivre(id);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/MenuAdmin.jsp");
			rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/removeLivre.jsp");
			rs.forward(request, response);
		}        
	}	
}
