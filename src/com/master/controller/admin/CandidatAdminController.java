package com.master.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.ICandidatDao;
import com.master.dao.ITestDao;
import com.master.model.Candidat;
import com.master.model.Test;

@Controller
public class CandidatAdminController {

	@Autowired
	private ICandidatDao candidatDao;
	@Autowired
	private ITestDao testDao;

	@RequestMapping(value = "admin/candidats", method = RequestMethod.GET)
	public String get(HttpSession session, Model model) {
		model.addAttribute("candidats", candidatDao.findAll());
		return "candidats";			
	}
	
	@RequestMapping(value = "admin/candidat", method = RequestMethod.POST)
	public String post(@ModelAttribute("newCandidat") Candidat candidat) {
		candidatDao.save(candidat);
		return "redirect:/admin/candidats";	
	}
	
	@RequestMapping(value = "admin/candidat/{id}", method = RequestMethod.GET)
	public String get(@PathVariable(name = "id", required = true) Long id, Model model) {
		Candidat candidat = candidatDao.getWithTests(id);
		if (candidat != null) {
			model.addAttribute("candidat", candidat);
			model.addAttribute("testsDisponibles",
					candidat.getTests().size() == 0 ? testDao.findAll() : testDao.listDisponiblesFor(candidat));
			return "candidat";
		} else {
			return "redirect:/admin/candidats/";
		}
	}
	
	@RequestMapping(value = "admin/candidat/{id}/test", method = RequestMethod.POST)
	public String post(@PathVariable(name = "id", required = true) Long id, Long testAjoutId) {
		Candidat candidat = candidatDao.getWithTests(id);
		if (candidat != null && testAjoutId != null) {
			Test test = testDao.get(testAjoutId);
			if (test != null) {
				candidat.getTests().add(test);
				candidatDao.save(candidat);
			}
		}
		return "redirect:/admin/candidat/" + candidat.getId();
	}

	@RequestMapping(value = "admin/candidat/{candidatId}/test/{testId}", method = RequestMethod.DELETE)
	public String desassocie(@PathVariable(name = "candidatId", required = true) Long candidatId,
			@PathVariable(name = "testId", required = true) Long testId, Model model) {
		Candidat candidat = candidatDao.getWithTests(candidatId);
		if (candidat != null) {
			Test test = testDao.get(testId);
			if (test != null) {
				candidat.getTests().remove(test);
				candidatDao.save(candidat);
			}
		}
		return "redirect:/admin/candidat/" + candidat.getId();
	}
	
	@ModelAttribute("newCandidat")
	public Candidat newCandidat() {
		return new Candidat();
	}

}
