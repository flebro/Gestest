package com.master.aspect;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.master.dao.ICandidatDao;
import com.master.model.Candidat;

@Aspect @Component
public class CandidatAspect {
	
	@Autowired
	private ICandidatDao candidatDao;

	/**
	 * Cette méthode écoute le résultat d'une sauvegarde de candidat.
	 * Si le candidat a au moins un test mais pas de clé, on lui génère une clé aléatoire
	 * @param joinPoint
	 * @param candidat
	 */
	@AfterReturning(pointcut="execution(* com.master.dao.ICandidatDao.save(..))", returning="candidat")
	public void genereCle(JoinPoint joinPoint, Candidat candidat) {
		if (candidat != null && StringUtils.isBlank(candidat.getCle()) && !candidat.getTests().isEmpty()) {
			ConstraintViolationException ex = null;
			do {
				String tempCle = UUID.randomUUID().toString().substring(0, 6);
				candidat.setCle(tempCle);
				try {
					candidatDao.save(candidat);					
				} catch(ConstraintViolationException e) {
					ex = e;
				}
			} while(ex != null);
		}
	}
	
}
