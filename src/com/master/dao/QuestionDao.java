package com.master.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Proposition;
import com.master.model.Question;

@Repository @Transactional
public class QuestionDao extends AbstractIdDao<Question> implements IQuestionDao {

	@Autowired
	private IPropositionDao propositionDao;
	
	@Override
	public void delete(Question model) {
		for (Proposition proposition : model.getPropositions()) {
			propositionDao.delete(proposition);
		}
		super.delete(model);
	}
	
}
