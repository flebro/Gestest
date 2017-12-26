package com.master.dao;

import java.util.List;

import com.master.model.Questionnaire;
import com.master.model.Test;

public interface IQuestionnaireDao extends IDao<Questionnaire> {
	
	List<Questionnaire> listDisponiblesFor(Test test);
	
}
