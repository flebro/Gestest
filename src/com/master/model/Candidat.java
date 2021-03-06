package com.master.model;

import java.util.ArrayList;
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

	public String getCle() {
		return cle;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	
	public Candidat() {
		tests = new ArrayList<>();
	}
	
}
