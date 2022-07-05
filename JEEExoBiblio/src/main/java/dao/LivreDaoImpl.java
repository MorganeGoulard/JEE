package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Auteur;
import model.Livre;

public class LivreDaoImpl implements LivreDao {
	
	private static final String SQL_INSERT       = "INSERT INTO livre(id_auteur, titre, nb_pages, categorie) VALUES(?,?,?,?)";
	private static final String SQL_SELECT       = "SELECT * FROM livre";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM livre WHERE id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM livre WHERE id = ? ";
	private static final String SQL_UPDATE 		 = "UPDATE livre SET id_auteur=?, titre=?, nb_pages=?, categorie=? WHERE id = ?";

	private DaoFactory factory;
	
	Auteur auteur;
	Livre livre;
	
	public LivreDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void creer(Livre livre) throws DaoException {
		Connection con = null;
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			pst.setLong(1, livre.getAuteur().getId());
			pst.setString(2, livre.getTitre());
			pst.setLong(3, livre.getNbPages());
			pst.setString(4, livre.getCategorie());
			
			int statut = pst.executeUpdate();
			
            if ( statut == 0 ) {
                throw new DaoException( "Echec création Livre (aucun ajout)" );
            }
            
            ResultSet rsKeys = pst.getGeneratedKeys();
            if ( rsKeys.next() ) {
                livre.setId( rsKeys.getLong( 1 ) );
            } else {
                throw new DaoException( "Echec création Livre (ID non retourné)" );
            }
            rsKeys.close();
			pst.close();
			
			
		} catch (Exception ex) {
	    	throw new DaoException("Echec création Livre",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
	}
		
		
		@Override
		public void modifier(Livre livre) throws DaoException {
			Connection con = null;
			
			try { 
				con = factory.getConnection();
				
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
				pst.setLong(1, livre.getAuteur().getId());
				pst.setString(2, livre.getTitre());
				pst.setLong(3, livre.getNbPages());
				pst.setString(4, livre.getCategorie());
				pst.setLong(5, livre.getId());
				
				int statut = pst.executeUpdate();
				
	            if ( statut == 0 ) {
	                throw new DaoException( "Echec création Livre (aucun ajout)" );
	            }
			
	            pst.close();
			
			} catch (Exception ex) {
		    	throw new DaoException("Echec modification Auteur",ex);
		    } finally {
		    	factory.releaseConnection(con);
			}
		
		} 
		
		@Override
		public List<Livre> lister() throws DaoException {
			List<Livre> listeLivres = new ArrayList<Livre>();
			Connection   con=null;
			try {
				  con = factory.getConnection();
				  PreparedStatement pst = con.prepareStatement( SQL_SELECT );
			      ResultSet         rs  = pst.executeQuery();
			      while ( rs.next() ) {
			    	  listeLivres.add( map(rs) );
			      }
			      rs.close();
			      pst.close();
		    } catch(SQLException ex) {
		    	throw new DaoException("Erreur de lecture BDD Auteur", ex);
		    } finally {
		    	factory.releaseConnection(con);
			}
			return listeLivres;
		}
		
		
		@Override
		public Livre trouver(long id) throws DaoException {
			Livre            livre=null;
			Connection        con=null;
			PreparedStatement pst=null;
			ResultSet         rs=null;
			try {
				  con = factory.getConnection();
				  pst = con.prepareStatement( SQL_SELECT_BY_ID );
				  pst.setLong(1, id);
				  
			      rs  = pst.executeQuery();
			      if ( rs.next() ) {
			    	  livre = map(rs);
			      }
			      rs.close();
			      pst.close();
		    } catch(SQLException ex) {
		    	throw new DaoException("Erreur de recherche BDD Livre", ex);
		    } finally {
		    	factory.releaseConnection(con);
			}
			return livre;
		}
		
		@Override
		public void supprimer(long id) throws DaoException {
			Connection   con=null;
			try {
				  con = factory.getConnection();
				  PreparedStatement pst = con.prepareStatement( SQL_DELETE_BY_ID );
				  pst.setLong(1, id);
				  int statut = pst.executeUpdate();
				  if ( statut == 0 ) {
					  throw new DaoException("Erreur de suppression Livre("+id+")");
				  }
			      pst.close();
		    } catch(SQLException ex) {
		    	throw new DaoException("Erreur de suppression BDD Livre", ex);
		    } finally {
		    	factory.releaseConnection(con);
			}
			
		}
		
		
	
	    private static Livre map( ResultSet resultSet ) throws SQLException {
	        Livre l = new Livre();
	        l.setId( resultSet.getLong( "id" ) );
	        
			AuteurDao auteurDao = DaoFactory.getInstance().getAuteurDao();
			
			try {
				l.setAuteur(auteurDao.trouver(resultSet.getLong("id_auteur")));
			} catch (DaoException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	        l.setTitre( resultSet.getString( "titre" ) );
	        l.setNbPages( resultSet.getInt( "nb_pages" ) );
	        l.setCategorie( resultSet.getString( "categorie" ) );
	        return l;
	    }
	
	
	
	
	
}
