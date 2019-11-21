package fr.cesi.bibliotheque.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//javaBean
@XmlRootElement
@Entity
@Table(name="users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	private String nom = "" ;
	private String prenom = "" ;
	private String password = "" ;
	private String role = "" ;
	
	@OneToMany(mappedBy="user")
	private Collection< Livre > livres;
		
	public User() {
	}
	
	@XmlAttribute(name="id")
	public Long getId() {
		return id;
	}
	
	@XmlAttribute(name="nom")
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlAttribute(name="prenom")
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@XmlAttribute(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@XmlAttribute(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role  = role;
	}
}
