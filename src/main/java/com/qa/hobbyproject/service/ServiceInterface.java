package com.qa.hobbyproject.service;

import java.util.List;

public interface ServiceInterface<T> {
	
	T create(T t);
	
	List<T> getAll();
	
	T getOne(Integer id);
	
	T update(Integer id, T t);
	
	void remove(Integer id);
}

