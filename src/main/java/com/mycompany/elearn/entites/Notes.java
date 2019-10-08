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
@Entity
@Table(name="Notes")
public class Notes implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idNote;
    private int note;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idEtudiant")
    private Etudiant etudiant_N;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idQuiz")
    private Quiz Quiz_N;

	public Long getIdNote() {
		return idNote;
	}

	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Etudiant getEtudiant_N() {
		return etudiant_N;
	}

	public void setEtudiant_N(Etudiant etudiant_N) {
		this.etudiant_N = etudiant_N;
	}

	public Quiz getQuiz_N() {
		return Quiz_N;
	}

	public void setQuiz_N(Quiz quiz_N) {
		Quiz_N = quiz_N;
	}
    
    

    
    
    

    
    
    
    
    
    
    
	
    

}