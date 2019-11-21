package fr.cesi.bibliotheque.model;

public class User {
	private Long id ;
	private String nom = "" ;
	private String prenom = "" ;
	private String type = "" ;
		
	public User(Long id, String nom, String prenom, String type) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type  = type;
	}
}
