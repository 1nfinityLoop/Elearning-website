package com.mycompany.elearn.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name="Enseignant")
public class Enseignant implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idEnseignant")
    private Long idEnseignant;
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
	@Column(name = "grade")
	private String grade;
	@Column(name = "age")
	private int age;
    @OneToMany(fetch = FetchType.EAGER,mappedBy="Enst_cours")
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Cours> cours_enseignant;
    
    
    
	
	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Long idEnseignant) {
		this.idEnseignant = idEnseignant;
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
	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", userName=" + userName + ", password=" + password
				+ ", nom=" + nom + ", prenom=" + prenom + ", adress=" + adress + ", email=" + email + ", tel=" + tel
				+ ", grade=" + grade + ", age=" + age + ", cours_enseignant=" + cours_enseignant + "]";
	}
	public String getTel() {
		return tel;
	}
	public void setTel(	String tel) {
		this.tel = tel;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Collection<Cours> getCours_enseignant() {
		return cours_enseignant;
	}
	public void setCours_enseignant(Collection<Cours> cours_enseignant) {
		this.cours_enseignant = cours_enseignant;
	}
 

}
