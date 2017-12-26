package com.master.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.master.dao.IAdministrateurDao;
import com.master.model.Administrateur;

@Controller
public class LoginAdminController {

	@Autowired
	private IAdministrateurDao adminDao;
	
	@RequestMapping(value = "loginAdmin", method = RequestMethod.GET)
	public String get() {
		return "loginAdmin";
	}
	
	@RequestMapping(value = "loginAdmin", method = RequestMethod.POST)
	public String loginAdmin(@RequestParam String login, @RequestParam String motDePasse, HttpSession session, Model model) {
		Administrateur admin = adminDao.findByLoginMotDePasse(login, motDePasse);
		if (admin != null) {
			session.setAttribute("user", admin);
			return "redirect:/tests";
		} else {
			return "redirect:/loginAdmin";
		}
	}
	
}
