package com.mycompany.elearn.entites;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Question")
public class Question {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idQuestion;
	
	private String ques;
	private String rep1,rep2,rep3;
	private int bonneRep;
	
	@ManyToOne
    @JoinColumn(name="idQuiz")
    private Quiz Quiz_Question;
	
	
	
	
	

	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getRep1() {
		return rep1;
	}

	public void setRep1(String rep1) {
		this.rep1 = rep1;
	}

	public String getRep2() {
		return rep2;
	}

	public void setRep2(String rep2) {
		this.rep2 = rep2;
	}

	public String getRep3() {
		return rep3;
	}

	public void setRep3(String rep3) {
		this.rep3 = rep3;
	}

	public int getBonneRep() {
		return bonneRep;
	}

	public void setBonneRep(int bonneRep) {
		this.bonneRep = bonneRep;
	}

	public Quiz getQuiz_Question() {
		return Quiz_Question;
	}

	public void setQuiz_Question(Quiz quiz_Question) {
		Quiz_Question = quiz_Question;
	}
	
	
	
	
	



	
}
