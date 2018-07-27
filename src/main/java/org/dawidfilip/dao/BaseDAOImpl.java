package org.dawidfilip.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

public abstract class BaseDAOImpl implements BaseDAO {
	
	private static Logger LOGGER = Logger.getLogger(BaseDAOImpl.class.getSimpleName());
	
	protected EntityManager entityManager;
	//private Class<?> type;
	private String simpleClassName;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void setType(Class<?> type) {
		//this.type = type;
		setSimpleClassName(type);
	}
	
	private void setSimpleClassName(Class<?> type) {
		this.simpleClassName = type.getSimpleName();
	}
	
	
	public void add(Object entity) {
		entityManager.getTransaction().begin();	
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been added.");
	}
	
	public void addAll(List<Object> entities) {
		LOGGER.info("Adding all " + entities != null ? entities.size() : null + " entities...");
		for (Object entity : entities) {
			add(entity);
		}
	}

	public void update(Object entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been updated.");
	}
	
	public void updateAll(List<Object> entities) {
		LOGGER.info("Updating all " + entities != null ? entities.size() : null + " entities...");
		for (Object entity : entities) {
			update(entity);
		}
	}

	public void delete(Object entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been removed.");
	}
	
	public void deleteAll(List<Object> entities) {
		LOGGER.info("Deleting all " + entities != null ? entities.size() : null + " entities...");
		for (Object entity : entities) {
			delete(entity);
		}
	}
	
	public void deleteById(Object key) {
		entityManager.getTransaction().begin();
		Object object = entityManager.createNamedQuery(simpleClassName + ".delete")
				.setParameter("id", key)
				.getSingleResult();
		entityManager.getTransaction().commit();
		LOGGER.info("Entity with " + key + " key has been deleted.");
	}
	
	public List<?> findAll() {
		entityManager.getTransaction().begin();
		List<?> objects = entityManager.createNamedQuery(simpleClassName + ".findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		LOGGER.info("Entities " + simpleClassName + " in size of " + objects.size() + " has been found.");
		return objects;
	}

	public Object findById(Object key) {
		entityManager.getTransaction().begin();
		Object object = entityManager.createNamedQuery(simpleClassName + ".find")
				.setParameter("id", key)
				.getSingleResult();
		entityManager.getTransaction().commit();
		
		if (object==null) 
			object = new Object();
		
		LOGGER.info("Entity with " + key + " and content " + object.toString() + " has been found.");
		return object;
	}
	
}

