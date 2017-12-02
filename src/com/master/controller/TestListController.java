package com.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.master.dao.ITestDao;

@Controller
public class TestListController {

	@Autowired
	private ITestDao testDao;
	
	
	
}
