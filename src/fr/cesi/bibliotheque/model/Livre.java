package fr.cesi.bibliotheque.model;

public class Livre {
	private Long id ;
	private String titre = "" ;
	private String auteur = "";
	private String categorie = "" ;
	private boolean reserv = false ;

	public Livre(Long id, String titre, String auteur, String categorie, boolean reserv) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.categorie = categorie;
		this.reserv = reserv;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public boolean getReserv() {
		return reserv;
	}

	public void setReserv(boolean reserv) {
		this.reserv = reserv;
	}
}

