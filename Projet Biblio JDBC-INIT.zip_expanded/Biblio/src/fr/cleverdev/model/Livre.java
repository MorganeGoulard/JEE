package fr.cleverdev.model;

import java.util.Objects;

public class Livre {

	
	private Long id;
	private Auteur auteur;
	private String titre;
	private Integer nbPages;
	private String categorie;
	

	
	public Livre() {
		
	}

	public Livre(Auteur auteur, String titre, int nbPages, String categorie) {
		this.auteur = auteur;
		this.titre = titre;
		this.nbPages = nbPages;
		this.categorie = categorie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Auteur getAuteur() {
		return auteur;
	}
	
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((idAuteur == null) ? 0 : idAuteur.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		result = prime * result + ((nbPages == null) ? 0 : nbPages.hashCode());
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("Livre [id=%s, idAuteur=%s, titre=%s, nbPages=%s, categorie=%s]", id, auteur.getId(), titre,
				nbPages, categorie);
	}

	@Override
	public boolean equals(Object obj) {
		if(((Auteur) obj).getId() != this.id) {
			return false;
		}
		
		return true;
	}
	
}
