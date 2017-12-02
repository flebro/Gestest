package com.master.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="candidat")
public class Candidat extends Personne {

	@ManyToMany
	@JoinTable(name="candidat_test", joinColumns=@JoinColumn(name="candidat_id"), inverseJoinColumns=@JoinColumn(name="test_id"))
	private List<Test> tests;
	
}
