package com.master.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.master.dao.IAdministrateurDao;
import com.master.dao.ICandidatDao;
import com.master.model.Administrateur;
import com.master.model.Candidat;

@Controller
public class LoginController {
	
	@Autowired
	private ICandidatDao candidatDao;
	@Autowired
	private IAdministrateurDao adminDao;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String get() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam String cle, HttpSession session, Model model) {
		Candidat candidat = candidatDao.findByCle(cle);
		if (candidat != null) {
			session.setAttribute("user", candidat);
			return "home";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "loginAdmin", method = RequestMethod.POST)
	public String loginAdmin(@RequestParam String login, @RequestParam String motDePasse, HttpSession session, Model model) {
		Administrateur admin = adminDao.findByLoginMotDePasse(login, motDePasse);
		if (admin != null) {
			session.setAttribute("user", admin);
			return "home";
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
