package fr.cesi.bibliotheque.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//javaBean

@Entity
@Table(name="livres")
public class Livre implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	private String titre = "" ;
	private String auteur = "";
	private String categorie = "" ;
	private boolean reserv = false ;
	
	@ManyToOne
	@JoinColumn(name="user_fk")
	private User user;

	public Livre() {
	}

	public Long getId() {
		return id;
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

