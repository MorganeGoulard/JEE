package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Auteur;

@WebServlet("/ListeAuteurs")
public class ListeAuteurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private AuteurDao auteurDao;
   
    public ListeAuteurs() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = 0;
		
		if (request.getParameter("id") == null ) {
			List<Auteur> auteurs=null;
			try {
				auteurs = auteurDao.lister();
			} catch (DaoException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("auteurs", auteurs);
			
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/ListeAuteurs.jsp").forward(request, response);
			
		} else {
			
			id = Long.parseLong(request.getParameter("id"));
			Auteur auteurRecherche = null;
			
			try {
				auteurRecherche = auteurDao.trouver(id);
			} catch (DaoException e) {
				auteurRecherche=null;
				e.printStackTrace();
			}
			
			request.setAttribute("auteur", auteurRecherche);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/DetailsAuteur.jsp").forward(request, response);

		}
			
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/

}
