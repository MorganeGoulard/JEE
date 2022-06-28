package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Exo2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		 String reponse = null;
		 String isGoodrequest = request.getParameter("isGood");
		 
		 
		 if(isGoodrequest != null) {
			 
		
			 if(isGoodrequest.equals("0")) {
			 reponse = "Ce n'est pas bon !";
			 } else if(isGoodrequest.equals("1")) {
			 reponse = "C'est bon";
			 }
		 }
			 request.setAttribute("isGood", reponse);
		
		 
			this.getServletContext().getRequestDispatcher("/WEB-INF/Exo2.jsp").forward(request, response);	
	}


}
