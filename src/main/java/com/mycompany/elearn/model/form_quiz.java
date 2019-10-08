package com.mycompany.elearn.model;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.elearn.entites.Question;

public class form_quiz {
	private String nom;
	private ArrayList<Question> questions ;
	private int time;
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public form_quiz() {
		this.questions = new ArrayList<Question>(10);
		this.questions.add(new Question());
		this.questions.add(new Question());
		this.questions.add(new Question());
		this.questions.add(new Question());
		this.questions.add(new Question());
		this.questions.add(new Question());
		this.questions.add(new Question());
		this.questions.add(new Question());
		this.questions.add(new Question());
		this.questions.add(new Question());
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

}
