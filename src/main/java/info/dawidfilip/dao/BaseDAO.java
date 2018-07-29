package info.dawidfilip.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface BaseDAO {
	void setEntityManager(EntityManager entityManager);
	void setType(Class<?> type);
	
	void add(Object entity);
	void addAll(List<Object> entities);
	void update(Object entity);
	void updateAll(List<Object> entities);
	void delete(Object entity);
	void deleteAll(List<Object> entities);
	
	List<?> findAll();
	Object findById(Object key);
}
