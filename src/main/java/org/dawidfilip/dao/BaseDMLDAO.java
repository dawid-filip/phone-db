package org.dawidfilip.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

public abstract class BaseDMLDAO implements BaseEntityManager {
	
	private static Logger LOGGER = Logger.getLogger(BaseDMLDAO.class.getSimpleName());
	
	protected EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
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
	
}

