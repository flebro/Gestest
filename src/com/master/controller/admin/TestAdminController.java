package com.master.controller.admin;

import javax.servlet.http.HttpSession;

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
public class TestAdminController {

	@Autowired
	private ITestDao testDao;
	@Autowired
	private IQuestionnaireDao questionnaireDao;
	
	@RequestMapping(value = "admin/tests", method = RequestMethod.GET)
	public String get(HttpSession session, Model model) {
		model.addAttribute("tests", testDao.findAll());
		return "tests";			
	}
	
	@RequestMapping(value = "admin/test", method = RequestMethod.POST)
	public String post(HttpSession session, String nom) {
		Test test = new Test();
		test.setNom(nom);
		testDao.save(test);
		return "redirect:/admin/tests";	
	}

	@RequestMapping(value = "admin/test/{id}", method = RequestMethod.GET)
	public String get(@PathVariable(name="id", required=true) Long id, Model model) {
		Test test = testDao.getWithQuestionnaires(id);
		if (test != null) {
			model.addAttribute("test", test);
			model.addAttribute("questionnairesDisponibles", test.getQuestionnaires().size() == 0 ?
					questionnaireDao.findAll() :
						questionnaireDao.listDisponiblesFor(test));
			return "test";
		} else {
			return "redirect:/admin/tests/";
		}
	}

	@RequestMapping(value = "admin/test/{id}/questionnaire", method = RequestMethod.POST)
	public String post(@PathVariable(name="id", required=true) Long id, Long questionnaireAjoutId) {
		Test test = testDao.getWithQuestionnaires(id);
		if (test != null && questionnaireAjoutId != null) {
			Questionnaire questionnaire = questionnaireDao.get(questionnaireAjoutId);
			if (questionnaire != null) {
				test.getQuestionnaires().add(questionnaire);
				testDao.save(test);
			}
		}
		return "redirect:/admin/test/" + test.getId();
	}

	@RequestMapping(value = "admin/test/{testId}/questionnaire/{questId}", method = RequestMethod.DELETE)
	public String desassocie(@PathVariable(name="testId", required=true) Long testId, @PathVariable(name="questId", required=true) Long questId, Model model) {
		Test test = testDao.getWithQuestionnaires(testId);
		if (test != null) {
			Questionnaire questionnaire = questionnaireDao.get(questId);
			if (questionnaire != null) {
				test.getQuestionnaires().remove(questionnaire);
				testDao.save(test);
			}
		} 
		return "redirect:/admin/test/" + test.getId();
	}

}
