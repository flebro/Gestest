package com.master.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Proposition;

@Repository @Transactional
public class PropositionDao extends AbstractIdDao<Proposition> implements IPropositionDao {
	
	/**
	 * Pour détection par AOP
	 */
	@Override
	public Proposition save(Proposition model) {
		// TODO Auto-generated method stub
		return super.save(model);
	}

	@Override
	public List<Proposition> listAutreBonnesPropositions(Proposition proposition) {
		String queryString = "SELECT proposition FROM Proposition proposition" +
				" WHERE proposition.question = :question" +
				" AND proposition <> :proposition";

		return getEntityManager().createQuery(queryString, Proposition.class)
				.setParameter("question", proposition.getQuestion())
				.setParameter("proposition", proposition)
				.getResultList();
	}

}
