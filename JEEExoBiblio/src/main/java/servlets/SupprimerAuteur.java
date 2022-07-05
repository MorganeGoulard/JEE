package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;


@WebServlet("/SupprimerAuteur")
public class SupprimerAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private AuteurDao auteurDao;
	
    public SupprimerAuteur() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = 0;
		
		id = Long.parseLong(request.getParameter("id"));
		
		HttpSession session = request.getSession();

		
		
		try {
			auteurDao.supprimer(id);
			request.getSession().setAttribute("confirmationMsg", "L'auteur a bien été supprimé !");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/ListeAuteurs");
		
		
	}



}
