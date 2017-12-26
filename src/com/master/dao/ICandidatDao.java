package com.master.dao;

import com.master.model.Candidat;

public interface ICandidatDao extends IDao<Candidat> {

	Candidat findByCle(String cle);
	
	Candidat getWithTests(Long id);
	
	boolean cleDisponible(String cleATester);
	
}
