package com.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.IQuestionnaireDao;
import com.master.model.Questionnaire;

@Controller
public class QuestionnaireController {
	
	@Autowired
	private IQuestionnaireDao questionnaireDao;

	@RequestMapping(value = "questionnaire/{id}", method = RequestMethod.GET)
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
