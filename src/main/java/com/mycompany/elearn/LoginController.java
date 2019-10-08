	package com.mycompany.elearn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.*;  

import com.mycompany.elearn.email.SmtpMailSender;
import com.mycompany.elearn.entites.Cours;
import com.mycompany.elearn.entites.Enseignant;
import com.mycompany.elearn.entites.Etudiant;
import com.mycompany.elearn.entites.Fichiers;
import com.mycompany.elearn.entites.Notes;
import com.mycompany.elearn.entites.Question;
import com.mycompany.elearn.entites.Quiz;
import com.mycompany.elearn.model.PersonneForm;
import com.mycompany.elearn.model.form_Reponse;
import com.mycompany.elearn.model.form_quiz;
import com.mycompany.elearn.services.ICoursService;
import com.mycompany.elearn.services.IEnseignantService;
import com.mycompany.elearn.services.IEtudiantService;
import com.mycompany.elearn.services.IFichiersService;
import com.mycompany.elearn.services.INotesService;
import com.mycompany.elearn.services.IQuestionService;
import com.mycompany.elearn.services.IQuizService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
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
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model,HttpSession session) {
		if(session.getAttribute("compte")!=null) {
			return "redirect:/home";
		}else {

			return "redirect:/login";
		}
	}
	
	//Deconnection
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, ModelMap model,HttpSession session) {
		
		session.removeAttribute("compte");
		return "redirect:/home";
	}
	
	//Connection
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, ModelMap model,HttpSession session,@ModelAttribute("erreur") String erreur) {
		if(session.getAttribute("compte")!=null) {
			return "redirect:/home";
		}
		model.addAttribute("erreur", erreur);
		model.addAttribute("Enseignant", new Enseignant());
		return "login/login";
	}
	
	@RequestMapping(value = "/LoginUser", method = RequestMethod.POST)
	public String connection(@ModelAttribute("Enseignant") @Valid Enseignant ens,
			final BindingResult result, 
			Model model,
			HttpSession session) {
		
		
		if (!result.hasErrors()) {
			            
                  Enseignant ens2= serviceEnseignant.findOne("email", ens.getEmail());
                  Etudiant etudiant = serviceEtudiant.findOne("email", ens.getEmail());
                  if(ens2!=null) {
                	  if(ens.getPassword().equals(ens2.getPassword())) {
                		  session.setAttribute("compte", ens2);
                		  session.setAttribute("type", "enseignant");
                   	   return "redirect:/home";
                	  }
                	    
                  }else if(etudiant!=null) {
                	  if(ens.getPassword().equals(etudiant.getPassword())) {
                		  session.setAttribute("compte", etudiant);
                		  session.setAttribute("type", "etudiant");
                    		return "redirect:/home";
                		  }
                	  
                  	
                  }
                	  model.addAttribute("erreur", "Email ou mot de passe Incorrecte");
                	  return "redirect:/login";
                  
                  
        }
		return "redirect:/login"; 
		
	}
	
	//home
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session) {
		
		
       
			if(session.getAttribute("compte")==null) {
				return "redirect:/login";
			}
		if(session.getAttribute("type").equals("enseignant")) {
			Enseignant ens = (Enseignant) session.getAttribute("compte");
			model.addAttribute("cours", serviceEnseignant.getById(ens.getIdEnseignant()).getCours_enseignant());
		}else {
			Etudiant etd = (Etudiant) session.getAttribute("compte");
			model.addAttribute("cours", serviceEtudiant.getById(etd.getIdEtudiant()).getCours_etudiant());
			
		}
		return "home/home";
	}
	
	
	// creation de compte
	
	@RequestMapping(value = "/CreationUser", method = RequestMethod.POST)
	public String creation(@ModelAttribute("PersonneForm") @Valid PersonneForm ens,final BindingResult result, Model model) {
		
		Enseignant enseignant = new Enseignant();
		Etudiant etudiant = new Etudiant();
		
		if (!result.hasErrors()) {
			
			if(serviceEnseignant.findOne("email",ens.getEmail())!=null || serviceEtudiant.findOne("email",ens.getEmail())!=null  ) {
				model.addAttribute("PersonneForm", ens);
	        	model.addAttribute("error","Email deja existant");
	        	return "register/register";
				
			}
			if(ens.getProfession().equals("Enseignant")) {
				
				enseignant.setNom(ens.getNom());
				enseignant.setPrenom(ens.getPrenom());
				enseignant.setEmail(ens.getEmail());
				enseignant.setAdress(ens.getAdress());
				enseignant.setAge(ens.getAge());
				enseignant.setTel(ens.getTel());
				enseignant.setPassword(ens.getPassword());
				enseignant.setUserName(ens.getUserName());
				enseignant.setGrade(ens.getGrade());
				serviceEnseignant.save(enseignant);
		   		model.addAttribute("bienvenue","Bienvenue sur notre site cher enseignant");
		       }else {
		    	   
		    	   etudiant.setNom(ens.getNom());
		    	   etudiant.setPrenom(ens.getPrenom());
		    	   etudiant.setEmail(ens.getEmail());
		    	   etudiant.setAdress(ens.getAdress());
		    	   etudiant.setAge(ens.getAge());
		    	   etudiant.setTel(ens.getTel());
		    	   etudiant.setPassword(ens.getPassword());
		    	   etudiant.setUserName(ens.getUserName());
		    	   etudiant.setNiveau(ens.getGrade());
					serviceEtudiant.save(etudiant);
					model.addAttribute("bienvenue","Bienvenue sur notre site cher etudiant ");
		       }
                   
        }else {
        	model.addAttribute("PersonneForm", ens);
        	model.addAttribute("error","Veuillez remplir tout les champs");
        	return "register/register";
        }
		       
		return "redirect:/login";
	}
	
	@RequestMapping(value="/register")
	public String register(Locale locale, Model model,HttpSession session) {
		if(session.getAttribute("compte")!=null) {
			return "redirect:/home";
		}
		
		
		model.addAttribute("PersonneForm", new PersonneForm());
		return "register/register";
	}
	
	
	
	@RequestMapping(value = "/uploadpdf/{id}", method = RequestMethod.POST)
	public String AjoutPdf(
			Model model,
			HttpSession session,
			@RequestParam("files") MultipartFile files,
			@PathVariable String id) {
		
		System.out.println(directory);
		new File(directory+"/"+id).mkdir();
		String directory2 = directory+"/"+id;
		StringBuilder fileNames = new StringBuilder();
		
			Path fileNameAndPath = Paths.get(directory2,files.getOriginalFilename());
			fileNames.append(files.getOriginalFilename());
			try {
				Files.write(fileNameAndPath,files.getBytes());
				Fichiers fichier = new Fichiers();
				fichier.setNom(files.getOriginalFilename());
				fichier.setPath(directory2+"/"+files.getOriginalFilename());
				fichier.setCours(serviceCours.getById(Long.parseLong(id)));
				serviceFichiers.save(fichier);
					/*
					 * envoie du mail 
					 */
				Resource r=new ClassPathResource("applicationContext.xml");  
				BeanFactory b=new XmlBeanFactory(r);  
				SmtpMailSender mailer=(SmtpMailSender)b.getBean("mailMail");  
				Cours moncours = (Cours) serviceCours.getById(Long.parseLong(id));
				

				for(Etudiant etd : moncours.getEtudiants()) {
					mailer.sendMail(etd.getEmail(),"Cours : "+moncours.getNom(),"Le fichier "+files.getOriginalFilename()+" a etais ajouter a votre cours .");
					}
		        
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return "redirect:/Cours/"+id;
	}
	
	
	
	@RequestMapping(value = "/Cours/{idCours}/pdf/{id}")
	public void telechargerFichier(HttpServletRequest request, HttpServletResponse response,
			Model model,
			HttpSession session,
			@PathVariable String id,@PathVariable String idCours) {
		
		Fichiers fichier = serviceFichiers.getById(Long.parseLong(id));
		String downloadFolder = directory+"/"+idCours;
		Path file = Paths.get(downloadFolder, fichier.getNom());
		
		if (Files.exists(file)) {
			// set content type
			response.setContentType("application/pdf");
			// add response header
			response.addHeader("Content-Disposition", "attachment; filename=" + fichier.getNom());
			try {
				// copies all bytes from a file to an output stream
				Files.copy(file, response.getOutputStream());
				// flushes output stream
				response.getOutputStream().flush();
			} catch (IOException e) {
				System.out.println("Error :- " + e.getMessage());
			}
		} else {
			System.out.println("Sorry File not found!!!!");
		}
			
		//return "redirect:/home";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/monprofile", method = RequestMethod.GET)
	public String profile(Locale locale, Model model,HttpSession session) {
		
		      
			if(session.getAttribute("compte")==null) {
				return "redirect:/login";
			}
			 model.addAttribute("monprofile",session.getAttribute("compte"));
			 
			 
		return "profile/monProfil";
	}
	
	
	
}
