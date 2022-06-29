package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Exo3Servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String reponse = "Bonjour";
		 String name = request.getParameter("name");
		 
		 
		 if(name != null) {
			 reponse = "Bonjour "+name;
			  
		 }
			 request.setAttribute("name", reponse);
			 
			 //le mieux c'est de mette bonjour dans jsp car statique,
			 // et lui faire juste passer le nom
			 
			 // correction Alex : 
			 // request.setAttribute("name", request.getParameter("name");
			 
			 // variante : on veut afficher Bonjour + nom + prenom 
			 // request.setAttribute("prenom", request.getParameter("prenom");
			 // request.setAttribute("nom", request.getParameter("nom");
			 // sur jsp : <p> Bonjour ${ prenom } ${ nom } ! </p>
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Exo3.jsp").forward(request, response);	
	}


	

}
