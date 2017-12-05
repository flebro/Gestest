package com.master.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.ITestDao;
import com.master.model.Candidat;
import com.master.model.Personne;
import com.master.model.Test;

@Controller
public class TestListController {

	@Autowired
	private ITestDao testDao;

	@RequestMapping(value = "tests", method = RequestMethod.GET)
	public String get(HttpSession session) {
		Personne user = (Personne) session.getAttribute("user");
		List<Test> tests = user instanceof Candidat ? testDao.listFor((Candidat) user) : testDao.findAll();
		if (user instanceof Candidat && tests.size() == 1) {
			// Un seul test de disponible pour ce candidat, on redirige directement vers la fiche du test
			return "test/" + tests.get(0).getId();
		} else {
			return "tests";			
		}		
	}

}
