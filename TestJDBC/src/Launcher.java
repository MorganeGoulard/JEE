
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Launcher {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost/biblio";
		String user = "postgres";
		String password = "poei35235";
		
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		
		//Lister les auteurs 
		/*List<Auteur> listeAuteurs = new ArrayList<Auteur>();
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  sta = con.createStatement();
			  
			  String query = "Select * from auteur";
			  System.out.println("query : "+query);
			  
			  rs = sta.executeQuery(query);
			  
			  while(rs.next()) {
				  String nom = rs.getString("nom");
				  String prenom = rs.getString("prenom");
				  System.out.println("Auteur : "+nom+" "+prenom);
			  }
			  
			  rs.close();
			  sta.close();
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("-------------------");
		
		//Récupérer un auteur à partir d'un ID
		Auteur auteur = new Auteur();
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  sta = con.createStatement();
			  
			  
			  String query = "Select * from auteur where id=2";
			  System.out.println("query : "+query);
			  
			  rs = sta.executeQuery(query);
			  
			  if(rs.next()) {
				  String nom = rs.getString("nom");
				  String prenom = rs.getString("prenom");
				  System.out.println("L'auteur recherché est : "+nom+" "+prenom);
			  }
			  
			  rs.close();
			  sta.close();
			  
			  
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("-------------------");
		
		//Ajouter un auteur
		/*auteur = new Auteur("Toto", "Tata", "0660606060", "toto@tata.fr");
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  sta = con.createStatement();
			  
			  String query="insert into auteur (nom, prenom, telephone, email) values ('Toto', 'Tata', '0660606060', 'toto@tata.fr')";
			  System.out.println("query : "+query);
			  
			  sta.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			  rs = sta.getGeneratedKeys();
			  
			  if(rs.next()) {
				  long id = rs.getLong(1);
				  System.out.println("id de l'auteur ajouté : "+id);
			  }
			  
			  String query2="select * from auteur where id=11";
			  rs = sta.executeQuery(query2);
			  if(rs.next()) {
				  String nom = rs.getString("nom");
				  String prenom = rs.getString("prenom");
				  System.out.println("Auteur ajouté : "+nom+" "+prenom);
			  }
			  
			  rs.close();
			  sta.close();
			  
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		
		System.out.println("-------------------");*/
		
		//Modifier un auteur
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  sta = con.createStatement();
			  
			  String query = "UPDATE auteur SET nom='Tyty', prenom='Tuitui', telephone='0607080910', email='tyty@ztuitui.fr' WHERE id=10"; 
			  
			  sta.executeUpdate(query);
			  
			  String query2="SELECT * FROM auteur WHERE id=10";
			  
			  rs = sta.executeQuery(query2);
			  if(rs.next()) {
				  String nom = rs.getString("nom");
				  String prenom = rs.getString("prenom");
				  String telephone = rs.getString("telephone");
				  String email = rs.getString("email");
				  System.out.printf("Auteur modifié : %s %s %s %s.\n",nom,prenom,telephone,email);
			  }
			  
			  rs.close();
			  sta.close();
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		
		System.out.println("-------------------"); 
		
		//Supprimer un auteur
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  sta = con.createStatement();
			  
			  String query = "DELETE FROM auteur WHERE nom='Toto'";
			  
			  sta.executeUpdate(query);
			  
			  String query2 = "SELECT * FROM auteur";
			  rs = sta.executeQuery(query2);
			  
			  while(rs.next()) {
				  String nom = rs.getString("nom");
				  String prenom = rs.getString("prenom");
				  System.out.printf("Auteur : %s %s\n",nom,prenom);
			  }
			  
			  rs.close();
			  sta.close();
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		
	}

}

