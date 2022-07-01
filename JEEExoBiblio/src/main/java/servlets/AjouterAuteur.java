package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Auteur;


@WebServlet("/AjouterAuteur")
public class AjouterAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AuteurDao auteurDao;

    public AjouterAuteur() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterAuteur.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nomAuteur");
		String prenom = request.getParameter("prenomAuteur");
		String telephone = request.getParameter("telephoneAuteur");
		String email = request.getParameter("emailAuteur");
		
		Map<String,String> erreurs = new HashMap<String,String>();		
		
		if(nom != null) {
			if(nom.length()<2 || nom.length()>20) {
				erreurs.put("nomAuteur","Le nom de l'auteur doit contenir entre 2 et 20 caractères");
			}
			
		} else {
			erreurs.put("nomAuteur", "Merci d'entrer un nom d'auteur");
		}
		
		if(prenom != null) {
			if(prenom.length()>20) {
				erreurs.put("prenomAuteur","Le prénom de l'auteur doit avoir maximum 20 caractères");
			}
		}
		
		if(telephone != null) {
			if(telephone.length() > 10) {
				erreurs.put("telephoneAuteur","Le numéro de téléphone doit contenir maximum 10 chiffres");
			}
			if(!telephone.matches("^\\d+$")) {
				erreurs.put("telephoneAuteur","Le numéro de téléphone doit contenir que des chiffres");
			}
				
		} else {
			erreurs.put("telephoneAuteur", "Merci d'entrer un numéro de téléphone");
		}
		
		if(email != null) {
			if(email.length() > 60) {
				erreurs.put("emailAuteur","L'émail doit avoir au maximum 60 caractères");
			}
			if(!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$")) {
				erreurs.put("emailAuteur","Veuillez saisir une adresse mail valide");
			}
		}
		
		Auteur auteur = new Auteur ();
		auteur.setNom(nom);
		auteur.setPrenom(prenom);
		auteur.setTelephone(telephone);
		auteur.setEmail(email);
		
		if(erreurs.isEmpty()) {
			try {
				auteurDao.creer(auteur);
			} catch (DaoException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect(request.getContextPath() + "/ListeAuteurs");

		} else {
		
			request.setAttribute("auteur", auteur);
			request.setAttribute("erreurs", erreurs);
			this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterAuteur.jsp").forward(request, response);		

		}
		
	}

}
