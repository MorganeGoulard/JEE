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


@WebServlet("/ModifierLivre")
public class ModifierLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LivreDao livreDao;
	private AuteurDao auteurDao;
  
    public ModifierLivre() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		long id = Long.parseLong(request.getParameter("id"));
		List<Auteur> auteurs; 
		List<Livre> livres;
		
		try {
			auteurs = auteurDao.lister();
			livres = livreDao.lister();
			request.setAttribute("auteurs", auteurs);
			request.setAttribute("livre", livres);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierLivre.jsp").forward(request, response);		

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		long id = Long.parseLong(request.getParameter("id"));
		
		String titre = request.getParameter("titreLivre");
		int nbPages = Integer.parseInt(request.getParameter("nbPagesLivre"));
		String categorie = request.getParameter("categorieLivre");
		long idAuteur = Long.parseLong(request.getParameter("auteurLivre"));
		
		Livre livreAModifier = new Livre();
		livreAModifier.setTitre(titre);
		livreAModifier.setNbPages(nbPages);
		livreAModifier.setCategorie(categorie);
		
		try {
			livreDao.modifier(livreAModifier);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

}
