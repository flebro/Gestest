package com.master.dao;

import java.util.List;

import com.master.model.Candidat;
import com.master.model.Test;

public interface ITestDao extends IDao<Test> {
	
	Test getWithQuestionnaires(Long id);
	
	List<Test> listFor(Candidat candidat);
	
	List<Test> listDisponiblesFor(Candidat candidat);

}
