package com.master.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.model.Candidat;
import com.master.model.Personne;

@Controller
public class HomeController {

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String get(HttpServletRequest request) {
		Personne user = (Personne) request.getSession().getAttribute("user");
		if (user instanceof Candidat) {
			return "redirect:/user/tests";
		} else {
			return "redirect:/admin/tests";
		}
	}
	
}
