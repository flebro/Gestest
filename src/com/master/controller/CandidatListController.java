package com.master.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.ICandidatDao;
import com.master.model.Candidat;
import com.master.model.Personne;
import com.master.model.Test;

@Controller
public class CandidatListController {

	@Autowired
	private ICandidatDao candidatDao;

	@RequestMapping(value = "candidats", method = RequestMethod.GET)
	public String get(HttpSession session, Model model) {
		model.addAttribute("candidats", candidatDao.findAll());
		return "candidats";			
	}
	
	@RequestMapping(value = "candidat", method = RequestMethod.POST)
	public String post(@ModelAttribute("newCandidat") Candidat candidat) {
		candidatDao.save(candidat);
		return "redirect:/candidats";	
	}
	
	@ModelAttribute("newCandidat")
	public Candidat tetrimino() {
		return new Candidat();
	}
	
}
