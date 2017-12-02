package com.master.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questionnaire")
public class Questionnaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinTable(name="test_questionnaire", joinColumns=@JoinColumn(name="questionnaire_id"), inverseJoinColumns=@JoinColumn(name="test_id"))
	private List<Test> tests;
	
	@OneToMany(mappedBy="questionnaire", fetch=FetchType.LAZY)
	private List<Question> questions;
	
}
