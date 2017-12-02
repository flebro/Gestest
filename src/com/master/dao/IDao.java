package com.master.dao;

import java.util.List;

public interface IDao<T> {

	T get(long id);

	List<T> findAll();

	T save(T model);

	void delete(T model);

}
