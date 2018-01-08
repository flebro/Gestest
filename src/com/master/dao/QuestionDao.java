package com.master.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Proposition;
import com.master.model.Question;

@Repository @Transactional
public class QuestionDao extends AbstractIdDao<Question> implements IQuestionDao {
	
}
