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
	
	@ManyToMany
	@JoinTable(name="test_questionnaire", joinColumns=@JoinColumn(name="test_id"), inverseJoinColumns=@JoinColumn(name="questionnaire_id"))
	List<Questionnaire> questionnaires;
	
}
