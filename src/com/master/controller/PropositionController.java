package com.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.IPropositionDao;
import com.master.dao.IQuestionDao;
import com.master.dao.IQuestionnaireDao;
import com.master.model.Proposition;
import com.master.model.Question;
import com.master.model.Questionnaire;

@Controller
public class PropositionController {

	@Autowired
	private IPropositionDao propositionDao;
	@Autowired
	private IQuestionDao questionDao;
	@Autowired
	private IQuestionnaireDao questionnaireDao;

	
	@RequestMapping(value = {"questionnaire/{questionnaireId}/question/{questionId}/proposition/{propositionId}","questionnaire/{questionnaireId}/question/{questionId}/proposition"}, method = RequestMethod.GET)
	public String get(@PathVariable(name="questionnaireId", required=true) Long questionnaireId, @PathVariable(name="questionId", required=true) Long questionId, @PathVariable(name="propositionId", required=false) Long propositionId, Model model) {
		Proposition proposition = null;
		if (propositionId != null) {
			proposition = propositionDao.get(propositionId);
			// Controle de cohérence
			if (proposition == null || !proposition.getQuestion().getId().equals(questionId)) {
				return "redirect:/questionnaire/" + questionnaireId;
			}
		} else {
			proposition = new Proposition();
		}
		model.addAttribute("proposition", proposition);
		model.addAttribute("questionId", questionId);
		model.addAttribute("questionnaireId", questionnaireId);
		return "proposition";
	}
	
	@RequestMapping(value = {"questionnaire/{questionnaireId}/question/{questionId}/proposition/{propositionId}","questionnaire/{questionnaireId}/question/{questionId}/proposition"}, method = RequestMethod.POST)
	public String save(@PathVariable(name="questionnaireId", required=true) Long questionnaireId, @PathVariable(name="questionId", required=true) Long questionId, @PathVariable(name="propositionId", required=false) Long propositionId, @ModelAttribute("proposition") Proposition proposition) {
		Question question = questionDao.get(questionId);
		// Contrôle de cohérence
		if (question == null) {
			return "redirect:/questionnaires/";
		} else {
			Proposition propositionOriginale = propositionId != null ? propositionDao.get(propositionId) : null;
			if (propositionOriginale != null && !propositionOriginale.getQuestion().getId().equals(questionId) ) {
				return "redirect:/questionnaire/" + questionnaireId;
			}
		}
		// Mise à jour
		proposition.setId(propositionId);
		proposition.setQuestion(question);
		propositionDao.save(proposition);
		return "redirect:/questionnaire/" + questionnaireId;
	}
	
	@RequestMapping(value = "questionnaire/{questionnaireId}/question/{questionId}/proposition/{propositionId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(name="questionnaireId", required=true) Long questionnaireId, @PathVariable(name="questionId", required=true) Long questionId, @PathVariable(name="propositionId", required=true) Long propositionId) {
		Questionnaire questionnaire = questionnaireDao.get(questionnaireId);
		// Contrôle de cohérence
		if (questionnaire == null) {
			return "redirect:/questionnaires/";
		} else {
			Question question = questionDao.get(questionId);
			Proposition proposition = propositionDao.get(propositionId);
			if (question != null && proposition != null && question.getQuestionnaire().getId().equals(questionnaireId) && proposition.getQuestion().getId().equals(questionId) ) {
				propositionDao.delete(proposition);
			}
			return "redirect:/questionnaire/" + questionnaireId;
		}
	}
	
	@ModelAttribute("proposition")
	public Proposition proposition() {
		return new Proposition();
	}
	
}
