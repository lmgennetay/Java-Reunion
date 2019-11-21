package fr.cesi.bibliotheque.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Tache {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private Date date_echeance ;
	private String nom ;
	private String description ;
	
	@OneToMany
	private Collaborateur collaborateur;
	@OneToOne
	private Reunion reunion;

	public Tache() {
	}
	
	public Date getDate_echeance() {
		return date_echeance;
	}
	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
}
