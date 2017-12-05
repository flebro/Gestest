package com.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="administrateur")
public class Administrateur extends Personne {
	
	@Column(unique=true)
	private String login;
	
	private String motDePasse;

}
