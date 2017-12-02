package com.master.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String intitule;
	
	@ManyToOne
	@JoinColumn(name="questionnaire_id")
	private Questionnaire questionnaire;
	
	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Proposition> propositions;
}
