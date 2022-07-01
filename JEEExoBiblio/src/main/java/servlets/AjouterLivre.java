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
import dao.LivreDao;
import model.Auteur;
import model.Livre;


@WebServlet("/AjouterLivre")
public class AjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LivreDao livreDao;
	private AuteurDao auteurDao;

    public AjouterLivre() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Auteur> auteurs = null;
		
		try {
			auteurs = auteurDao.lister();
			request.setAttribute("auteurs", auteurs);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterLivre.jsp").forward(request, response);		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long idAuteur = Long.parseLong(request.getParameter("auteurLivre"));
		String titre = request.getParameter("titreLivre");
		int nbPages = Integer.parseInt(request.getParameter("nbPagesLivre"));
		String categorie = request.getParameter("categorieLivre");
		
		Livre livreAAjouter = new Livre();
		livreAAjouter.setTitre(titre);
		livreAAjouter.setNbPages(nbPages);
		livreAAjouter.setCategorie(categorie);
		
		try {
			Auteur auteur = auteurDao.trouver(idAuteur);
			livreAAjouter.setAuteur(auteur);
			livreDao.creer(livreAAjouter);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
				
		
		response.sendRedirect(request.getContextPath() + "/ListeLivres");

	}

}
