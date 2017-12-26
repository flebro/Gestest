package com.master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.master.dao.IPropositionDao;
import com.master.model.Proposition;

@Aspect @Component
public class PropositionAspect {

	@Autowired
	private IPropositionDao propositionDao;
	
	/**
	 * Cette méthode écoute le résultat d'une sauvegarde de proposition.
	 * Si la proposition est définie comme étant la bonne, elle s'assure qu'il n'y en ai pas d'autre pour la même question. 
	 * @param joinPoint
	 * @param proposition
	 */
	@AfterReturning(pointcut="execution(* com.master.dao.IPropositionDao.save(..))", returning="proposition")
	public void assurePropositionCorrecteUnique(JoinPoint joinPoint, Proposition proposition) {
		if (proposition.isBonneReponse()) {
			for (Proposition autre : propositionDao.listAutreBonnesPropositions(proposition) ) {
				autre.setBonneReponse(false);
				propositionDao.save(autre);
			}
		}
	}
	
}
