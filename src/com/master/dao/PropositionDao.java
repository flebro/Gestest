package com.master.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Proposition;

@Repository @Transactional
public class PropositionDao extends AbstractIdDao<Proposition> implements IPropositionDao {

}
