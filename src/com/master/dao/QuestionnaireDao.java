package com.master.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Questionnaire;
import com.master.model.Test;

@Repository @Transactional
public class QuestionnaireDao extends AbstractIdDao<Questionnaire> implements IQuestionnaireDao {

	@Override
	public List<Questionnaire> listDisponiblesFor(Test test) {
		String queryString = "SELECT questionnaire FROM Questionnaire questionnaire WHERE questionnaire NOT IN (:questionnaires)";

		return getEntityManager().createQuery(queryString, Questionnaire.class)
				.setParameter("questionnaires", test.getQuestionnaires())
				.getResultList();
	}

}
