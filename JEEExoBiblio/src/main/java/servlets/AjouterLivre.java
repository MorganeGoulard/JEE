package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		String titre = request.getParameter("titreLivre");
		int nbPages = 0;
		String categorie = request.getParameter("categorieLivre");
		

		Auteur auteur = null;
		
		Map<String, String> erreurs = new HashMap<String, String>();
		
		if(titre != null) {
			if(titre.length() < 2 || titre.length() > 50) {
				erreurs.put("titreLivre", "Le titre du livre ne doit pas excéder 60 caractères");
			}
			
		} else {
			erreurs.put("titreLivre", "Veuillez ajouter un titre au livre");
		}
		
		
		try {
			nbPages = Integer.parseInt(request.getParameter("nbPagesLivre"));
		} catch (NumberFormatException e) {
			erreurs.put("nbPagesLivre", "Veuillez donner le nombre de pages");
		}
		
		if(categorie != null) {
			if (categorie.length() > 20) {
				erreurs.put("categorieLivre", "La catégorie du livre ne doit pas accéder 20 caractères");
			}
		}
		
		try {
			long idAuteur = Long.parseLong(request.getParameter("auteurLivre"));
			auteur = auteurDao.trouver(idAuteur);
		} catch (DaoException e) {
				erreurs.put("auteurLivre", "L'auteur n'existe pas");
		}
		
		Livre livreAAjouter = new Livre();
		livreAAjouter.setTitre(titre);
		livreAAjouter.setNbPages(nbPages);
		livreAAjouter.setCategorie(categorie);
		livreAAjouter.setAuteur(auteur);

		if (erreurs.isEmpty() ) {
			
			try {
				livreDao.creer(livreAAjouter);
			} catch (DaoException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect(request.getContextPath() + "/ListeLivres");
			
		} else {
			
			List<Auteur> auteurs = null;
			
			try {
				auteurs = auteurDao.lister();
				request.setAttribute("auteurs", auteurs);
			} catch (DaoException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("livre", livreAAjouter);
			request.setAttribute("erreurs", erreurs);
			this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterLivre.jsp").forward(request, response);		
		}

	}

}
