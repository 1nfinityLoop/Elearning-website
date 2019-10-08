package com.mycompany.elearn.entites;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Quiz")
public class Quiz {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idQuiz;
	
	private String Nom;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private Cours idCours;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="Quiz_Question",cascade=CascadeType.ALL,orphanRemoval = true )
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Question> questions;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="Quiz_N",cascade=CascadeType.REMOVE,orphanRemoval = true )
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Notes> Notes;
	
	private int time;
	
	

	public Collection<Notes> getNotes() {
		return Notes;
	}

	public void setNotes(Collection<Notes> notes) {
		Notes = notes;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}

	public long getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(long idQuiz) {
		this.idQuiz = idQuiz;
	}

	public Cours getIdCours() {
		return idCours;
	}

	public void setIdCours(Cours idCours) {
		this.idCours = idCours;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}


	
}
