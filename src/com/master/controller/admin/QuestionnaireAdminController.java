package com.master.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.IQuestionnaireDao;
import com.master.model.Questionnaire;

@Controller
public class QuestionnaireAdminController {
	
	@Autowired
	private IQuestionnaireDao questionnaireDao;

	@RequestMapping(value = "admin/questionnaires", method = RequestMethod.GET)
	public String get(HttpSession session, Model model) {
		model.addAttribute("questionnaires", questionnaireDao.findAll());
		return "questionnaires";			
	}
	
	@RequestMapping(value = "admin/questionnaire", method = RequestMethod.POST)
	public String post(HttpSession session, String nom) {
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setNom(nom);
		questionnaire = questionnaireDao.save(questionnaire);
		return "redirect:/admin/questionnaire/" + questionnaire.getId();	
	}
	
	@RequestMapping(value = "admin/questionnaire/{id}", method = RequestMethod.GET)
	public String get(@PathVariable(name="id", required=true) Long id, Model model) {
		Questionnaire questionnaire = questionnaireDao.get(id);
		if (questionnaire != null) {
			model.addAttribute("questionnaire", questionnaire);
			return "questionnaire";
		} else {
			return "";
		}
	}
	
}
