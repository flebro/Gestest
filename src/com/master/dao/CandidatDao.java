package com.master.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Candidat;

@Repository @Transactional
public class CandidatDao extends AbstractIdDao<Candidat> implements ICandidatDao {

	@Override
	public Candidat findByCle(String cle) {
		String queryString = "FROM Candidat WHERE cle = :cle";
		try {
			return getEntityManager().createQuery(queryString, Candidat.class)
					.setParameter("cle", cle)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Candidat getWithTests(Long id) {
		String queryString = "SELECT candidat FROM Candidat candidat LEFT JOIN FETCH candidat.tests WHERE candidat.id = :candidatId";

		try {
			return getEntityManager().createQuery(queryString, Candidat.class)
					.setParameter("candidatId", id)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
