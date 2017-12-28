package com.master.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Candidat;
import com.master.model.Test;

@Repository @Transactional
public class TestDao extends AbstractIdDao<Test> implements ITestDao {

	@Override
	public Test getWithQuestionnaires(Long id) {
		String queryString = "SELECT test FROM Test test LEFT JOIN FETCH test.questionnaires WHERE test.id = :testId";

		try {
			return getEntityManager().createQuery(queryString, Test.class)
					.setParameter("testId", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Test> listFor(Candidat candidat) {
		String queryString = "SELECT DISTINCT test FROM Test test LEFT JOIN FETCH test.questionnaires WHERE :candidat IN elements(test.candidats)";

		return getEntityManager().createQuery(queryString, Test.class)
				.setParameter("candidat", candidat)
				.getResultList();
	}

	@Override
	public List<Test> listDisponiblesFor(Candidat candidat) {
		String queryString = "SELECT test FROM Test test WHERE test NOT IN (:tests)";

		return getEntityManager().createQuery(queryString, Test.class)
				.setParameter("tests", candidat.getTests())
				.getResultList();
	}

}
