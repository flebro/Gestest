package com.master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect @Component
public class TestAspect {

	@Before("execution(* com.master.dao.ICandidatDao.findByCle(..))")
	public void myTest(JoinPoint joinPoint) {
		System.out.println("AVANT LE GET DU LOGIN !!!");
	}
}
