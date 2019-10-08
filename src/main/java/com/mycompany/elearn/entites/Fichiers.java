package com.mycompany.elearn.entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="Fichiers")
public class Fichiers {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFichier;
	private String Nom;
	private String path ;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCours")
	private Cours cours;
	
	
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getIdFichier() {
		return idFichier;
	}

	public void setIdFichier(long idFichier) {
		this.idFichier = idFichier;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	

}
