package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class updateTacheServlet
 */
@WebServlet("/updateTacheServlet")
public class updateTacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateTacheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("date_echeance") != null && request.getParameter("nom") != null) {
			int idParam = Integer.parseInt(request.getParameter("id"));
			Date date_echeance = new Date();
			try {
				date_echeance = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("nom"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			
			JpaTacheDao jpaTacheDao  =  (JpaTacheDao) DaoFactory.TacheDF();
			Tache tache = jpaTacheDao.findTacheById(idParam);
			System.out.println(tache.getId());
			tache.setDate_echeance(date_echeance);
			tache.setNom(nom);
			tache.setDescription(description);
	
			jpaTacheDao.updateTache(tache);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/menuAdmin.jsp");
	    	rs.forward(request, response);
		} else {
			int idParam = Integer.parseInt(request.getParameter("id"));
			JpaTacheDao jpaTacheDao  =  (JpaTacheDao) DaoFactory.TacheDF();
			Tache tache = jpaTacheDao.findTacheById(idParam);
			request.setAttribute("Tache", tache);
			RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/jsp/addTache.jsp");
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
