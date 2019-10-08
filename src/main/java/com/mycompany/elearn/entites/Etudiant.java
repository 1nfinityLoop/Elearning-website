package com.mycompany.elearn.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name="Etudiant")
public class Etudiant implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idEtudiant")
    private Long idEtudiant;
	@Column(name = "username")
    private String userName;
	@Column(name = "password")
    private String password;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adress")
	private String adress;
	@Column(name = "email")
	private String email;
	@Column(name = "tel")
	private String tel;
	@Column(name = "niveau")
	private String niveau;
	@Column(name = "age")
	private int age;
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "etudiants")
	@Fetch(value = FetchMode.SUBSELECT)
	private  Collection<Cours> cours_etudiant ;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="etudiant_N",cascade=CascadeType.ALL,orphanRemoval = true )
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Notes> Notes;
	
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Etudiant)) return false;
	        Etudiant state = (Etudiant) o;
	        return idEtudiant == state.idEtudiant ;
	    }
	
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Collection<Cours> getCours_etudiant() {
		return cours_etudiant;
	}
	public void setCours_etudiant(Collection<Cours> cours_etudiant) {
		this.cours_etudiant = cours_etudiant;
	}
	public Collection<Notes> getNotes() {
		return Notes;
	}
	public void setNotes(Collection<Notes> notes) {
		Notes = notes;
	}
    
	
    
    
	
 

}
