package org.dawidfilip.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface BaseDAO {
	void setEntityManager(EntityManager entityManager);
	void setType(Class<?> type);
	
	void add(Object entity);
	void update(Object entity);
	void delete(Object entity);
	
	List<?> findAll();
	Object findById(Object key);
}
