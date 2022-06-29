package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoException;
import dao.DaoFactory;
import dao.LivreDao;
import model.Livre;


@WebServlet("/ListeLivres")
public class ListeLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LivreDao livreDao;
	
    public ListeLivres() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = 0;
		
		if (request.getParameter("id") == null ) {
		List<Livre> livres = null;
		try {
			livres = livreDao.lister();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("livres", livres);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeLivres.jsp").forward(request, response);		
		
		} else {
			
			id = Long.parseLong(request.getParameter("id"));
			Livre livreRecherche = null;
			
			try {
				livreRecherche = livreDao.trouver(id);
			} catch (DaoException e) {
				livreRecherche=null;
				e.printStackTrace();
			}
			
			request.setAttribute("livre", livreRecherche);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/DetailsLivre.jsp").forward(request, response);

		}
	} 


	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/

}
