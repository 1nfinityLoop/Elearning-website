package com.mycompany.elearn;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.mycompany.elearn.entites.Cours;
import com.mycompany.elearn.entites.Enseignant;
import com.mycompany.elearn.entites.Etudiant;
import com.mycompany.elearn.entites.Fichiers;
import com.mycompany.elearn.entites.Notes;
import com.mycompany.elearn.services.ICoursService;
import com.mycompany.elearn.services.IEtudiantService;
import com.mycompany.elearn.services.IFichiersService;


@Controller
public class CoursController {
	private static  String directory  = System.getProperty("user.dir")+"/uploads";
	
	
		@Autowired	
	private IEtudiantService serviceEtudiant;
	@Autowired
	private ICoursService serviceCours;
	@Autowired
	private IFichiersService serviceFichiers;

	
	@RequestMapping(value="/ajouterCours")
	public String AjouterCours(Locale locale, Model model,HttpSession session) {
		if(session.getAttribute("compte")==null) {
			return "redirect:/login";
		}
		model.addAttribute("CoursForm", new Cours());
		return "cours/ajoutCours";
	}
	
	
	@RequestMapping(value="/ajoutCours", method = RequestMethod.POST)
	public String AjoutCours(@ModelAttribute("CoursForm") @Valid Cours cour,
			final BindingResult result,
			Locale locale,
			Model model,
			HttpSession session) {
		if(session.getAttribute("compte")==null ||session.getAttribute("type").equals("etudiant")) {
			return "redirect:/login";
		}
		
		if (!result.hasErrors()) {
			cour.setEnst_cours((Enseignant) session.getAttribute("compte") );
			serviceCours.save(cour);
			return "redirect:/home";
		}else {
			model.addAttribute("error","Veuillez entrer le nom du cours");
			return "cours/ajoutCours";
		}
		
		
	}
	
	
	@RequestMapping(value = "/Cours/{id}", method = RequestMethod.GET)
	public String Cours(Locale locale, Model model,HttpSession session,@PathVariable String id) {
		
		      int b=0;
			if(session.getAttribute("compte")==null) {
				return "redirect:/login";
			}
			 model.addAttribute("coursPage", serviceCours.getById((Long.parseLong(id))));
			 model.addAttribute("mesfichiers", serviceCours.getById((Long.parseLong(id))).getFichier());
			 
			 if(session.getAttribute("type").equals("etudiant")) {
				 Etudiant etd = (Etudiant) session.getAttribute("compte");
				 etd = serviceEtudiant.getById(etd.getIdEtudiant());
				 if(etd.getCours_etudiant().contains(serviceCours.getById(Long.parseLong(id)))) {
					 model.addAttribute("inscrit","oui");
					 if(serviceCours.getById(Long.parseLong(id)).getQuiz()!=null) {
						 for(Notes noteEtudiant : etd.getNotes() ) {
							 if(noteEtudiant.getQuiz_N().getIdQuiz()==serviceCours.getById(Long.parseLong(id)).getQuiz().getIdQuiz()) {

								 model.addAttribute("noteEtud",noteEtudiant.getNote());
								
								 break;
							 }
						 }
						 
						 
					 }
					 
					 
					 
				 }else {
					 model.addAttribute("inscrit","non");
				 }
					 
			 }
			 
		return "cours/moncours";
	}

	
	
	@RequestMapping(value = "/AllCours", method = RequestMethod.GET)
	public String allcours(Locale locale, Model model,HttpSession session) {
		
		
       
			if(session.getAttribute("compte")==null||session.getAttribute("type").equals("enseignant")) {
				return "redirect:/login";
			}
		if(session.getAttribute("type").equals("enseignant")) {
			return "redirect:/home";
		}else {
			
			model.addAttribute("cours",serviceCours.selectAll());
			
		}
		return "cours/allCours";
	}
	
	
	@RequestMapping(value="/inscriptionCours/{id}", method = RequestMethod.GET)
	public String InscriptionCours(Locale locale,
			Model model,
			HttpSession session,
			@PathVariable String id) {
		if(session.getAttribute("compte")==null||session.getAttribute("type").equals("enseignant")) {
			return "redirect:/login";
		}
		
		Etudiant etd = (Etudiant) session.getAttribute("compte");
		Etudiant etd2 = serviceEtudiant.getById(etd.getIdEtudiant());
		Cours cour = serviceCours.getById(Long.parseLong(id));
		cour.getEtudiants().add(etd2);
		etd2.getCours_etudiant().add(cour);
		
		serviceCours.update(cour);
		session.setAttribute("compte", etd2);
		return "redirect:/Cours/"+id;
	}
	
	
	@RequestMapping(value="/supprimerCours/{id}", method = RequestMethod.GET)
	public String SupprimerCours(Locale locale,
			Model model,
			HttpSession session,
			@PathVariable String id) {
		if(session.getAttribute("compte")==null||session.getAttribute("type").equals("etudiant")) {
			return "redirect:/login";
		}
		
		serviceCours.remove(Long.parseLong(id));
		return "redirect:/home";
	}
	
	

	@RequestMapping(value="/desinscriptionCours/{id}", method = RequestMethod.GET)
	public String desinscriptionCours(Locale locale,
			Model model,
			HttpSession session,
			@PathVariable String id) {
		
		if(session.getAttribute("compte")==null||session.getAttribute("type").equals("enseignant")) {
			return "redirect:/login";
		}
		System.out.println("suppression cours id "+id);
		
		Etudiant etd = (Etudiant) session.getAttribute("compte");
		Etudiant etd2 = serviceEtudiant.getById(etd.getIdEtudiant());
		Cours cour = serviceCours.getById(Long.parseLong(id));
		cour.getEtudiants().remove(etd2);
		etd2.getCours_etudiant().remove(cour);
		
		serviceCours.update(cour);
		session.setAttribute("compte", etd2);
		return "redirect:/Cours/"+id;
	}
	
	
	@RequestMapping(value = "/Cours/{idCours}/remove/pdf/{id}")
	public String supprimerFichier(HttpServletRequest request, HttpServletResponse response,
			Model model,
			HttpSession session,
			@PathVariable String id,@PathVariable String idCours) {
		
		if(session.getAttribute("compte")==null||session.getAttribute("type").equals("etudiant")) {
			return "redirect:/login";
		}
		
		Fichiers fichier = serviceFichiers.getById(Long.parseLong(id));
		String downloadFolder = directory+"/"+idCours;
		Path file = Paths.get(downloadFolder, fichier.getNom());
		
		if (Files.exists(file)) {
			serviceFichiers.remove(Long.parseLong(id));
		} else {
			System.out.println("Sorry File not found!!!!");
		}
			
		return "redirect:/Cours/"+idCours;
		
	}
	
	@RequestMapping(value="/listEtud/{id}", method = RequestMethod.GET)
	public String listEtudiant(Locale locale,
			Model model,
			HttpSession session,
			@PathVariable String id) {
		
		if(session.getAttribute("compte")==null||session.getAttribute("type").equals("etudiant")) {
			return "redirect:/login";
		}
		 model.addAttribute("NotesPage", serviceCours.getById(Long.parseLong(id)).getEtudiants());
		 
		 
		return "cours/listEtud";
	}
	
}
