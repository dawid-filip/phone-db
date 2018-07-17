package org.dawidfilip.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

@Service
public class PhoneEntityManagerImpl implements PhoneEntityManager {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public PhoneEntityManagerImpl() {
		create();
	}
	
	public static final EntityManager getEntityManager(String persistenceUnitName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public static final EntityManager getPhoneEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitPhoneDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void persist(Object entity) {
		entityManager.persist(entity);
	}
	
	public void begin() {
		entityManager.getTransaction().begin();
	}
	public void commit() {
		entityManager.getTransaction().commit();
	}
	public void rollback() {
		entityManager.getTransaction().rollback();
	}
	
	public void create() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitPhoneDB");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
