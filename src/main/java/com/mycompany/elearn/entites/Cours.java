package com.mycompany.elearn.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="Cours")
public class Cours implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCours;
	@NotEmpty
    private String Nom;
	
    private String Description;
    
    @OneToOne(mappedBy = "idCours",cascade=CascadeType.ALL)
    private Quiz quiz;
    
   @OneToMany(mappedBy="cours",fetch=FetchType.EAGER ,cascade=CascadeType.ALL)
   @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Fichiers> fichier;
    
    @ManyToOne
    @JoinColumn(name="idEnseignant")
    private Enseignant Enst_cours;

    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Cours_etudiant", 
             joinColumns = { @JoinColumn(name = "idCours") }, 
             inverseJoinColumns = { @JoinColumn(name = "idEtudiant") })
    @Fetch(value = FetchMode.SUBSELECT)
    private  Collection<Etudiant> etudiants ;

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cours)) return false;
        Cours state = (Cours) o;
        return idCours == state.idCours ;
    }

    
    
    
    
    
    
    
    
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}


    
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}









	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}









	public Quiz getQuiz() {
		return quiz;
	}



	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}



	public Long getIdCours() {
		return idCours;
	}




	public void setIdCours(Long idCours) {
		this.idCours = idCours;
	}




	




	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public String getDescription() {
		return Description;
	}




	public void setDescription(String description) {
		Description = description;
	}






	public Collection<Fichiers> getFichier() {
		return fichier;
	}




	public void setFichier(Collection<Fichiers> fichier) {
		this.fichier = fichier;
	}




	public Enseignant getEnst_cours() {
		return Enst_cours;
	}




	public void setEnst_cours(Enseignant enst_cours) {
		Enst_cours = enst_cours;
	}




    
    
    

}