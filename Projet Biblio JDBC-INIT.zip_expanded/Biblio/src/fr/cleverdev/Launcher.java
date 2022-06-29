package fr.cleverdev;

import java.util.List;

import fr.cleverdev.dao.AuteurDao;
import fr.cleverdev.dao.DaoException;
import fr.cleverdev.dao.DaoFactory;
import fr.cleverdev.dao.LivreDao;
import fr.cleverdev.model.Auteur;
import fr.cleverdev.model.Livre;

public class Launcher {

	public static void main(String[] args) throws DaoException {

		
		
		AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
		LivreDao livreDao = DaoFactory.getInstance().getLivreDao();
		List<Auteur> listAuteurs;
		List<Livre> listLivres;
		
		
		/*try {
			listAuteurs = auteurDao.lister();
			
		    Iterator<Auteur> i = listAuteurs.iterator();
		    while (i.hasNext()) {
		      System.out.println(i.next());
		    }

		} catch (DaoException e) {
			e.printStackTrace();
		}*/
		
		/*try {
			listLivres = livreDao.lister();
			
			Iterator<Livre> i = listLivres.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}

			} catch (DaoException e) {
				e.printStackTrace();
			}
		*/
	
		Auteur auteur;
		Livre livre;
		
		
		/*try
		{
			auteur = auteurDao.trouver(1);
			
			System.out.println(auteur);
		}
		catch (DaoException e) {
				e.printStackTrace();
			}*/
		
		try {
			livre = livreDao.trouver(1);
			System.out.println(livre);
		}
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		Auteur auteur1 = new Auteur("Michel","Jean","0605040302","dupont@jean.fr");
		
		/*try {
			auteurDao.creer(auteur1);
			System.out.println(auteur1);
		
			}
		catch (DaoException e) {
			e.printStackTrace();
		} */
		
		Livre livre1 = new Livre(auteur1,"Hello World",200,"Débutant");
		
		
		/*try {
			auteurDao.supprimer(12);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		*/
		
		
		/*try {
			
			var auteurAModifier = auteurDao.trouver(10);
			auteurAModifier.setNom("Michel");
			auteurAModifier.setPrenom("Jean-Michel");
			auteurAModifier.setEmail("jean@michel.fr");
			
			auteurDao.modifier(auteurAModifier);
			
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}*/
		
	}	
}
