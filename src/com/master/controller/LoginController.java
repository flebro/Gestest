package com.master.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.master.dao.ICandidatDao;
import com.master.model.Candidat;

@Controller
public class LoginController {
	
	@Autowired
	private ICandidatDao candidatDao;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String get() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam String cle, HttpSession session, Model model) {
		Candidat candidat = candidatDao.findByCle(cle);
		if (candidat != null) {
			session.setAttribute("user", candidat);
			return "redirect:/home";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
