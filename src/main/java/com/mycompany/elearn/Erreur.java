package com.mycompany.elearn;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


	@Controller
	@RequestMapping("/")
	public class Erreur {
	  @RequestMapping(value = "404",method = RequestMethod.GET)
	  public String Page404(ModelMap model) {
	    return "error/404";
	  }
	    
	}


