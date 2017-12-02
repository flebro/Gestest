package com.master.dao;

import java.util.List;

import com.master.model.Candidat;
import com.master.model.Test;

public interface ITestDao extends IDao<Test> {
	
	List<Test> listFor(Candidat candidat);

}
