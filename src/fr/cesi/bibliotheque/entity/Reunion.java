package fr.cesi.bibliotheque.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Reunion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private String lieu ;
	private String objectif ;
	private String compterendu ;
	private Date date_reunion ;
	
	@OneToMany
	private Tache tache;
	//Référence
	@OneToOne
	private Collaborateur collaborateur;
	//Participe
	@ManyToMany
	private List<Collaborateur> collaborateur = new ArrayList<>();
	
	public Reunion() {
	}
	
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getCompterendu() {
		return compterendu;
	}
	public void setCompterendu(String compterendu) {
		this.compterendu = compterendu;
	}
	public Date getDate_reunion() {
		return date_reunion;
	}
	public void setDate_reunion(Date date_reunion) {
		this.date_reunion = date_reunion;
	}
	public int getId() {
		return id;
	}
}
