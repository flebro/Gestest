package com.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.IQuestionnaireDao;
import com.master.dao.ITestDao;
import com.master.model.Questionnaire;
import com.master.model.Test;

@Controller
public class TestController {

	@Autowired
	private ITestDao testDao;
	@Autowired
	private IQuestionnaireDao questionnaireDao;

	@RequestMapping(value = "test/{id}", method = RequestMethod.GET)
	public String get(@PathVariable(name="id", required=true) Long id, Model model) {
		Test test = testDao.getWithQuestionnaires(id);
		if (test != null) {
			model.addAttribute("test", test);
			model.addAttribute("questionnairesDisponibles", test.getQuestionnaires().size() == 0 ?
					questionnaireDao.findAll() :
						questionnaireDao.listDisponiblesFor(test));
			return "test";
		} else {
			return "redirect:/tests/";
		}
	}

	@RequestMapping(value = "test/{id}/questionnaire", method = RequestMethod.POST)
	public String post(@PathVariable(name="id", required=true) Long id, Long questionnaireAjoutId) {
		Test test = testDao.getWithQuestionnaires(id);
		if (test != null && questionnaireAjoutId != null) {
			Questionnaire questionnaire = questionnaireDao.get(questionnaireAjoutId);
			if (questionnaire != null) {
				test.getQuestionnaires().add(questionnaire);
				testDao.save(test);
			}
		}
		return "redirect:/test/" + test.getId();
	}

	@RequestMapping(value = "test/{testId}/questionnaire/{questId}", method = RequestMethod.DELETE)
	public String desassocie(@PathVariable(name="testId", required=true) Long testId, @PathVariable(name="questId", required=true) Long questId, Model model) {
		Test test = testDao.getWithQuestionnaires(testId);
		if (test != null) {
			Questionnaire questionnaire = questionnaireDao.get(questId);
			if (questionnaire != null) {
				test.getQuestionnaires().remove(questionnaire);
				testDao.save(test);
			}
		} 
		return "redirect:/test/" + test.getId();
	}

}
