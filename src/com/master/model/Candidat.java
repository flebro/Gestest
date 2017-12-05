package com.master.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="candidat")
public class Candidat extends Personne {

	@Column(length=6, unique=true)
	private String cle;
	
	@ManyToMany
	@JoinTable(name="candidat_test", joinColumns=@JoinColumn(name="candidat_id"), inverseJoinColumns=@JoinColumn(name="test_id"))
	private List<Test> tests;
	
}
