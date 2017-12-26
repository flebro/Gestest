package com.master.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.IQuestionnaireDao;
import com.master.model.Questionnaire;

@Controller
public class QuestionnaireListController {

	@Autowired
	private IQuestionnaireDao questionnaireDao;

	@RequestMapping(value = "questionnaires", method = RequestMethod.GET)
	public String get(HttpSession session, Model model) {
		model.addAttribute("questionnaires", questionnaireDao.findAll());
		return "questionnaires";			
	}
	
	@RequestMapping(value = "questionnaire", method = RequestMethod.POST)
	public String post(HttpSession session, String nom) {
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setNom(nom);
		questionnaire = questionnaireDao.save(questionnaire);
		return "redirect:/questionnaire/" + questionnaire.getId();	
	}
	
}
