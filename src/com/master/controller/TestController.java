package com.master.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.dao.ITestDao;
import com.master.model.Candidat;

@Controller
public class TestController {
	
	@Autowired
	private ITestDao testDao;
	
	@RequestMapping(value = "user/tests", method = RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {
		Candidat user = (Candidat) request.getSession().getAttribute("user");
		model.addAttribute("tests", testDao.listFor(user));
		return "candidatTests";
	}

}
