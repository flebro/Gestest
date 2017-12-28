package com.master.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	@ManyToMany
	@JoinTable(name="test_questionnaire", joinColumns=@JoinColumn(name="test_id"), inverseJoinColumns=@JoinColumn(name="questionnaire_id"))
	List<Questionnaire> questionnaires;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
	@ManyToMany
	@JoinTable(name="candidat_test", joinColumns=@JoinColumn(name="test_id"), inverseJoinColumns=@JoinColumn(name="candidat_id"))
	private List<Candidat> candidats;
	
}
