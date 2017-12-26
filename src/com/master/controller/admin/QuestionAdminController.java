package com.master.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.IQuestionDao;
import com.master.dao.IQuestionnaireDao;
import com.master.model.Question;
import com.master.model.Questionnaire;

@Controller
public class QuestionAdminController {

	@Autowired
	private IQuestionDao questionDao;
	@Autowired
	private IQuestionnaireDao questionnaireDao;
	
	@RequestMapping(value = {"admin/questionnaire/{questionnaireId}/question/{questionId}","admin/questionnaire/{questionnaireId}/question"}, method = RequestMethod.GET)
	public String get(@PathVariable(name="questionnaireId", required=true) Long questionnaireId, @PathVariable(name="questionId", required=false) Long questionId, Model model) {
		Question question = null;
		if (questionId != null) {
			question = questionDao.get(questionId);
			// Controle de cohérence
			if (question == null || !question.getQuestionnaire().getId().equals(questionnaireId)) {
				return "redirect:/admin/questionnaire/" + questionnaireId;
			}
		} else {
			question = new Question();
		}
		model.addAttribute("question", question);
		model.addAttribute("questionnaireId", questionnaireId);
		return "question";
	}
	
	@RequestMapping(value = {"admin/questionnaire/{questionnaireId}/question/{questionId}","admin/questionnaire/{questionnaireId}/question"}, method = RequestMethod.POST)
	public String save(@PathVariable(name="questionnaireId", required=true) Long questionnaireId, @PathVariable(name="questionId", required=false) Long questionId, @ModelAttribute("question") Question question, BindingResult result, Model model) {
		Questionnaire questionnaire = questionnaireDao.get(questionnaireId);
		// Contrôle de cohérence
		if (questionnaire == null) {
			return "redirect:/admin/questionnaires/";
		} else {
			Question questionOriginale = questionId != null ? questionDao.get(questionId) : null;
			if (questionOriginale != null && !questionOriginale.getQuestionnaire().getId().equals(questionnaireId) ) {
				return "redirect:/admin/questionnaire/" + questionnaireId;
			}
		}
		// Mise à jour
		question.setId(questionId);
		question.setQuestionnaire(questionnaire);
		questionDao.save(question);
		return "redirect:/admin/questionnaire/" + questionnaireId;
	}
	
	@RequestMapping(value = "admin/questionnaire/{questionnaireId}/question/{questionId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(name="questionnaireId", required=true) Long questionnaireId, @PathVariable(name="questionId", required=true) Long questionId) {
		Questionnaire questionnaire = questionnaireDao.get(questionnaireId);
		// Contrôle de cohérence
		if (questionnaire == null) {
			return "redirect:/admin/questionnaires/";
		} else {
			Question question = questionDao.get(questionId);
			if (question == null || !question.getQuestionnaire().getId().equals(questionnaireId) ) {
				return "redirect:/admin/questionnaires/";
			} else {
				questionDao.delete(question);
				return "redirect:/admin/questionnaire/" + questionnaireId;
			}
		}
	}
	
	@ModelAttribute("question")
	public Question question() {
		return new Question();
	}
	
}
