package com.master.dao;

import com.master.model.Administrateur;

public interface IAdministrateurDao extends IDao<Administrateur> {

	Administrateur findByLoginMotDePasse(String login, String motDePasse);
	
}
