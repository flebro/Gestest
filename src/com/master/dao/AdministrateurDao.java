package com.master.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Administrateur;

@Repository @Transactional
public class AdministrateurDao extends AbstractIdDao<Administrateur> implements IAdministrateurDao {

	@Override
	public Administrateur findByLoginMotDePasse(String login, String motDePasse) {
		String queryRqt = "FROM Administrateur" +
				" WHERE login = :login" +
				" AND motDePasse = :motDePasse";
		try {
			return getEntityManager().createQuery(queryRqt, Administrateur.class).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
