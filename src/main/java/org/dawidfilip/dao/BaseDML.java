package org.dawidfilip.dao;

public interface BaseDML<T> {
	void add(T entity);
	void update(T entity);
	void delete(T entity);
}
