package com.master.aspect;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.master.dao.ICandidatDao;
import com.master.model.Candidat;

@Aspect @Component
public class CandidatAspect {
	
	@Autowired
	private ICandidatDao candidatDao;

	/**
	 * Cette méthode écoute le résultat d'une sauvegarde de proposition.
	 * Si la proposition est définie comme étant la bonne, elle s'assure qu'il n'y en ai pas d'autre pour la même question. 
	 * @param joinPoint
	 * @param proposition
	 */
	@AfterReturning(pointcut="execution(* com.master.dao.ICandidatDao.save(..))", returning="candidat")
	public void genereCle(JoinPoint joinPoint, Candidat candidat) {
		if (StringUtils.isBlank(candidat.getCle()) && !candidat.getTests().isEmpty()) {
			boolean genere = false;
			do {
				String tempCle = UUID.randomUUID().toString().substring(0, 6);
			} while(!genere);
		}
	}
	
}
