package fr.cesi.bibliotheque.entity;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reunion")
public class Reunion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	private String lieu ;
	private String objectif ;
	private String compterendu ;
	private Date date_reunion ;
	
	@OneToMany
	private Collection<Tache> taches;

	// Référence
	@OneToOne
	private Collaborateur collaborateurReferent;

	// Participe
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Collaborateur> collaborateursParticipants = new LinkedHashSet<Collaborateur>();
	
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

	public Collection<Tache> getTaches() {
		return taches;
	}

	public void setTaches(Collection<Tache> taches) {
		this.taches = taches;
	}

	public Collaborateur getCollaborateurReferent() {
		return collaborateurReferent;
	}

	public void setCollaborateurReferent(Collaborateur collaborateurReferent) {
		this.collaborateurReferent = collaborateurReferent;
	}

	public Collection<Collaborateur> getCollaborateursParticipants() {
		return collaborateursParticipants;
	}

	public void setCollaborateursParticipants(List<Collaborateur> collaborateursParticipants) {
		this.collaborateursParticipants = collaborateursParticipants;
	}
}
