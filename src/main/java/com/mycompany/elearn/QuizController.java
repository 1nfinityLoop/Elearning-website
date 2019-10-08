package com.mycompany.elearn;

import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.elearn.email.SmtpMailSender;
import com.mycompany.elearn.entites.Cours;
import com.mycompany.elearn.entites.Etudiant;
import com.mycompany.elearn.entites.Notes;
import com.mycompany.elearn.entites.Question;
import com.mycompany.elearn.entites.Quiz;
import com.mycompany.elearn.model.form_Reponse;
import com.mycompany.elearn.model.form_quiz;
import com.mycompany.elearn.services.ICoursService;
import com.mycompany.elearn.services.IEnseignantService;
import com.mycompany.elearn.services.IEtudiantService;
import com.mycompany.elearn.services.IFichiersService;
import com.mycompany.elearn.services.INotesService;
import com.mycompany.elearn.services.IQuestionService;
import com.mycompany.elearn.services.IQuizService;

@Controller
public class QuizController {
	
	private static  String directory  = System.getProperty("user.dir")+"/uploads";
	
	 @Autowired
	   ServletContext context; 
	
	
	@Autowired
  private IEnseignantService serviceEnseignant;
	@Autowired	
	private IEtudiantService serviceEtudiant;
	@Autowired
	private ICoursService serviceCours;
	@Autowired
	private IFichiersService serviceFichiers;
	@Autowired
	private IQuizService serviceQuiz;
	@Autowired
	private IQuestionService serviceQuestion;
	@Autowired
	private INotesService serviceNotes;
	@Autowired
	private SmtpMailSender smtpMailSender;	
	
	
	

	@RequestMapping(value="/ajouterQuiz/{id}", method = RequestMethod.GET)
	public String AjouterQuiz(@ModelAttribute("CoursForm") @Valid Cours cour,
			final BindingResult result,
			Locale locale,
			Model model,
			HttpSession session,
			@PathVariable String id) {
		form_quiz formulaire = new form_quiz();
		
		if(session.getAttribute("compte")==null || session.getAttribute("type").equals("etudiant")) {
			return "redirect:/login";
		}
			
			model.addAttribute("idcours", id);
			
	model.addAttribute("form_quiz",formulaire);
	
		return "Quiz/ajoutQuiz";
	}
	
	@RequestMapping(value="/ajouterQuiz/ajoutQuiz/{id}", method = RequestMethod.POST)
	public String AjoutQuiz(@ModelAttribute("form_quiz") @Valid form_quiz quiz,
			final BindingResult result,
			Locale locale,
			Model model,
			HttpSession session,
			@PathVariable String id) {
	
		if(session.getAttribute("compte")==null || session.getAttribute("type").equals("etudiant")) {
			return "redirect:/login";
		}
		Quiz quiz_creer = new Quiz();
		quiz_creer.setIdCours(serviceCours.getById(Long.parseLong(id)));
		quiz_creer.setNom(quiz.getNom());
		quiz_creer.setTime(quiz.getTime());
		quiz_creer = serviceQuiz.save(quiz_creer);
		
		for(Question qst : quiz.getQuestions()) {
			qst.setQuiz_Question(quiz_creer);
			serviceQuestion.save(qst);
		}
		
		return "redirect:/Cours/"+id;
	}
	
	
	@RequestMapping(value = "/quiz/{id}", method = RequestMethod.GET)
	public String monQuiz(Locale locale, Model model,HttpSession session,@PathVariable String id) {
		
		      
			if(session.getAttribute("compte")==null||session.getAttribute("type").equals("etudiant")) {
				return "redirect:/login";
			}
			 model.addAttribute("Quizpage", serviceQuiz.getById((Long.parseLong(id))));
			 model.addAttribute("mesQuestions", serviceQuiz.getById((Long.parseLong(id))).getQuestions());
		
			 
		return "Quiz/monquiz";
	}
	
	
	@RequestMapping(value="/supprimerQuiz/{id}", method = RequestMethod.GET)
	public String SupprimerQuiz(Locale locale,
			Model model,
			HttpSession session,
			@PathVariable String id) {
		
		if(session.getAttribute("compte")==null || session.getAttribute("type").equals("etudiant")) {
			return "redirect:/login";
		}

		serviceQuiz.remove(Long.parseLong(id));
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/quizE/{id}", method = RequestMethod.GET)
	public String PasserQuiz(Locale locale, Model model,HttpSession session,@PathVariable String id) {
		
		if(session.getAttribute("compte")==null) {
			return "redirect:/login";
		}
			if(session.getAttribute("compte")==null) {
				return "redirect:/login";
			}
			
			form_Reponse formulaire = new form_Reponse();
			model.addAttribute("form_reponse",formulaire);
			
			 model.addAttribute("Quizpage", serviceQuiz.getById((Long.parseLong(id))));
			 model.addAttribute("mesQuestions", serviceQuiz.getById((Long.parseLong(id))).getQuestions());
		
			 
		return "Quiz/QuizE";
	}
	
	
	@RequestMapping(value="/quizE/correction/{id}", method = RequestMethod.POST)
	public String CorrectionQuiz(@ModelAttribute("form_reponse") @Valid form_Reponse reponse,
			final BindingResult result,
			Locale locale,
			Model model,
			HttpSession session,
			@PathVariable String id) {
		if(session.getAttribute("compte")==null) {
			return "redirect:/login";
		}
		
		System.out.println(reponse.getReponses().size());
		Collection<Question> bonnesReponses = serviceQuiz.getById((Long.parseLong(id))).getQuestions();
		int i=0,s=0;
		for(Question qst : bonnesReponses) {
			if(reponse.getReponses().get(i)==qst.getBonneRep()) {
				s++;
			}
			i++;
		}
		
		Notes N = new Notes();
		
		Etudiant etd = (Etudiant) session.getAttribute("compte");
		N.setEtudiant_N(serviceEtudiant.getById(etd.getIdEtudiant()));
		N.setNote(s);
		N.setQuiz_N(serviceQuiz.getById(Long.parseLong(id)));
		
		serviceNotes.save(N);
		
			
			
	
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/quiz/notes/{id}", method = RequestMethod.GET)
	public String NotesQuiz(Locale locale, Model model,HttpSession session,@PathVariable String id) {
		
		      
			if(session.getAttribute("compte")==null) {
				return "redirect:/login";
			}
			 model.addAttribute("NotesPage", serviceQuiz.getById((Long.parseLong(id))).getNotes());
			 
			 
			 
		return "notes/notesQuiz";
	}
	
	@RequestMapping(value = "/mesNotes", method = RequestMethod.GET)
	public String mesNotes(Locale locale, Model model,HttpSession session) {
		
		      
			if(session.getAttribute("compte")==null || session.getAttribute("type").equals("enseignant")) {
				return "redirect:/login";
			}
			Etudiant etd = (Etudiant) session.getAttribute("compte");
			 model.addAttribute("NotesPage", serviceEtudiant.getById(etd.getIdEtudiant()).getNotes());
			 
			 
			 
		return "notes/mesNotes";
	}

}
