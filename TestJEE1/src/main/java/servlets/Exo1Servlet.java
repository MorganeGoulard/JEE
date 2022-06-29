package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exo1Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> fruits = new ArrayList<String>();
		fruits.add("pomme");
		fruits.add("banane");
		fruits.add("kiwi");
		fruits.add("mangue");
		fruits.add("cerise");
		fruits.add("fraise");
		fruits.add("framboise");
		fruits.add("myrtille");
		fruits.add("cassis");
		fruits.add("groseille");
		
		// List<String> fruits = new ArrayList<String>(Array.asList("Poire","Pomme"...));
		
		request.setAttribute("Fruits", fruits);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Exo1.jsp").forward(request, response);	
		}

	
	
}
