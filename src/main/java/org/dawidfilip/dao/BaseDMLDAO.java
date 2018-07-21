package org.dawidfilip.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

public abstract class BaseDMLDAO implements BaseEntityManager {
	
	private static Logger LOGGER = Logger.getLogger(BaseDMLDAO.class.getSimpleName());
	
	protected EntityManager entityManager;
	private Class<?> type;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void setType(Class<?> type) {
		this.type = type;
	}
	
	public void add(Object entity) {
		entityManager.getTransaction().begin();	
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been added.");
	}

	public void update(Object entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been updated.");
	}

	public void delete(Object entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been removed.");
	}
	
	public List<?> findAll() {
		entityManager.getTransaction().begin();
		List<?> objects = entityManager.createNamedQuery(type.getSimpleName() + ".findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		LOGGER.info("Entities " + type.getSimpleName() + " in size of " + objects.size() + " has been found.");
		return objects;
	}

	public Object find(Object key) {
		entityManager.getTransaction().begin();
		Object object = entityManager.createNamedQuery(type.getSimpleName() + ".find")
				.setParameter("id", key)
				.getSingleResult();
		entityManager.getTransaction().commit();
		
		if (object==null) 
			object = new Object();
		
		LOGGER.info("Entity with " + key + " and content " + object.toString() + " has been found.");
		return object;
	}

	
	
}

