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

}
