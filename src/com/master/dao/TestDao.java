package com.master.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Candidat;
import com.master.model.Test;

@Repository @Transactional
public class TestDao extends AbstractIdDao<Test> implements ITestDao {

	@Override
	public List<Test> listFor(Candidat candidat) {
		String queryString = "SELECT candidat.tests FROM Candidat candidat WHERE candidat = :candidat";
		
		return getEntityManager().createQuery(queryString, Test.class)
				.setParameter("candidat", candidat)
				.getResultList();
	}
	
}
