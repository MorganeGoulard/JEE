package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Auteur;


@WebServlet("/DetailsAuteur")
public class DetailsAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AuteurDao auteurDao;

    public DetailsAuteur() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id;
		
		id = Long.parseLong(request.getParameter("id"));
		Auteur auteurRecherche=null;
		
		try {
			auteurRecherche = auteurDao.trouver(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("auteur", auteurRecherche);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/DetailsAuteur.jsp").forward(request, response);
	}

	

}
