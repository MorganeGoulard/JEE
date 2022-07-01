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


@WebServlet("/ModifierAuteur")
public class ModifierAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AuteurDao auteurDao;
    
    public ModifierAuteur() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		long id = Long.parseLong(request.getParameter("id"));

		try {
			request.setAttribute("auteur", auteurDao.trouver(id));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModifierAuteur.jsp").forward(request, response);		

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Auteur auteurAModifier;
		
		String nom = request.getParameter("nomAuteur");
		String prenom = request.getParameter("prenomAuteur");
		String telephone = request.getParameter("telephoneAuteur");
		String email = request.getParameter("emailAuteur");
		long id = Long.parseLong(request.getParameter("id"));

		
		try {
			auteurAModifier = auteurDao.trouver(id);
			
			auteurAModifier.setNom(nom);
			auteurAModifier.setPrenom(prenom);
			auteurAModifier.setTelephone(telephone);
			auteurAModifier.setEmail(email);
			
			auteurDao.modifier(auteurAModifier);
			
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/ListeAuteurs");
		

	}
	
	

}
