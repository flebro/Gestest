package com.master.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractIdDao<T> implements IDao<T> {

	@PersistenceContext
	private EntityManager em;
	protected EntityManager getEntityManager() {
		return em;
	}
	
	@Override
	public T get(long id) {
		Class<T> clslClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return em.find(clslClass, id);
	}
	
	@Override
	public List<T> findAll() {
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		CriteriaQuery criteria = em.getCriteriaBuilder().createQuery(clazz);
		criteria = criteria.select(criteria.from(clazz));
		return em.createQuery(criteria).getResultList();
	}
	
	@Override @Transactional
	public T save(T model) {
		return em.merge(model);
	}
	
	@Override @Transactional
	public void delete(T model) {
		em.remove(model);
	}
	
}
