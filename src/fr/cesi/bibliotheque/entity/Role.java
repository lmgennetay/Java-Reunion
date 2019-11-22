package fr.cesi.bibliotheque.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private String nom ;
	
	@OneToMany(mappedBy="role")
	private Collection<Collaborateur> collaborateurs;

	public Role() {
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(Collection<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
}
