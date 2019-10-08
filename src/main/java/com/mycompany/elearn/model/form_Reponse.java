package com.mycompany.elearn.model;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.elearn.entites.Question;

public class form_Reponse {
		private ArrayList<Integer> reponses ;

		
		
		
		public form_Reponse() {
			this.reponses = new ArrayList<Integer>(10);
			this.reponses.add(0);
			this.reponses.add(0);
			this.reponses.add(0);
			this.reponses.add(0);
			this.reponses.add(0);
			this.reponses.add(0);
			this.reponses.add(0);
			this.reponses.add(0);
			this.reponses.add(0);
			this.reponses.add(0);
					}

		public ArrayList<Integer> getReponses() {
			return reponses;
		}

		public void setReponses(ArrayList<Integer> reponses) {
			this.reponses = reponses;
		}
	
	
	

}
