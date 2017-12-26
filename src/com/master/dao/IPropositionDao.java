package com.master.dao;

import java.util.List;

import com.master.model.Proposition;

public interface IPropositionDao extends IDao<Proposition> {

	List<Proposition> listAutreBonnesPropositions(Proposition proposition);
	
}
